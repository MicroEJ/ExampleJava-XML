/*
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.is2t.examples.xml.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.is2t.examples.xml.model.Poem;

/**
 * Convenience class for reading a XML poem and creating a {@link Poem} model.
 */
public class XMLPoemReader {

	private static final String POEM = "poem"; //$NON-NLS-1$
	private static final String TITLE = "title"; //$NON-NLS-1$
	private static final String LINE = "l"; //$NON-NLS-1$

	private XmlPullParserFactory factory;

	/**
	 * Creates a poem reader.
	 * 
	 * @throws XmlPullParserException
	 *             if the reader cannot be created.
	 */
	public XMLPoemReader() throws XmlPullParserException {
		factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
	}

	/**
	 * Parses a XML from a file resource and returns the matching poem.
	 * 
	 * @param xmlFile
	 *            the XML file to parse.
	 * @return the poem model.
	 * @throws XmlPullParserException
	 *             if the XML file is not correctly formatted.
	 * @throws IOException
	 *             if the XML file cannot be read.
	 * @see Class#getResourceAsStream(String)
	 */
	public Poem parse(String xmlFile) throws XmlPullParserException, IOException {
		InputStream inputStream = getClass().getResourceAsStream(xmlFile);
		return parse(inputStream);
	}

	/**
	 * Parses a XML from an input stream and returns the matching poem.
	 * 
	 * @param inputStream
	 *            the XML input stream to parse.
	 * @return the poem model.
	 * @throws XmlPullParserException
	 *             if the XML file is not correctly formatted.
	 * @throws IOException
	 *             if the XML file cannot be read.
	 * @see Class#getResourceAsStream(String)
	 */
	public Poem parse(InputStream inputStream) throws XmlPullParserException, IOException {
		XmlPullParser parser = XmlPullParserHelper.createParser(factory, inputStream);

		// check poem tag
		parser.require(XmlPullParser.START_TAG, null, POEM);
		// go to next tag
		parser.nextTag();

		// read title
		String title = XmlPullParserHelper.parseSimpleNodeWithText(parser, TITLE);
		// go to next tag
		parser.nextTag();

		ArrayList<String> linesList = new ArrayList<>();

		while (LINE.equals(parser.getName())) {
			// read line
			String line = XmlPullParserHelper.parseSimpleNodeWithText(parser, LINE);
			linesList.add(line);
			// go to next tag
			parser.nextTag();
		}

		// check poem tag
		parser.require(XmlPullParser.END_TAG, null, POEM);

		Poem poem = new Poem(title, linesList.toArray(new String[linesList.size()]));

		return poem;
	}

}
