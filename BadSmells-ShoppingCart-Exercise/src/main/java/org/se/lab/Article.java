package org.se.lab;

public class Article
{
	//enum Type {BOOK, CD, DVD}

	private int id;
	//private Type type;
	private String string;
	//private String author;	// Temporary Field
	private double price;

	public Article(int id, String string, double price) {
		this.id = id;
		this.string = string;
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return string;
	}

	public void setDescription(String description) {
		this.string = description;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        builder.append("\t").append(string);
		builder.append("\t").append(price);
		builder.append("\n");

	    return builder.toString();
    }


    public String toXML(){
		StringBuilder builder = new StringBuilder();
		builder.append("id=\"" + id + "\"");
		builder.append(" ").append("description=\"" + string + "\"");
		builder.append(" ").append("price=\"" + price + "\"/>");
		builder.append("\n");

		return builder.toString();


	}
}
