package com.barkou.xml_parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.List;
import javax.xml.stream.XMLInputFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.barkou.xml_parser.Command;
import com.barkou.xml_parser.sax.Runner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String path = Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		final String pathToXml = "/resources/commands_list.xml";

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream(path + pathToXml);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Command> list = StAXMenuParser.process(reader);
			for (Command command : list) {
				System.out.println(command.getName());

			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
