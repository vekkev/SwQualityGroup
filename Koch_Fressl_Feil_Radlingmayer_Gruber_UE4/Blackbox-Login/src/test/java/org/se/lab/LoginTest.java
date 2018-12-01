package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest
	extends AbstractLoginTest
{
	// Happy-path test
	
	@Test
	public void testLoginUsername_ValidUser()
	{
		boolean result = service.login("homer", "4upbmy83qy");
		Assert.assertTrue(result);
	}
}
