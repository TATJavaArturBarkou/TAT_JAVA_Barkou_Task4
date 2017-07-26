package com.barkou.xml_parser.stax;

import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.barkou.xml_parser.Command;


public class StAXMenuParser {

	static List<Command> process(XMLStreamReader reader) throws XMLStreamException {
		ArrayList<Command> list = new ArrayList<Command>();
		Command command = null;
		CommandTagName elementName = null;
		while (reader.hasNext()) {
			// определение типа "прочтённого" элемента (тега)
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = CommandTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case COMMAND:
					command = new Command();
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case COMMAND:
					command.setName(text);
					break;

				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = CommandTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case COMMAND:
					list.add(command);
				}
			}
		}
		return list;
	}
}
