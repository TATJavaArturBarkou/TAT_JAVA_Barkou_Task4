package com.barkou.xml_parser.sax;

import java.io.FileReader;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

	public static void main(String[] args) {
		final String pathToXml = "/resources/commands_list.xml";
		String path = Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try {
			// ������ SAX-������
			XMLReader xr = XMLReaderFactory.createXMLReader();
			// ������������� ���������� SAX-�������
			Runner xml = new Runner();
			xr.setContentHandler(xml);
			// ������ XML-����
			xr.parse(new InputSource(new FileReader(path + pathToXml)));

			xml.print_all();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
