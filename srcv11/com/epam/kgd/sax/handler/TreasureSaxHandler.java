package com.epam.kgd.sax.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.kgd.bean.AncientBook;
import com.epam.kgd.bean.AncientScroll;
import com.epam.kgd.bean.Treasure;
//import com.epam.kgd.factory_method.Creator;
//import com.epam.kgd.factory_method.DefaultCreator;
import com.epam.kgd.util.BookType;
import com.epam.kgd.util.SchoolType;
import com.epam.kgd.util.TagName;

public class TreasureSaxHandler extends DefaultHandler {
	private List<Treasure> treasureList = new ArrayList<>();
	private Treasure treasure;
	private StringBuilder text;
	//private Creator creator = new DefaultCreator();

	public List<Treasure> getTreasureList() {
		return treasureList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing is started...");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing is ended");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		text = new StringBuilder();
		/*
		 * treasure = creator.createTreasure(qName); if (treasure != null) {
		 * treasure.setId(Integer.parseInt(attributes.getValue("id"))); return;
		 * } else {
		 * 
		 * }
		 */

		if (qName.equals("ancient_book")) {
			treasure = new AncientBook();
			treasure.setId(Integer.parseInt(attributes.getValue("id")));

		}
		if (qName.equals("ancient_scroll")) {
			treasure = new AncientScroll();
			treasure.setId(Integer.parseInt(attributes.getValue("id")));

		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase());
		switch (tagName) {
		// for abstract fields (commons fields for all classes)
		case TITLE:
			treasure.setTitle(text.toString());
			break;
		case AGE:
			treasure.setAge(Integer.parseInt(text.toString()));
			break;
		case PRICE:
			treasure.setPrice(Double.parseDouble(text.toString()));
			break;

		// for ancient book
		case TYPE:
			((AncientBook) treasure).setType(BookType.valueOf(text.toString().trim().toUpperCase().replace(' ', '_')));
			break;
		case PAGES:
			((AncientBook) treasure).setPages(Integer.parseInt(text.toString()));
			break;
		case LANQUAGE:
			((AncientBook) treasure).setLanguage(text.toString());
			break;

		// for ancient scroll
		case CONTENT:
			((AncientScroll) treasure).setContent(text.toString());
			break;
		case SCHOOL_OF_MAGIC:
			((AncientScroll) treasure)
					.setSchoolType(SchoolType.valueOf(text.toString().trim().toUpperCase().replace(' ', '_')));
			break;

		// for other and other subclasses
		/*
		* 
		*/

		case TREASURES:
			break;

		case ANCIENT_BOOK:
		case ANCIENT_SCROLL:
			// another subclasses
			treasureList.add(treasure);
			break;

		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void warning(SAXParseException e) {
		System.err.println("WARNING: line " + e.getLineNumber() + ":" + e.getMessage());
	}

	public void fatalError(SAXParseException e) throws SAXException {
		System.err.println("FATAL: line " + e.getLineNumber() + ":" + e.getMessage());
		throw (e);
	}
}
