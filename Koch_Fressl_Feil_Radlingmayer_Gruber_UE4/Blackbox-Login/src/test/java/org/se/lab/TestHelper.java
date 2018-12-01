package org.se.lab;

public class TestHelper
{
	private TestHelper() {}
	
	public static String toString(char c, int times)
	{
		StringBuilder b = new StringBuilder(times);
		
		for(int i=0; i<times; i++)
		{
			b.append(c);
		}
		
		return b.toString();
	}
}
