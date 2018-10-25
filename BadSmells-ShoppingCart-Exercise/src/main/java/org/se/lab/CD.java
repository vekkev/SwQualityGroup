package org.se.lab;

public class CD extends Article{

    public CD(int id, String string, double price) {
        super(id, string, price);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CD:\t");
        builder.append(super.toString());

        return builder.toString();
    }
}
