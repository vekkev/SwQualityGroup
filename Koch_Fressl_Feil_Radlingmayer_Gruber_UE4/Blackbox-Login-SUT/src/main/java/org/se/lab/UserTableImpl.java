package org.se.lab;

import java.util.HashMap;
import java.util.Map;

public class UserTableImpl
	implements UserTable
{
	/*
	 * Constructor
	 */
	public UserTableImpl()
	{
		table.put("homer", "4upbmy83qy");
	}
	
	
	/*
	 * Simulate DB by using a Map<K,V>
	 */
	private Map<String,String> table = new HashMap<String, String>();
	
	
	/*
	 * Interface methods
	 */
	
	@Override
	public boolean isValidUser(String username, String password)
	{
		if(table.containsKey(username))
		{
			if(password.equals(table.get(username)))
			{
				return true;
			}
			else
			{
				return false; // wrong password
			}
		}
		else
		{
			return false; // unknown user
		}
	}
}
