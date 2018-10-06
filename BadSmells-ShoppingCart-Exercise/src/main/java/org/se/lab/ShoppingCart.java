package org.se.lab;

import java.util.ArrayList;
import java.util.Iterator;

class ShoppingCart
{
	private int id;
	final ArrayList articles = new ArrayList();

	
	public String toString()
	{
		String s = "Cart: " + id + "\n";
		for(Iterator it = articles.iterator(); it.hasNext();)
		{
			Article a = (Article)it.next();	
			switch(a.getType())
			{
				case BOOK:
					s += "BOOK:\t" + a.getId() + "\t" + a.getDescription() + "\t" + a.getAuthor() + "\t" + a.getPrice() + "\n";
				break;
				
				case CD:
					s += "CD:\t" + a.getId() + "\t" + a.getDescription() + "\t" + a.getPrice() + "\n";
				break;
				
				case DVD:
					s += "DVD:\t" + a.getId() + "\t" + a.getDescription() + "\t" + a.getPrice() + "\n";
				break;
			}
		}		
		return s;
	}
	
	
	public String toXml()
	{
		String xml = "<shoppingcard id=\"" + id + "\">\n";
		for(Iterator it = articles.iterator(); it.hasNext();)
		{
			Article a = (Article)it.next();	
			switch(a.getType())
			{
				case BOOK:
					xml += "\t<book id=\"" + a.getId() + "\" description=\"" + a.getDescription()
							+ "\" price=\"" + a.getPrice()
							+ "\" author=\"" + a.getAuthor() + "\"/>\n";
				break;
				
				case CD:
					xml += "\t<cd id=\"" + a.getId() + "\" description=\"" + a.getDescription()
						+ "\" price=\"" + a.getPrice() + "\"/>\n";
				break;
				
				case DVD:
					xml += "\t<dvd id=\"" + a.getId() + "\" description=\"" + a.getDescription()
					+ "\" price=\"" + a.getPrice() + "\"/>\n";
				break;
			}
		}				
		xml += "</shoppingcard>";
		return xml;
	}
}
