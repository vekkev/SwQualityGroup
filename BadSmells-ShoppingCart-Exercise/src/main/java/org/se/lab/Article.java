package org.se.lab;

public class Article
{
	enum Type {BOOK, CD, DVD};
	
	/*
	 * Property: id
	 */
	public int id;
	
	/*
	 * Property: type
	 */
	public Type type;
	
	/*
	 * Property: description
	 */
	public String description;

	/*
	 * Property: author
	 */
	public String author;	// Temporary Field
	
	/*
	 * Property: price
	 */
	public double price;
}
