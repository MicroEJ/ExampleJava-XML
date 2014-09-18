/*
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.is2t.examples.xml.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Provides facilities to parse XML using a pull parser.
 */
public class XmlPullParserHelper {

	/**
	 * Default printer encoding: UTF-8.
	 * 
	 * @see String#String(byte[], String)
	 */
	public static final String DEFAULT_ENCODING = "utf-8"; //$NON-NLS-1$

	/**
	 * Creates a new {@link XmlPullParser} with the given XML.
	 * 
	 * @param factory
	 *            the factory to create the XML parser.
	 * @param inputStream
	 *            the XML input stream to parse.
	 * @return a new parser.
	 * @throws XmlPullParserException
	 *             if a parsing error occurs.
	 * @throws IOException
	 *             if an error occurs while reading.
	 */
	public static XmlPullParser createParser(XmlPullParserFactory factory, InputStream inputStream)
			throws XmlPullParserException, IOException {
		XmlPullParser parser = factory.newPullParser();
		parser.setInput(inputStream, DEFAULT_ENCODING);

		// move to start tag
		parser.nextTag();

		return parser;
	}

	/**
	 * Parses a simple node in the form: <name>value</name> with "name" the node name and "value" the value.
	 * 
	 * @param parser
	 *            the parser.
	 * @param nodeName
	 *            the expected name of the node.
	 * @return the node value.
	 * @throws XmlPullParserException
	 *             if a parsing error occurs.
	 * @throws IOException
	 *             if an error occurs while reading.
	 */
	public static String parseSimpleNodeWithText(XmlPullParser parser, String nodeName) throws XmlPullParserException,
			IOException {
		parser.require(XmlPullParser.START_TAG, null, nodeName);

		parser.next();
		String result = parseText(parser);

		parser.require(XmlPullParser.END_TAG, null, nodeName);
		return result;
	}

	/**
	 * Parses a simple node in the form: <name attr1="value1" attr2="value2" ...></name> with "name" the node name and
	 * attrX="valueX" the attributes.
	 * 
	 * @param parser
	 *            the parser.
	 * @param nodeName
	 *            the expected name of the node.
	 * @return the node value.
	 * @throws XmlPullParserException
	 *             if a parsing error occurs.
	 * @throws IOException
	 *             if an error occurs while reading.
	 */
	public static HashMap<String, String> parseSimpleNodeWithAttributes(XmlPullParser parser, String nodeName)
			throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, nodeName);
		HashMap<String, String> attributes = XmlPullParserHelper.parseAttributes(parser);
		parser.nextTag();

		parser.require(XmlPullParser.END_TAG, null, nodeName);
		return attributes;
	}

	/**
	 * Parses a CDATA text.
	 * 
	 * @param parser
	 *            the parser.
	 * @return the text.
	 * @throws XmlPullParserException
	 *             if a parsing error occurs.
	 * @throws IOException
	 *             if an error occurs while reading.
	 */
	public static String parseText(XmlPullParser parser) throws XmlPullParserException, IOException {
		String result;
		if (parser.getEventType() == XmlPullParser.TEXT) {
			result = parser.getText().trim();
			parser.next();
		} else {
			// no text
			result = ""; //$NON-NLS-1$
		}
		return result;
	}

	/**
	 * Parses the attributes of a node.
	 * 
	 * @param parser
	 *            the parser.
	 * @return a hashtable containing the attributes.
	 */
	public static HashMap<String, String> parseAttributes(XmlPullParser parser) {
		int attributeCount = parser.getAttributeCount();
		HashMap<String, String> attributes = new HashMap<>(attributeCount);
		for (int i = -1; ++i < attributeCount;) {
			attributes.put(parser.getAttributeName(i), parser.getAttributeValue(i));
		}
		return attributes;
	}

	private XmlPullParserHelper() {
	}

}
