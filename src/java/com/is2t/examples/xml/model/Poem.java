/*
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.is2t.examples.xml.model;

/**
 * Represents a poem with a title and several lines.
 */
public class Poem {

	private String title;
	private String[] lines;

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
		return title;
	}

	/**
	 * Gets the poem lines.
	 * 
	 * @return the lines
	 */
	public String[] getLines() {
		return lines;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		// add the title
		buffer.append(title).append('\n');
		// underline the title
		for (int i = -1; ++i < title.length();) {
			buffer.append('_');
		}
		buffer.append('\n').append('\n');
		// add lines
		for (int i = -1; ++i < lines.length;) {
			buffer.append(lines[i]).append('\n');
		}
		return buffer.toString();
	}
}
