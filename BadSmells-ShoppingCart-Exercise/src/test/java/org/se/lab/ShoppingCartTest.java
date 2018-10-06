package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.Article;
import org.se.lab.ShoppingCart;



public class ShoppingCartTest
{
	private ShoppingCart cart;
	
	@Before
	public void setup()
	{
		cart = new ShoppingCart();
		
		Article cd = new Article();
		cd.setType(Article.Type.CD);
		cd.setId(1);
		cd.setDescription("Rolling Stones");
		cd.setPrice(12.99);
		cart.articles.add(cd);
		
		Article book = new Article();
		book.setType(Article.Type.BOOK);
		book.setId(7);
		book.setAuthor("Martin Fowler");
		book.setDescription("Refactoring");
		book.setPrice(57.80);
		cart.articles.add(book);
		
		Article dvd = new Article();
		dvd.setType(Article.Type.DVD);
		dvd.setId(13);
		dvd.setDescription("ACDC Live");
		dvd.setPrice(24.90);
		cart.articles.add(dvd);
	}
	

	@Test
	public void testToString()
	{
		String s = cart.toString();		
	
		final String EXPECTED = 
				"Cart: 0\n" +
				"CD:	1	Rolling Stones	12.99\n" +
				"BOOK:	7	Refactoring	Martin Fowler	57.8\n" +
				"DVD:	13	ACDC Live	24.9\n";

		Assert.assertEquals(EXPECTED, s);
	}

	@Test
	public void testToXml()
	{
		String s = cart.toXml();		
		
		final String EXPECTED = 
				"<shoppingcard id=\"0\">\n" +
				"	<cd id=\"1\" description=\"Rolling Stones\" price=\"12.99\"/>\n" +
				"	<book id=\"7\" description=\"Refactoring\" price=\"57.8\" author=\"Martin Fowler\"/>\n" +
				"	<dvd id=\"13\" description=\"ACDC Live\" price=\"24.9\"/>\n" +
				"</shoppingcard>";
		
		Assert.assertEquals(EXPECTED, s);
	}
}
