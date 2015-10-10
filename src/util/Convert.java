package util;

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

public final class Convert {

	public static String longToString(long... summonerIds) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < summonerIds.length - 1; i++) {
			if (!String.valueOf(summonerIds[i]).matches(" *")) {
				sb.append(summonerIds[i]);
				sb.append(',');
			}
		}
		sb.append(summonerIds[summonerIds.length - 1]);
		return sb.toString();
	}
}