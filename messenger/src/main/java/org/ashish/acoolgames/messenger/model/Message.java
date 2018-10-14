package org.ashish.acoolgames.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	Long id;
	String body;
	Author author;
	Date created = new Date();
	
	public Message() {

	}
	
	public Message(Long id, String body, Author author) {
		super();
		this.id = id;
		this.body = body;
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", body=" + body + ", author=" + author
				+ ", created=" + created + "]";
	}
}
