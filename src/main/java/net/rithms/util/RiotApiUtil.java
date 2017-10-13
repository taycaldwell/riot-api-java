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

package net.rithms.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.rithms.riot.api.RiotApi;

public final class RiotApiUtil {

	private static final Pattern SUMMONER_NAME_VALIDATOR = Pattern.compile("^[0-9\\p{L} _.]+$");
	
	/**
	 * Normalizes and returns a summoner name. Specifically, this casts {@code String summonerName} to lower case and strips any
	 * whitespaces.
	 * 
	 * @param summonerName
	 *            summoner name
	 * @return Normalized summoner name
	 * @throws NullPointerException
	 *             If {@code summonerName} is {@code null}
	 */
	public static String normalizeSummonerName(String summonerName) {
		Objects.requireNonNull(summonerName);
		summonerName = summonerName.replaceAll("\u0130", "i"); // LATIN CAPITAL LETTER I DOT
		return summonerName.toLowerCase().replaceAll("\\s+", "");
	}

	/**
	 * Normalizes and returns an array of summoner names. Specifically, this casts each of {@code String[] summonerNames} to lower case and
	 * strips any whitespaces.
	 * 
	 * @param summonerNames
	 *            summoner names
	 * @return Normalized summoner names
	 * @throws NullPointerException
	 *             If {@code summonerNames} is {@code null}
	 */
	public static String[] normalizeSummonerNames(String... summonerNames) {
		Objects.requireNonNull(summonerNames);

		// Java 8
		// return Arrays.stream(summonerNames).map(s -> normalizeSummonerName(s)).toArray(size -> new String[size]);

		// Java 7
		for (int i = 0; i < summonerNames.length; i++) {
			summonerNames[i] = normalizeSummonerName(summonerNames[i]);
		}
		return summonerNames;
	}

	/**
	 * Normalizes and returns a map with summoner name keys. This casts each of the keys of {@code Map<String, T> map} to lower case and
	 * strips any whitespaces.
	 * 
	 * @param summonerNames
	 *            map with summoner name keys
	 * @return Normalized map with summoner name keys
	 * @throws NullPointerException
	 *             If {@code summonerNames} is {@code null}
	 */
	public static <T> Map<String, T> normalizeSummonerNames(Map<String, T> summonerNames) {
		Objects.requireNonNull(summonerNames);
		Map<String, T> map = new HashMap<String, T>(summonerNames);

		// Java 8
		// map = map.entrySet().stream().collect(Collectors.toMap(p -> normalizeSummonerName(p.getKey()), p -> p.getValue()));

		// Java 7
		Iterator<Map.Entry<String, T>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, T> pair = (Map.Entry<String, T>) it.next();
			String normalizedKey = normalizeSummonerName(pair.getKey());
			if (!pair.getKey().equals(normalizedKey)) {
				it.remove();
				map.put(normalizedKey, pair.getValue());
			}
		}
		return map;
	}

	/**
	 * Returns a new String composed of copies of the {@code elements} joined together with a copy of the specified {@code delimiter}.
	 *
	 * Note that if an element is null, then {@code "null"} is added.
	 *
	 * @param delimiter
	 *            the delimiter that separates each element
	 * @param elements
	 *            the elements to join together
	 * @return a new {@code String} that is composed of the {@code elements} separated by the {@code delimiter}
	 * @throws NullPointerException
	 *             If {@code delimiter} or {@code elements} is {@code null}
	 */
	public static String joinString(CharSequence delimiter, Object... elements) {
		Objects.requireNonNull(delimiter);
		Objects.requireNonNull(elements);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.length - 1; i++) {
			sb.append(elements[i]).append(delimiter);
		}
		sb.append(elements[elements.length - 1]);
		return sb.toString();
	}

	/**
	 * Returns a new String composed of copies of the {@code elements} joined together with a copy of the specified {@code delimiter}.
	 *
	 * Note that if an element is null, then {@code "null"} is added.
	 *
	 * @param delimiter
	 *            the delimiter that separates each element
	 * @param elements
	 *            the elements to join together
	 * @return a new {@code String} that is composed of the {@code elements} separated by the {@code delimiter}
	 * @throws NullPointerException
	 *             If {@code delimiter} or {@code elements} is {@code null}
	 */
	public static String joinString(CharSequence delimiter, CharSequence... elements) {
		return joinString(delimiter, (Object[]) elements);
	}

	/**
	 * Checks that the specified String is not an invalid summoner name. This method is designed primarily to be called by the
	 * {@link RiotApi} to check the validity of a summoner name before firing a request to the Riot Api.
	 * 
	 * @param summonerName
	 *            The summoner name to to check for validity
	 * @throws IllegalArgumentException
	 *             If {@code summonerName} is not valid
	 * @return {@code summonerName} if not invalid
	 */
	public static String requireValidSummonerName(String summonerName) throws IllegalArgumentException {
		Matcher summonerMatch = SUMMONER_NAME_VALIDATOR.matcher(summonerName);
		
		if (summonerName.trim().isEmpty() || !summonerMatch.matches()) {
			throw new IllegalArgumentException("Invalid summoner name \"" + summonerName + "\"");
		}
		return summonerName;
	}
}