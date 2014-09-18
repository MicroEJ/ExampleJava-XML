/*
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.is2t.examples.xml;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import com.is2t.examples.xml.model.Poem;
import com.is2t.examples.xml.util.XMLPoemReader;

/**
 * Reads a poem and print it on the console.
 */
public class ReadPoem {

	private static final String ROSES_XML = "/xml/roses.xml"; //$NON-NLS-1$

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
