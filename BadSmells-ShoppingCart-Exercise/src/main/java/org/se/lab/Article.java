package org.se.lab;

public class Article
{
	//enum Type {BOOK, CD, DVD}

	private int id;
	//private Type type;
	//private String description; // Bad Smell -> bad name convention
	private String description;
	//private String author;	// Temporary Field
	private double price;

	public Article(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
        builder.append("\t").append(description);
		builder.append("\t").append(price);
		builder.append("\n");

	    return builder.toString();
    }


    public String toXML(){
		StringBuilder builder = new StringBuilder();
		builder.append("id=\"" + id + "\"");
		builder.append(" ").append("description=\"" + description + "\"");
		builder.append(" ").append("price=\"" + price + "\"/>");
		builder.append("\n");

		return builder.toString();


	}
}
