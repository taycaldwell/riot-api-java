package net.rithms.util;

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

	public static String longToString(long... input) {
		// Java 8
		// return Arrays.stream(input).mapToObj(l -> ((Long) l).toString()).collect(Collectors.joining(","));

		// Java 7
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length - 1; i++) {
			sb.append(input[i]).append(",");
		}
		sb.append(input[input.length - 1]);
		return sb.toString();
	}

	public static String normalizeSummonerName(String summonerName) {
		// Note for contributors: If you change this, don't strip commas! It could break comma-separated lists of summonerNames
		return summonerName.toLowerCase().replaceAll("\\s+", "");
	}

	public static String[] normalizeSummonerNames(String... summonerNames) {
		// Java 8
		// return Arrays.stream(summonerNames).map(s -> normalizeSummonerName(s)).toArray(size -> new String[size]);

		// Java 7
		for (int i = 0; i < summonerNames.length; i++) {
			summonerNames[i] = normalizeSummonerName(summonerNames[i]);
		}
		return summonerNames;
	}

	public static String joinString(String separator, String... strings) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length - 1; i++) {
			sb.append(strings[i]).append(separator);
		}
		sb.append(strings[strings.length - 1]);
		return sb.toString();
	}
}