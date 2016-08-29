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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * This class is the super class of all Dtos returned by the Riot Api and provides some basic methods.
 * 
 * @author Daniel 'Linnun' Figge
 */
public class Dto {

	/**
	 * Returns a string representation of the {@code Dto}. In general, the toString method returns a string that "textually represents" this
	 * object.
	 * 
	 * @param verbose
	 *            If true, all fields of the {@code Dto} will be returned. Otherwise, only the {@code Dto}'s normal {@code toString()}
	 *            method will be called.
	 * @return A string representation of the {@code Dto}.
	 */
	public String toString(boolean verbose) {
		return verbose ? toStringVerbosely(0) : toString();
	}

	/**
	 * Returns a string represantation of the {@code Dto} including all of its fields.
	 * <p>
	 * You should not call this method directly. Use {@link #toString(boolean verbose)} instead.
	 * </p>
	 * 
	 * @param depth
	 *            Depth for recursive calls
	 * @return A string representation of the {@code Dto}.
	 */
	public String toStringVerbosely(Integer depth) {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		// Class Start
		result.append(this.getClass().getName()).append(" {").append(newLine);

		// Fields
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			for (int i = 0; i < depth + 1; i++) {
				result.append("   ");
			}
			try {
				result.append(field.getName()).append(": ");
				if (field.getType().getSuperclass() != null && field.getType().getSuperclass().equals(Dto.class) && field.get(this) != null) {
					// Dto Field
					result.append((String) this.getClass().getMethod("toStringVerbosely", Integer.class).invoke(field.get(this), depth + 1));
				} else {
					// Non-Dto Field
					result.append(field.get(this));
				}
			} catch (InvocationTargetException e) {
				e.getTargetException().printStackTrace();
			} catch (IllegalAccessException | NoSuchMethodException e) {
				e.printStackTrace();
			}
			result.append(newLine);
		}

		// Class End
		for (int i = 0; i < depth; i++) {
			result.append("   ");
		}
		result.append("}");

		return result.toString();
	}
}