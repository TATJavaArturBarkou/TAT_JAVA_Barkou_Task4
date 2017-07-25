package by.epam.barkou.controller.command.command_xml_supplier;

import java.util.ArrayList;
import java.util.HashMap;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.command.CommandName;
import by.epam.barkou.controller.command.command_xml_supplier.util.StringUtil;
import by.epam.barkou.controller.command.command_xml_supplier.xml_parser.XMLCommand;
import by.epam.barkou.controller.command.command_xml_supplier.xml_parser.XMLRunner;
import by.epam.barkou.controller.exception.ControllerException;

public class RepositoryInitializator {

	private final static String PATH_TO_COMMAND_IMPL = "by.epam.barkou.controller.command.impl.";

	public HashMap<CommandName, Command> init() throws ControllerException {
		HashMap<CommandName, Command> repository = null;
		try {

			repository = new HashMap<CommandName, Command>();

			ArrayList<XMLCommand> xmlCommands = XMLRunner.parseXML();

			for (int index = 0; index < xmlCommands.size(); index++) {
				String commandName = xmlCommands.get(index).getName();

				Class commandNameClazz = Class.forName(PATH_TO_COMMAND_IMPL + commandName);

				if (Command.class.isAssignableFrom(commandNameClazz)) {

					Command command = (Command) commandNameClazz.newInstance();

					commandName = StringUtil.convertCommandToEnumForm(commandName);

					CommandName commandNameENUM = CommandName.valueOf(commandName);
					repository.put(commandNameENUM, command);

				}

			}

		} catch (InstantiationException | SecurityException | IllegalAccessException | ClassNotFoundException e) {
			throw new ControllerException("Repository initialization error", e);

		}
		return repository;
	}

}
