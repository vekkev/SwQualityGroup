package org.se.lab;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart
{
	/*
	 * Property: id
	 */
	public int id;
	
	/*
	 * Property: articles
	 */
	public ArrayList articles = new ArrayList();

	
	public String toString()
	{
		String s = "Cart: " + id + "\n";
		for(Iterator it = articles.iterator(); it.hasNext();)
		{
			Article a = (Article)it.next();	
			switch(a.type)
			{
				case BOOK:
					s += "BOOK:\t" + a.id + "\t" + a.description + "\t" + a.author + "\t" + a.price + "\n";
				break;
				
				case CD:
					s += "CD:\t" + a.id + "\t" + a.description + "\t" + a.price + "\n";
				break;
				
				case DVD:
					s += "DVD:\t" + a.id + "\t" + a.description + "\t" + a.price + "\n";
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
			switch(a.type)
			{
				case BOOK:
					xml += "\t<book id=\"" + a.id + "\" description=\"" + a.description 
							+ "\" price=\"" + a.price  
							+ "\" author=\"" + a.author + "\"/>\n";
				break;
				
				case CD:
					xml += "\t<cd id=\"" + a.id + "\" description=\"" + a.description 
						+ "\" price=\"" + a.price + "\"/>\n";
				break;
				
				case DVD:
					xml += "\t<dvd id=\"" + a.id + "\" description=\"" + a.description 
					+ "\" price=\"" + a.price + "\"/>\n";
				break;
			}
		}				
		xml += "</shoppingcard>";
		return xml;
	}
}
