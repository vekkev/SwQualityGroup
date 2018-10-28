package org.se.lab;

public class CD extends Article{

    public CD(int id, String string, double price) {
        super(id, string, price);
    }

    @Override
    public String toString() {
        return "CD:\t" + super.toString();
    }

    @Override
    public String toXML(){
        return "\t<cd " + super.toXML() + "/>\n";
    }
}
