package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest
{

	@Test
	public void testProductGetter()
	{
		Product book = new Product(1, "Programmieren lernen mit Java", 1990);
		
		Assert.assertEquals(1, book.getId());
	}

	@Test
	public void testProductToString()
	{
		Product book = new Product(1, "Programmieren lernen mit Java", 1990);
		
		Assert.assertEquals("1,Programmieren lernen mit Java,1990", book.toString());
	}
	
	
}
