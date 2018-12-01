package org.se.lab;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LoginPasswordTest
	extends AbstractLoginTest
{
	// Version 1: use a single test method for each test case

	// Note that we use a "large" (e.g. 100 chars) string to test 
	// the upper bound.
	
	// In this example we use a TestHelper class to generate long
	// strings.
	
	@Test
	public void testLoginPassword_ValidPassword1()
	{
		boolean result = service.login("aaaa", TestHelper.toString('0', 10));
		Assert.assertFalse(result);
	}
	@Test
	public void testLoginPassword_ValidPassword2()
	{
		boolean result = service.login("aaaa", TestHelper.toString('9', 10));
		Assert.assertFalse(result);
	}
	@Test
	public void testLoginPassword_ValidPassword3()
	{
		boolean result = service.login("aaaa", TestHelper.toString('0', 100));
		Assert.assertFalse(result);
	}
	@Test
	public void testLoginPassword_ValidPassword4()
	{
		boolean result = service.login("aaaa", TestHelper.toString('9', 100));
		Assert.assertFalse(result);
	}

	
	@Test
	public void testLoginPassword_ValidPassword5()
	{
		boolean result = service.login("aaaa", TestHelper.toString('a', 10));
		Assert.assertFalse(result);
	}
	@Test
	public void testLoginPassword_ValidPassword6()
	{
		boolean result = service.login("aaaa", TestHelper.toString('z', 10));
		Assert.assertFalse(result);
	}
	@Test
	public void testLoginPassword_ValidPassword7()
	{
		boolean result = service.login("aaaa", TestHelper.toString('a', 100));
		Assert.assertFalse(result);
	}
	@Test
	public void testLoginPassword_ValidPassword8()
	{
		boolean result = service.login("aaaa", TestHelper.toString('z', 100));
		Assert.assertFalse(result);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword1()
	{
		service.login("aaaa", TestHelper.toString('0', 9));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword2()
	{
		service.login("aaaa", TestHelper.toString('9', 9));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword3()
	{
		service.login("aaaa", TestHelper.toString('/', 10));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword4()
	{
		service.login("aaaa", TestHelper.toString(':', 10));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword5()
	{
		service.login("aaaa", TestHelper.toString('a', 9));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword6()
	{
		service.login("aaaa", TestHelper.toString('z', 9));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword7()
	{
		service.login("aaaa", TestHelper.toString('\'', 10));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginPassword_InvalidPassword8()
	{
		service.login("aaaa", TestHelper.toString('}', 10));
	}
	

	
	// Version 2: use a map of test cases
	
	@Test
	public void testLoginPassword()
	{
		Map<String, Object> passwordTestCases = new HashMap<String, Object>();
				
		passwordTestCases.put(TestHelper.toString('0', 10), false);
		passwordTestCases.put(TestHelper.toString('9', 10), false);
		passwordTestCases.put(TestHelper.toString('0', 100), false);
		passwordTestCases.put(TestHelper.toString('9', 100), false);

		passwordTestCases.put(TestHelper.toString('a', 10), false);
		passwordTestCases.put(TestHelper.toString('z', 10), false);
		passwordTestCases.put(TestHelper.toString('a', 100), false);
		passwordTestCases.put(TestHelper.toString('z', 100), false);
		
		passwordTestCases.put(TestHelper.toString('0', 9), new IllegalArgumentException());
		passwordTestCases.put(TestHelper.toString('9', 9), new IllegalArgumentException());
		passwordTestCases.put(TestHelper.toString('/', 10), new IllegalArgumentException());
		passwordTestCases.put(TestHelper.toString(':', 10), new IllegalArgumentException());
		
		passwordTestCases.put(TestHelper.toString('a', 9), new IllegalArgumentException());
		passwordTestCases.put(TestHelper.toString('z', 9), new IllegalArgumentException());
		passwordTestCases.put(TestHelper.toString('\'', 10), new IllegalArgumentException());
		passwordTestCases.put(TestHelper.toString('}', 10), new IllegalArgumentException());
		
		runPasswordTestCases(passwordTestCases);
	}
	
	
	void runPasswordTestCases(Map<String, Object> testCases)
	{
		for(String s : testCases.keySet())
		{
			System.out.println("test case: password = " + s + "\n");
			try
			{
				boolean actual = service.login("aaaa", s);
				
				if(testCases.get(s) instanceof IllegalArgumentException)
				{
					Assert.fail();
				}
				else if(testCases.get(s) instanceof Boolean)
				{
					Boolean expected = (Boolean)testCases.get(s); 
					Assert.assertEquals(expected.booleanValue(), actual);
				}
				else
				{
					Assert.fail(); // wrong type 
				}
			}
			catch(IllegalArgumentException e)
			{
				// OK
			}
		}
	}
}
