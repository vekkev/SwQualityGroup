package org.se.lab;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddOrderTest
{
	private Order order;
	
	
	@Before
	public void setup()
	{
		order = new Order();		
		
	}
	
	
	// Version 1: use a single test method for each test case

	@Test
	public void testArticleNr_Min()
	{
		order.addOrder(5, 0);
	}
	
	@Test
	public void testArticleNr_Max()
	{
		order.addOrder(5, 10000);
	}
	
	@Test
	public void testArticleNr_TooSmall()
	{
		try
		{
			order.addOrder(5, -1);
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong articleNr: -1", e.getMessage());
		}
	}
	
	@Test
	public void testArticleNr_TooBig()
	{
		try
		{
			order.addOrder(5, 10001);
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong articleNr: 10001", e.getMessage());
		}
	}


	// Version 2: use a map of test cases
	
	@Test
	public void testQuantity()
	{
		Map<Integer, IllegalArgumentException> quantityTestCases = new 
				HashMap<Integer, IllegalArgumentException>();
		
		quantityTestCases.put(1, null);
		quantityTestCases.put(10, null);
		quantityTestCases.put(0, new IllegalArgumentException("Wrong quantity: 0"));
		quantityTestCases.put(11, new IllegalArgumentException("Wrong quantity: 11"));
		
		runQuantityTestCases(quantityTestCases);
	}
	
	
	private void runQuantityTestCases(Map<Integer, IllegalArgumentException> testCases)
	{
		for(int i : testCases.keySet())
		{
			try
			{
				System.out.println("test case: value = " + i + "\n");
				order.addOrder(i, 1000);
				if(testCases.get(i) != null)
					Assert.fail();
			}
			catch(IllegalArgumentException e)
			{
				Assert.assertEquals(testCases.get(i).getMessage(), e.getMessage());
			}
		}
	}
	
}
