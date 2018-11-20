package org.se.lab;

public class IntegerSequence
{
	private IntegerSequence() {}
	
	
	private static int value = 0;
	
	public static int getNextValue()
	{
		return value++;
	}
	
	public static void setInitValue(int initValue)
	{
		value = initValue;
	}
}
