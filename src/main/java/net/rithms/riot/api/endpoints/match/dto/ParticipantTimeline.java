/*
 * Copyright 2014 Taylor Caldwell
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

package net.rithms.riot.api.endpoints.match.dto;

import java.io.Serializable;
import java.util.Map;

import net.rithms.riot.api.Dto;

public class ParticipantTimeline extends Dto implements Serializable {

	private static final long serialVersionUID = -6355300896423737331L;

	private Map<String, Double> creepsPerMinDeltas;
	private Map<String, Double> csDiffPerMinDeltas;
	private Map<String, Double> damageTakenDiffPerMinDeltas;
	private Map<String, Double> damageTakenPerMinDeltas;
	private Map<String, Double> goldPerMinDeltas;
	private String lane;
	private int participantId;
	private String role;
	private Map<String, Double> xpDiffPerMinDeltas;
	private Map<String, Double> xpPerMinDeltas;

	public Map<String, Double> getCreepsPerMinDeltas() {
		return creepsPerMinDeltas;
	}

	public Map<String, Double> getCsDiffPerMinDeltas() {
		return csDiffPerMinDeltas;
	}

	public Map<String, Double> getDamageTakenDiffPerMinDeltas() {
		return damageTakenDiffPerMinDeltas;
	}

	public Map<String, Double> getDamageTakenPerMinDeltas() {
		return damageTakenPerMinDeltas;
	}

	public Map<String, Double> getGoldPerMinDeltas() {
		return goldPerMinDeltas;
	}

	public String getLane() {
		return lane;
	}

	public int getParticipantId() {
		return participantId;
	}

	public String getRole() {
		return role;
	}

	public Map<String, Double> getXpDiffPerMinDeltas() {
		return xpDiffPerMinDeltas;
	}

	public Map<String, Double> getXpPerMinDeltas() {
		return xpPerMinDeltas;
	}
}