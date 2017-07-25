package by.epam.barkou.controller.command;

import java.util.HashMap;

import by.epam.barkou.controller.command.command_xml_supplier.RepositoryInitializator;
import by.epam.barkou.controller.exception.ControllerException;

public class CommandProvider {
	private static HashMap<CommandName, Command> repository;
	private static CommandProvider commandProvider = null;

	private CommandProvider() {

	}

	public static CommandProvider getInstance() throws ControllerException {
		if (commandProvider != null) {
			return commandProvider;
		} else {
			RepositoryInitializator initializator = new RepositoryInitializator();
			repository = initializator.init();
			commandProvider = new CommandProvider();
			
			return commandProvider;
		}

	}

	public Command getCommand(String name) {

		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}

		return command;
	}

}
