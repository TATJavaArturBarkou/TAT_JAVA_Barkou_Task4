package com.barkou.xml_parser.marshalling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.barkou.xml_parser.sax.Runner;

public class CommandJAXBMarshaller {

	private static final String PATH_TO_HML = "/resources/commands_list.xml";
	private static final String PATH = Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	private static final String ADD_USER_COMMAND = "addUser";

	public void unMarsh() {
		Command command = null;

		try {
			File file = new File(PATH + PATH_TO_HML);
			JAXBContext jaxbContext = JAXBContext.newInstance(Command.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			command = (Command) jaxbUnmarshaller.unmarshal(file);		
		
		} catch (JAXBException e) {

			e.printStackTrace();
		}

	}

	public void marsh() throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Command.class);
		Marshaller m = context.createMarshaller();

		Command command = new Command();

		command.getCommand().add(ADD_USER_COMMAND);

		m.marshal(command, new FileOutputStream(PATH + PATH_TO_HML));
		m.marshal(command, System.out);

	}
}
