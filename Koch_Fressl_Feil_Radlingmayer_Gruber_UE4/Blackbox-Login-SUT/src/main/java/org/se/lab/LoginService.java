package org.se.lab;

public class LoginService
{
	/*
	 * Constructor
	 */
	public LoginService()
	{
		this.table = new UserTableImpl();
	}
	
	
	/*
	 * Association: ---[1]-> UserTable;
	 */
	private UserTable table;
	
	
	public boolean login(String username, String password)
	{
		if(username == null || password == null)
			throw new IllegalArgumentException();
		
		if(username.matches("^[a-z]{4,8}$") == false)
			throw new IllegalArgumentException("Wrong order username: " + username);

		if(password.matches("^[0-9a-z]{10,}$") == false)
			throw new IllegalArgumentException("Wrong order password: " + password);
		
		try
		{
			boolean result = table.isValidUser(username, password);
			return result;
			
		}
		catch(TableException e)
		{
			throw new ServiceException(e);
		}
	}
}
