package org.se.lab;

public class DVD extends Article {

    public DVD(int id, String string, double price) {
        super(id, string, price);
    }

    @Override
    public String toString() {
        return "DVD:\t" + super.toString();
    }

    @Override
    public String toXML(){
        return "\t<dvd " + super.toXML() + "/>\n";
    }
}
