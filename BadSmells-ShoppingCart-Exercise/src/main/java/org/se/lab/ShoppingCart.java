package org.se.lab;

import java.util.ArrayList;

//testkommentarff

class ShoppingCart
{
	private int id;
	final ArrayList<Article> articles = new ArrayList<>();

	
	public String toString()
	{
		StringBuilder s = new StringBuilder("Cart: " + id + "\n");
        for (Object article : articles) {
            Article a = (Article) article;
            switch (a.getType()) {
                case BOOK:
                    s.append("BOOK:\t").append(a.getId()).append("\t").append(a.getDescription()).append("\t").append(a.getAuthor()).append("\t").append(a.getPrice()).append("\n");
                    break;

                case CD:
                    s.append("CD:\t").append(a.getId()).append("\t").append(a.getDescription()).append("\t").append(a.getPrice()).append("\n");
                    break;

                case DVD:
                    s.append("DVD:\t").append(a.getId()).append("\t").append(a.getDescription()).append("\t").append(a.getPrice()).append("\n");
                    break;
            }
        }
		return s.toString();
	}
	
	
	public String toXml()
	{
		StringBuilder xml = new StringBuilder("<shoppingcard id=\"" + id + "\">\n");
        for (Object article : articles) {
            Article a = (Article) article;
            switch (a.getType()) {
                case BOOK:
                    xml.append("\t<book id=\"").append(a.getId()).append("\" description=\"").append(a.getDescription()).append("\" price=\"").append(a.getPrice()).append("\" author=\"").append(a.getAuthor()).append("\"/>\n");
                    break;

                case CD:
                    xml.append("\t<cd id=\"").append(a.getId()).append("\" description=\"").append(a.getDescription()).append("\" price=\"").append(a.getPrice()).append("\"/>\n");
                    break;

                case DVD:
                    xml.append("\t<dvd id=\"").append(a.getId()).append("\" description=\"").append(a.getDescription()).append("\" price=\"").append(a.getPrice()).append("\"/>\n");
                    break;
            }
        }
		xml.append("</shoppingcard>");
		return xml.toString();
	}

    public void setId(int id) {
        this.id = id;
    }
}
