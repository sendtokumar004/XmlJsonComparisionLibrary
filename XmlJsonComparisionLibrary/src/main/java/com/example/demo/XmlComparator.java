package com.example.demo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlComparator implements IResponseComparator<String, String> {

	@Override
	public boolean compare(String url1, String url2) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setCoalescing(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setIgnoringComments(true);
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc1 = db.parse((url1));
			doc1.normalizeDocument();

			Document doc2 = db.parse((url2));
			doc2.normalizeDocument();
			return doc1.isEqualNode(doc2);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			return false;
		}
	}

}
