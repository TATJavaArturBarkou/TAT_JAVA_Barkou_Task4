package com.barkou.xml_parser.marshalling;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "commands", namespace = "http://www.barkou.com/command")
public class Command {


	private ArrayList<String> commandList = new ArrayList<>();

	public ArrayList<String> getCommand() {
		return commandList;
	}

	public void setCommand(ArrayList<String> command) {
		this.commandList = command;
	}

	public void addCommand() {

	}

}
