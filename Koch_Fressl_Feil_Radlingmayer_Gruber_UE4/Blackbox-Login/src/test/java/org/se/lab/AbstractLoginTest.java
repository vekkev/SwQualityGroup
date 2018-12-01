package org.se.lab;

import org.junit.Before;

public abstract class AbstractLoginTest
{
	protected LoginService service;
	
	@Before
	public void setup()
	{
		service = new LoginService();		
	}
}
