package org.se.lab;

public class DVD extends Article {

    public DVD(int id, String string, double price) {
        super(id, string, price);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DVD:\t");
        builder.append(super.toString());

        return builder.toString();
    }
}
