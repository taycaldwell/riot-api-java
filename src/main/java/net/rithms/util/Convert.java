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

import java.util.Objects;

public final class Convert {

	/**
	 * Returns a new String composed of copies of the {@code long elements} joined together with a comma as separator.
	 * 
	 * @param elements
	 *            the elements to join together
	 * @return Comma-separated String of numbers
	 * @throws NullPointerException
	 *             If {@code elements} is {@code null}
	 */
	public static String longToString(long... elements) {
		Objects.requireNonNull(elements);
		// Java 8
		// return Arrays.stream(elements).mapToObj(l -> ((Long) l).toString()).collect(Collectors.joining(","));

		// Java 7
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.length - 1; i++) {
			sb.append(elements[i]).append(',');
		}
		sb.append(elements[elements.length - 1]);
		return sb.toString();
	}

	/**
	 * Normalizes and returns a summoner name. This casts {@code String summonerName} to lower case and strips any whitespaces.
	 * 
	 * @param summonerName
	 *            summoner name
	 * @return Normalized summoner name
	 * @throws NullPointerException
	 *             If {@code summonerName} is {@code null}
	 */
	public static String normalizeSummonerName(String summonerName) {
		Objects.requireNonNull(summonerName);
		// Note for contributors: If you change this, don't strip commas! It could break comma-separated lists of summonerNames
		return summonerName.toLowerCase().replaceAll("\\s+", "");
	}

	/**
	 * Normalizes and returns an array of summoner names. This casts each of {@code String[] summonerNames} to lower case and strips any
	 * whitespaces.
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
}