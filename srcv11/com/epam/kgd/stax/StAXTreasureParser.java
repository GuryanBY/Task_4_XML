package com.epam.kgd.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.kgd.bean.AncientBook;
import com.epam.kgd.bean.AncientScroll;
import com.epam.kgd.bean.Treasure;
import com.epam.kgd.util.BookType;
import com.epam.kgd.util.SchoolType;
import com.epam.kgd.util.TagName;

public class StAXTreasureParser {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		InputStream input = new FileInputStream("src/xml_xsd/treasures.xml");
		XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

		List<Treasure> list = process(reader);
		for (Treasure t : list) {
			System.out.println(t.toString());
		}
	}

	@SuppressWarnings("incomplete-switch")
	private static List<Treasure> process(XMLStreamReader reader) throws XMLStreamException {
		List<Treasure> list = new ArrayList<>();
		Treasure treasure = null;
		TagName elementName = null;

		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = TagName.getTagName(reader.getLocalName());
				switch (elementName) {

				case ANCIENT_BOOK:
					treasure = new AncientBook();
					Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					treasure.setId(id);
					break;
				case ANCIENT_SCROLL:
					treasure = new AncientScroll();
					id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					treasure.setId(id);
					break;

				// another subclasses

				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				// for abstract fields (commons fields for all classes)
				case TITLE:
					treasure.setTitle(text);
					break;
				case AGE:
					treasure.setAge(Integer.parseInt(text));
					break;
				case PRICE:
					treasure.setPrice(Double.parseDouble(text));
					break;

				// for ancient book
				case TYPE:
					((AncientBook) treasure).setType(BookType.valueOf(text.trim().toUpperCase().replace(' ', '_')));
					break;
				case PAGES:
					((AncientBook) treasure).setPages(Integer.parseInt(text));
					break;
				case LANQUAGE:
					((AncientBook) treasure).setLanguage(text);
					break;

				// for ancient scroll
				case CONTENT:
					((AncientScroll) treasure).setContent(text);
					break;
				case SCHOOL_OF_MAGIC:
					((AncientScroll) treasure)
							.setSchoolType(SchoolType.valueOf(text.trim().toUpperCase().replace(' ', '_')));
					break;

				// for other and other subclasses

				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = TagName.getTagName(reader.getLocalName());
				switch (elementName) {

				case ANCIENT_BOOK:
					list.add(treasure);
					break;
				case ANCIENT_SCROLL:
					list.add(treasure);
					break;

				}
			}

		}
		return list;
	}
}
