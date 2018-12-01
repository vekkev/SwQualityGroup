package org.se.lab;

public class Order
{
	public void setOrderId(String id)
	{
		if(id.matches("^[0-9]{2,10}$") == false)
			throw new IllegalArgumentException("Wrong order id: " + id);
		
		// do something
		
	}
	
	
	public void addOrder(int quantity, long articleNr)
	{
		if(quantity < 1 || quantity > 10)
			throw new IllegalArgumentException("Wrong quantity: " + quantity);
		
		if(articleNr < 0 || articleNr > 10000)
			throw new IllegalArgumentException("Wrong articleNr: " + articleNr);
		
		// do something
		
	}
}
