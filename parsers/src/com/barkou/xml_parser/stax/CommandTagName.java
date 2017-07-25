package com.barkou.xml_parser.stax;

public enum CommandTagName {

	COMMAND, COMMANDS;

	public static CommandTagName getElementTagName(String element) {
		final String tagCommand = "command";
		final String tagCommands = "commands";

		switch (element) {
		case tagCommand:
			return COMMAND;
		case tagCommands:
			return COMMANDS;
		default:
			throw new EnumConstantNotPresentException(CommandTagName.class, element);
		}
	}
}