package org.se.lab;

class Article
{
	private final int id;
	private final String description;
	private final double price;

	Article(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	int getId() {
		return id;
	}

	String getDescription() {
		return description;
	}

	double getPrice() {
		return price;
	}

    @Override
    public String toString() {
		return id + "\t" + description + "\t" + price + "\n";
    }

    public String toXML(){
        return "id=\"" + id +
                "\" description=\"" + description +
                "\" price=\"" + price +
                "\"";
	}
}
