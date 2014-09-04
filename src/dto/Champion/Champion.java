package dto.Champion;

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

public class Champion {
	
	private boolean active, botEnabled, botMmEnabled, freeToPlay, rankedPlayEnabled;
	private long id;
	
	public boolean isBotEnabled() {
		return botEnabled;
	}
	public void setBotEnabled(boolean botEnabled) {
		this.botEnabled = botEnabled;
	}
	public boolean isActive() {
		return active;
	}
	
	public boolean isFreeToPlay() {
		return freeToPlay;
	}
	
	public boolean isRankedPlayEnabled() {
		return rankedPlayEnabled;
	}

	public boolean isBotMmEnabled() {
		return botMmEnabled;
	}
	
	public long getId() {
		return id;
	}


}
