package com.epam.kgd.bean;

import java.io.Serializable;

import com.epam.kgd.util.SchoolType;

public class AncientScroll extends Treasure implements Serializable {
	private static final long serialVersionUID = 1L;

	private String content;
	private SchoolType schoolType;

	public AncientScroll() {

	}

	public AncientScroll(String title, int age, double price, String content, SchoolType schoolType) {
		super(title, age, price);
		this.content = content;
		this.schoolType = schoolType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SchoolType getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(SchoolType schoolType) {
		this.schoolType = schoolType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((schoolType == null) ? 0 : schoolType.hashCode());
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
		AncientScroll other = (AncientScroll) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (schoolType != other.schoolType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AncientScroll [content=" + content + ", schoolType=" + schoolType + ", id=" + super.getId() + ", title="
				+ super.getTitle() + ", age=" + super.getAge() + ", price=" + super.getPrice() + "]";
	}

}
