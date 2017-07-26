package com.barkou.xml_parser.dom;

import java.io.IOException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {

		DOMRunner domRunner = new DOMRunner();
		try {
			domRunner.run();
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
