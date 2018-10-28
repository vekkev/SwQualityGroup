package org.se.lab;

public class Book extends Article{

    private final String author;

    public Book(String author, int id, String string, double price) {
        super(id, string, price);
        this.author = author;
    }

    @Override
    public String toString() {
            return "BOOK:\t" + getId() +
                    "\t" + getDescription() +
                    "\t" + author +
                    "\t" + getPrice() +
                    "\n";
    }

    @Override
    public String toXML() {
        return "\t<book " + super.toXML() + " author=\"" + author + "\"/>\n";
    }
}
