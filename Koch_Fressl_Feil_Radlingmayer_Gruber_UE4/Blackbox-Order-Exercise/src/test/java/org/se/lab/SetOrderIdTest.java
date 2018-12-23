package org.se.lab;

import org.junit.Before;
import org.junit.*;

import java.util.HashMap;

public class SetOrderIdTest
{
	private Order order;
	
	
	@Before
	public void setup()
	{
		order = new Order();		
		
	}

	
	// Version 1: use a single test method for each test case

	@Test
	public void testSetShortestValidOrderId()
	{
		order.setOrderId("00");
	}
	@Test
	public void testSetShortestValidOrderId1()
	{
		order.setOrderId("99");
	}

	@Test
	public void testSetMaxValidOrderId()
	{
		order.setOrderId("9999999999");
	}
	@Test
	public void testSetMaxValidOrderId2()
	{
		order.setOrderId("0000000000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTooSmallOrderId()
	{
		order.setOrderId("0");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetTooSmallOrderId2()
	{
		order.setOrderId("9");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTooBigOrderId()
	{
		order.setOrderId("99999999999");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetTooBigOrderId2()
	{
		order.setOrderId("00000000000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTooSmallChar()
	{
		order.setOrderId("//");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTooBigChar()
	{
		order.setOrderId("::");
	}
	
	// Version 2: use a map of test cases
	
	@Test
	public void TestMapOrderId()
	{
		HashMap<String, IllegalArgumentException> fullTestCases = new HashMap<>();

		// cases without errors
		fullTestCases.put("00", null);
		fullTestCases.put("99", null);
		fullTestCases.put("9999999999", null);
		fullTestCases.put("0000000000", null);

		//Cases with errors
		fullTestCases.put("0",new IllegalArgumentException("Wrong order id: 0"));
		fullTestCases.put("9", new IllegalArgumentException("Wrong order id: 9"));
		fullTestCases.put("99999999999", new IllegalArgumentException("Wrong order id: 99999999999"));
		fullTestCases.put("00000000000", new IllegalArgumentException("Wrong order id: 00000000000"));
		fullTestCases.put("//", new IllegalArgumentException("Wrong order id: //"));
		fullTestCases.put("::",new IllegalArgumentException("Wrong order id: ::"));

		runOrderIdTests(fullTestCases);
	}

	private void runOrderIdTests(HashMap<String, IllegalArgumentException> testCases)
	{
		for ( String str : testCases.keySet())
		{
			try
			{
				order.setOrderId(str);
				if (testCases.get(str) != null)
					Assert.fail();
			}
			catch (IllegalArgumentException e)
			{
				Assert.assertEquals(testCases.get(str).getMessage(), e.getMessage());
			}
		}
	}
}
