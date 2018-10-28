package org.se.lab;

import java.util.ArrayList;

class ShoppingCart
{
	private int id;
	private final ArrayList<Article> articles = new ArrayList<>();

	void add(Article article){
		articles.add(article);
	}

	void setId(int id) {
		this.id = id;
	}

    @Override
	public String toString()
	{
		StringBuilder s = new StringBuilder("Cart: " + id + "\n");
        for (Article article : articles) {
            s.append(article.toString());
        }
		return s.toString();
	}

	String toXml()
	{
		StringBuilder xml = new StringBuilder("<shoppingcart id=\"" + id + "\">\n");
        for (Article article : articles) {
           xml.append(article.toXML());
        }
		xml.append("</shoppingcart>");
		return xml.toString();
	}
}
