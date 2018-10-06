package org.se.lab;

public class Article
{
	enum Type {BOOK, CD, DVD}

	private int id;
	private Type type;
	private String string;
	private String author;	// Temporary Field
	private double price;

	public Article() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return string;
	}

	public void setDescription(String description) {
		this.string = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
