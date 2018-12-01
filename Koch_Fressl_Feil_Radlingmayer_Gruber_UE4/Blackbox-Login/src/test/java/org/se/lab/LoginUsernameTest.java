package org.se.lab;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LoginUsernameTest
	extends AbstractLoginTest
{
	// Version 1: use a single test method for each test case

	@Test
	public void testLoginUsername_ValidUsername1()
	{
		boolean result = service.login("aaaa", "aaaaaaaaaa");
		Assert.assertFalse(result);
	}

	@Test
	public void testLoginUsername_ValidUsername2()
	{
		boolean result = service.login("zzzz", "aaaaaaaaaa");
		Assert.assertFalse(result);
	}

	@Test
	public void testLoginUsername_ValidUsername3()
	{
		boolean result = service.login("aaaaaaaa", "aaaaaaaaaa");
		Assert.assertFalse(result);
	}

	@Test
	public void testLoginUsername_ValidUsername4()
	{
		boolean result = service.login("zzzzzzzz", "aaaaaaaaaa");
		Assert.assertFalse(result);
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void testLoginUsername_InvalidUsername1()
	{
		service.login("aaa", "aaaaaaaaaa");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testLoginUsername_InvalidUsername2()
	{
		service.login("zzz", "aaaaaaaaaa");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testLoginUsername_InvalidUsername3()
	{
		service.login("aaaaaaaaa", "aaaaaaaaaa");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testLoginUsername_InvalidUsername4()
	{
		service.login("zzzzzzzzz", "aaaaaaaaaa");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLoginUsername_InvalidUsername5()
	{
		service.login("''''", "aaaaaaaaaa");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testLoginUsername_InvalidUsername6()
	{
		service.login("}}}}", "aaaaaaaaaa");
	}
	
	
	
	
	// Version 2: use a map of test cases
	
	@Test
	public void testLoginUsername()
	{
		Map<String, Object> usernameTestCases = new HashMap<String, Object>();
				
		usernameTestCases.put("aaaa", false);
		usernameTestCases.put("zzzz", false);
		usernameTestCases.put("aaaaaaaa", false);
		usernameTestCases.put("zzzzzzzz", false);
		
		usernameTestCases.put("aaa", new IllegalArgumentException());
		usernameTestCases.put("zzz", new IllegalArgumentException());
		usernameTestCases.put("aaaaaaaaa", new IllegalArgumentException());
		usernameTestCases.put("zzzzzzzzz", new IllegalArgumentException());
		usernameTestCases.put("''''", new IllegalArgumentException());
		usernameTestCases.put("}}}}", new IllegalArgumentException());
		
		runUsernameTestCases(usernameTestCases);
	}
	
	
	void runUsernameTestCases(Map<String, Object> testCases)
	{
		for(String s : testCases.keySet())
		{
			System.out.println("test case: value = " + s + "\n");
			try
			{
				boolean actual = service.login(s, "aaaaaaaaaa");
				
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
