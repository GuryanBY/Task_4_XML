package com.epam.kgd.util;

public enum TagName {
	// abstract
	TITLE, AGE, PRICE,
	// subclass #1
	ANCIENT_BOOK,         TYPE, PAGES, LANQUAGE,
	// subclass #2
	ANCIENT_SCROLL,       CONTENT, SCHOOL_OF_MAGIC,

	TREASURES;

	public static TagName getTagName(String el) {

		switch (el) {
		// abstract
		case "title":
			return TITLE;
		case "age":
			return AGE;
		case "price":
			return PRICE;
		// subclass #1
		case "ancient_book":
			return ANCIENT_BOOK;
		case "type":
			return TYPE;
		case "pages":
			return PAGES;
		case "lanquage":
			return LANQUAGE;
		// subclass #2
		case "ancient_scroll":
			return ANCIENT_SCROLL;
		case "content":
			return CONTENT;
		case "school_of_magic":
			return SCHOOL_OF_MAGIC;

		case "treasures":
			return TREASURES;
		default:
			throw new EnumConstantNotPresentException(TagName.class, el);

		}
	}

}
