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

import java.util.logging.Level;

public class AsyncRequestPoolSupervisor extends Thread {

	private static final long IDLE_TIME_RESIGN = 5000;

	private final AsyncRequestPool pool;
	private long lastJob = 0;
	private boolean running = true;

	AsyncRequestPoolSupervisor(AsyncRequestPool pool) {
		super("Riot Api - Async Request Pool Supervisor Thread");
		this.pool = pool;
	}

	private void clearPool() {
		if (pool.getPoolSize() > 0) {
			pool.clearPool();
		}
	}

	private void pollQueue() {
		if (pool.getPoolSize() == pool.getMaxAsyncThreads()) {
			return;
		}
		for (int i = pool.getPoolSize(); i < pool.getMaxAsyncThreads(); i++) {
			if (pool.pollQueue()) {
				lastJob = System.currentTimeMillis();
			} else {
				break;
			}
		}
	}

	@Override
	public void run() {
		while (running) {
			clearPool();
			pollQueue();
			// Resign, if idle for a while
			if (lastJob + IDLE_TIME_RESIGN < System.currentTimeMillis()) {
				pool.resignSupervisor();
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				RiotApi.log.log(Level.WARNING, "Supervisor Sleep Interrupted", e);
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}