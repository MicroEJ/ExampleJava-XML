/*
 * Java
 *
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.examples.xml;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import com.microej.examples.xml.model.Poem;
import com.microej.examples.xml.util.XMLPoemReader;

/**
 * Reads a poem and print it on the console.
 */
public class ReadPoem {

	private static final String ROSES_XML = "/xml/poem.xml"; //$NON-NLS-1$

	/**
	 * Reads a poem and print it on the console.
	 *
	 * @param args
	 *            useless.
	 * @throws XmlPullParserException
	 *             if a problem occurs with the XML parser (configuration or parsing).
	 * @throws IOException
	 *             if the poem file cannot be read.
	 */
	public static void main(String[] args) throws XmlPullParserException, IOException {
		XMLPoemReader xmlReader = new XMLPoemReader();
		Poem poem = xmlReader.parse(ROSES_XML);
		System.out.println(poem);
	}

}
