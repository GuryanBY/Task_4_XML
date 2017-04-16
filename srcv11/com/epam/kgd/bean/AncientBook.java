package com.epam.kgd.bean;

import java.io.Serializable;

import com.epam.kgd.util.BookType;

public class AncientBook extends Treasure implements Serializable {

	private static final long serialVersionUID = 1L;

	private BookType type;
	private int pages;
	private String language;

	public AncientBook() {

	}

	public AncientBook(String title, int age, double price, BookType type, int pages, String language) {
		super(title, age, price);
		this.type = type;
		this.pages = pages;
		this.language = language;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + pages;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AncientBook other = (AncientBook) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (pages != other.pages)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AncientBook [type=" + type + ", pages=" + pages + ", language=" + language + ", id=" + super.getId()
				+ ", title=" + super.getTitle() + ", age=" + super.getAge() + ", price=" + super.getPrice() + "]";
	}
	
	

}
