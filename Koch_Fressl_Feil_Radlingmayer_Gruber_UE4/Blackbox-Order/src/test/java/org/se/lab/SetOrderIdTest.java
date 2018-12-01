package org.se.lab;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void testSetOrderId_0SizeMin()
	{
		order.setOrderId("00");
	}

	@Test
	public void testSetOrderId_9SizeMin()
	{
		order.setOrderId("99");
	}

	@Test
	public void testSetOrderId_0SizeMax()
	{
		order.setOrderId("0000000000");
	}

	@Test
	public void testSetOrderId_9SizeMax()
	{
		order.setOrderId("9999999999");
	}

	
	@Test
	public void testSetOrderId_0SizeTooSmall()
	{
		try
		{
			order.setOrderId("0");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong order id: 0", e.getMessage());
		}
	}

	
	@Test
	public void testSetOrderId_9SizeTooSmall()
	{
		try
		{
			order.setOrderId("9");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong order id: 9", e.getMessage());
		}
	}

	
	@Test
	public void testSetOrderId_0SizeTooBig()
	{
		try
		{
			order.setOrderId("00000000000");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong order id: 00000000000", e.getMessage());
		}
	}

	@Test
	public void testSetOrderId_9SizeTooBig()
	{
		try
		{
			order.setOrderId("99999999999");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong order id: 99999999999", e.getMessage());
		}
	}

	
	@Test
	public void testSetOrderId_CharacterTooBig()
	{
		try
		{
			order.setOrderId("::");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong order id: ::", e.getMessage());
		}
	}

	
	@Test
	public void testSetOrderId_CharacterTooSmall()
	{
		try
		{
			order.setOrderId("//");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Wrong order id: //", e.getMessage());
		}
	}


	// Version 2: use a map of test cases
	
	@Test
	public void testOrderId()
	{
		Map<String, IllegalArgumentException> idTestCases = 
				new HashMap<String, IllegalArgumentException>();
		
		idTestCases.put("00", null);
		idTestCases.put("99", null);
		idTestCases.put("0000000000", null);
		idTestCases.put("9999999999", null);
		
		idTestCases.put("0", new IllegalArgumentException("Wrong order id: 0"));
		idTestCases.put("9", new IllegalArgumentException("Wrong order id: 9"));
		idTestCases.put("00000000000", new IllegalArgumentException("Wrong order id: 00000000000"));
		idTestCases.put("99999999999", new IllegalArgumentException("Wrong order id: 99999999999"));
		idTestCases.put("::", new IllegalArgumentException("Wrong order id: ::"));
		idTestCases.put("//", new IllegalArgumentException("Wrong order id: //"));
		
		runOrderIdTestCases(idTestCases);
	}
	
	
	public void runOrderIdTestCases(Map<String, IllegalArgumentException> testCases)
	{
		for(String s : testCases.keySet())
		{
			try
			{
				System.out.println("test case: value = " + s + "\n");
				order.setOrderId(s);
				if(testCases.get(s) != null)
					Assert.fail();
			}
			catch(IllegalArgumentException e)
			{
				Assert.assertEquals(testCases.get(s).getMessage(), e.getMessage());
			}
		}
	}

}
