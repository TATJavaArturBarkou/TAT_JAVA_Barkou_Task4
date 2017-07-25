package by.epam.barkou.controller.command.command_xml_supplier.xml_parser;

import org.xml.sax.*;
import org.xml.sax.helpers.*;



import java.io.*;
import java.util.*;

public class XmlHandler extends DefaultHandler {

	// обрабатываемая команда
	private XMLCommand currentCommand;

	private ArrayList<XMLCommand> arrayList = new ArrayList<>();

	// Буфер для сбора текстовых данных при анализе XML
	private CharArrayWriter contents = new CharArrayWriter();

	private final static String TAG_COMMAND ="command";
	
	// Реакция на обнаружение нового элемента
	public void startElement(String namespaceURI, String localName, String qName, Attributes attr) throws SAXException {
		// Очистка буфера текстовых данных
		contents.reset();

		// Если обнаружена новая комманда, создаём объект
		if (localName.equals(TAG_COMMAND)) {
			currentCommand = new XMLCommand();

		}

	}

	// Реакция на закрывающий тег элемента
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

		// Если закрывается комманда, добавляем ее в список
		if (localName.equals(TAG_COMMAND)) {
			currentCommand.setName(contents.toString());
			arrayList.add(currentCommand);
		}

	}

	// Реакция на обнаружение символьных данных
	public void characters(char[] ch, int start, int length) throws SAXException {
		contents.write(ch, start, length);
	}

	// Вывод информации обо всех людях
	public void print_all() {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).getName());
		}
	}
	public ArrayList <XMLCommand> getCommandsList(){
		return arrayList;
	}
	

}