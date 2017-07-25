package com.barkou.xml_parser.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import com.barkou.xml_parser.Command;

import java.io.*;
import java.util.*;

public class Runner extends DefaultHandler {

	// �������������� �������
	private Command currentCommand;

	private ArrayList<Command> arrayList = new ArrayList<>();

	// ����� ��� ����� ��������� ������ ��� ������� XML
	private CharArrayWriter contents = new CharArrayWriter();

	private final static String TAG_COMMAND ="command";
	
	// ������� �� ����������� ������ ��������
	public void startElement(String namespaceURI, String localName, String qName, Attributes attr) throws SAXException {
		// ������� ������ ��������� ������
		contents.reset();

		// ���� ���������� ����� ��������, ������ ������
		if (localName.equals(TAG_COMMAND)) {
			currentCommand = new Command();

		}

	}

	// ������� �� ����������� ��� ��������
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

		// ���� ����������� ��������, ��������� �� � ������
		if (localName.equals(TAG_COMMAND)) {
			currentCommand.setName(contents.toString());
			arrayList.add(currentCommand);
		}

	}

	// ������� �� ����������� ���������� ������
	public void characters(char[] ch, int start, int length) throws SAXException {
		contents.write(ch, start, length);
	}

	// ����� ����������
	public void print_all() {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).getName());
		}
	}

}