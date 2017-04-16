package com.epam.kgd.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.kgd.bean.AncientBook;
import com.epam.kgd.bean.AncientScroll;
import com.epam.kgd.bean.Treasure;
import com.epam.kgd.util.BookType;
import com.epam.kgd.util.SchoolType;

public class DOMTreasureParser {

	public static void main(String[] args) throws SAXException, IOException {
		DOMParser parser = new DOMParser();
		parser.parse("src/xml_xsd/treasures.xml");
		Document doc = parser.getDocument();

		Element root = doc.getDocumentElement();
		List<Treasure> list = new ArrayList<>();

		Treasure treasure = null;
		// AncientBook
		NodeList treasureNodes1 = root.getElementsByTagName("ancient_book");
		for (int i = 0; i < treasureNodes1.getLength(); i++) {
			treasure = new AncientBook();
			Element trElement = (Element) treasureNodes1.item(i);
			treasure.setId(Integer.parseInt(trElement.getAttribute("id")));

			treasure.setTitle(getSingleChild(trElement, "title").getTextContent().trim());
			treasure.setAge(Integer.parseInt(getSingleChild(trElement, "age").getTextContent().trim()));
			treasure.setPrice(Double.parseDouble(getSingleChild(trElement, "price").getTextContent().trim()));
			((AncientBook) treasure).setType(BookType.valueOf(
					getSingleChild(trElement, "type").getTextContent().trim().toUpperCase().replace(' ', '_')));
			((AncientBook) treasure)
					.setPages(Integer.parseInt(getSingleChild(trElement, "pages").getTextContent().trim()));
			((AncientBook) treasure).setLanguage(getSingleChild(trElement, "lanquage").getTextContent().trim());

			list.add(treasure);
		}

		// AncientScroll
		NodeList treasureNodes2 = root.getElementsByTagName("ancient_scroll");
		for (int i = 0; i < treasureNodes2.getLength(); i++) {
			treasure = new AncientScroll();
			Element trElement = (Element) treasureNodes2.item(i);
			treasure.setId(Integer.parseInt(trElement.getAttribute("id")));

			treasure.setTitle(getSingleChild(trElement, "title").getTextContent().trim());
			treasure.setAge(Integer.parseInt(getSingleChild(trElement, "age").getTextContent().trim()));
			treasure.setPrice(Double.parseDouble(getSingleChild(trElement, "price").getTextContent().trim()));
			((AncientScroll) treasure).setContent(getSingleChild(trElement, "content").getTextContent().trim());
			((AncientScroll) treasure).setSchoolType(SchoolType.valueOf(getSingleChild(trElement, "school_of_magic")
					.getTextContent().trim().toUpperCase().replace(' ', '_')));

			list.add(treasure);
		}

		for (Treasure tr : list) {
			System.out.println(tr.toString());
		}
	}

	public static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;

	}
}
