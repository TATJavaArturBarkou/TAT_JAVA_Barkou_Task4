package com.barkou.xml_parser.marshalling;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
	
		CommandJAXBMarshaller commandJAXBMarshaller = new CommandJAXBMarshaller();
		commandJAXBMarshaller.unMarsh();
	}

}
