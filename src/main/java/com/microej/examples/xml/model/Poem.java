/*
 * Java
 *
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.examples.xml.model;

/**
 * Represents a poem with a title and several lines.
 */
public class Poem {

	private final String title;
	private final String[] lines;

	/**
	 * Creates a poem.
	 *
	 * @param title
	 *            the poem title.
	 * @param lines
	 *            the poem lines.
	 */
	public Poem(String title, String[] lines) {
		this.title = title;
		this.lines = lines;
	}

	/**
	 * Gets the poem title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the poem lines.
	 *
	 * @return the lines
	 */
	public String[] getLines() {
		return this.lines;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		// add the title
		buffer.append(this.title).append('\n');
		// underline the title
		for (int i = -1; ++i < this.title.length();) {
			buffer.append('_');
		}
		buffer.append('\n').append('\n');
		// add lines
		for (int i = -1; ++i < this.lines.length;) {
			buffer.append(this.lines[i]).append('\n');
		}
		return buffer.toString();
	}
}