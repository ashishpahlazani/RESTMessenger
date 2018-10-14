package org.ashish.acoolgames.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author {
	String name;
	String designation;
	String about;

	public Author() {
	}

	public Author(String name, String designation, String about) {
		super();
		this.name = name;
		this.designation = designation;
		this.about = about;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", designation=" + designation
				+ ", about=" + about + "]";
	}
}
