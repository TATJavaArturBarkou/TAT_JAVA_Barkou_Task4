package by.epam.barkou.controller.command.command_xml_supplier.xml_parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.barkou.controller.exception.ControllerException;

public class XMLRunner {

	private final static String PATH_TO_XML = "/resources/commands_list.xml";

	public static ArrayList<XMLCommand> parseXML() throws ControllerException {
		String path = XmlHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath();

		XmlHandler xml = null;
		try {
			// Создаём SAX-парсер
			XMLReader xr = XMLReaderFactory.createXMLReader();
			// Устанавливаем обработчик SAX-событий
			xml = new XmlHandler();
			xr.setContentHandler(xml);
			// Парсим XML-файл

			xr.parse(new InputSource(new FileReader(path + PATH_TO_XML)));
		} catch (IOException | SAXException e) {
			throw new ControllerException("Error while file parsing", e);
		}

		return xml.getCommandsList();
	}
}
