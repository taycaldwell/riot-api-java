/*
 * Copyright 2016 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.rithms.riot.api.request.AsyncRequest;

public class AsyncRequestPool {

	private final ApiConfig config;
	private final Queue<AsyncRequest> queue = new ConcurrentLinkedQueue<AsyncRequest>();
	private final List<AsyncRequest> pool = new ArrayList<AsyncRequest>();
	private AsyncRequestPoolSupervisor supervisor = null;

	AsyncRequestPool(ApiConfig config) {
		this.config = config;
	}

	public void add(AsyncRequest request) {
		queue.add(request);
		invokeSupervisor();
	}

	public void awaitAll() throws InterruptedException {
		if (pool.isEmpty() && queue.isEmpty()) {
			return;
		}
		List<AsyncRequest> pool = new ArrayList<AsyncRequest>(this.pool);
		for (AsyncRequest request : pool) {
			request.await();
		}
		List<AsyncRequest> queue = new ArrayList<AsyncRequest>(this.queue);
		for (AsyncRequest request : queue) {
			request.await();
		}
		// Repeat until queue and pool are empty
		clearPool();
		awaitAll();
	}

	public synchronized int clearPool() {
		int clearedFromPool = 0;
		Iterator<AsyncRequest> iterator = pool.iterator();
		while (iterator.hasNext()) {
			AsyncRequest request = iterator.next();
			if (request.isDone()) {
				iterator.remove();
				clearedFromPool++;
			}
		}
		return clearedFromPool;
	}

	int getMaxAsyncThreads() {
		if (config.getMaxAsyncThreads() > 0) {
			return config.getMaxAsyncThreads();
		}
		return Integer.MAX_VALUE;
	}

	public int getPoolSize() {
		return pool.size();
	}

	public int getQueueSize() {
		return queue.size();
	}

	private void invokeSupervisor() {
		if (supervisor == null) {
			supervisor = new AsyncRequestPoolSupervisor(this);
			supervisor.start();
		}
	}

	public boolean pollQueue() {
		if (getPoolSize() == getMaxAsyncThreads()) {
			return false;
		}
		AsyncRequest request = queue.poll();
		if (request == null) {
			return false;
		}
		request.execute();
		pool.add(request);
		return true;
	}

	void resignSupervisor() {
		supervisor.shutdown();
		supervisor = null;
	}
}