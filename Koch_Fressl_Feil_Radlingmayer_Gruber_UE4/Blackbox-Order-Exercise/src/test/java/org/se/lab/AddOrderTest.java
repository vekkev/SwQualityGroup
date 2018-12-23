package org.se.lab;

import org.junit.Before;
import org.junit.*;

import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

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
	public void testValidArticleMin()
	{
		order.addOrder(1,0);
	}

	@Test
	public void testValidArticleMax()
	{
		order.addOrder(9,10000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooSmallArticleNumber()
	{
		order.addOrder(1,-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooBigArticleNumber()
	{
		order.addOrder(1,1000022);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooSmallQuantity()
	{
		order.addOrder(0,99);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooBigQuantity()
	{
		order.addOrder(11,99);
	}

	
	// Version 2: use a map of test cases


	@Test
	public void testMap()
	{
		HashMap<TestParameters, IllegalArgumentException> fullTestCases = new HashMap<>();

		fullTestCases.put(new TestParameters(1,0), null);
		fullTestCases.put(new TestParameters(9, 10000), null);
		fullTestCases.put(new TestParameters(1,-1), new IllegalArgumentException("Wrong articleNr: -1"));
		fullTestCases.put(new TestParameters(1, 1000022), new IllegalArgumentException("Wrong articleNr: 1000022"));
		fullTestCases.put(new TestParameters(0,99), new IllegalArgumentException("Wrong quantity: 0"));
		fullTestCases.put(new TestParameters(11,99), new IllegalArgumentException("Wrong quantity: 11"));

		runTestCases(fullTestCases);
	}

	public void runTestCases(Map<TestParameters, IllegalArgumentException> testCases)
	{
		for( TestParameters params : testCases.keySet())
		{
			try
			{
				order.addOrder(params.getQuantity(),params.getArticleNr());
				if(testCases.get(params) != null)
				{
					Assert.fail();
				}
			}
			catch (IllegalArgumentException e)
			{
				Assert.assertEquals(testCases.get(params).getMessage(), e.getMessage());
			}
		}
	}

}
