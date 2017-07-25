package com.barkou.xml_parser.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.barkou.xml_parser.Command;
import com.barkou.xml_parser.sax.Runner;

public class DOMRunner {

	private final static String PATH_TO_XML = "/resources/commands_list.xml";
	private final static String COMMAND_TAG_NAME = "command";

	public List<Command> run() throws SAXException, IOException {

		// создание xerces

		DOMParser parser = new DOMParser();

		String path = Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath();

		parser.parse(path + PATH_TO_XML);

		Document document = parser.getDocument();

		Element root = document.getDocumentElement();
		List<Command> commandList = new ArrayList<Command>();

		NodeList commandNodes = root.getElementsByTagName(COMMAND_TAG_NAME);

		Command command = null;
		for (int i = 0; i < commandNodes.getLength(); i++) {
			command = new Command();
			Element commandElement = (Element) commandNodes.item(i);

			command.setName(commandElement.getTextContent().trim());

			commandList.add(command);
		}

		return commandList;
	}
}
