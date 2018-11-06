package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderTest
{
	private Order order;
	
	@Before
	public void setup()
	{
		GregorianCalendar date = new GregorianCalendar(2013,11,2);
		order = new Order(1, date.getTime());		
		order.addLine(new OrderLine(10, 4, new Product(20, "Effective Java: A Programming Language Guide", 3495)));
		order.addLine(new OrderLine(11, 2, new Product(21, "Hardcore Java", 2870)));
		order.addLine(new OrderLine(12, 5, new Product(22, "The Java Programming Language", 4095)));
	}
	
	
	@Test
	public void testOrder()
	{
		Assert.assertNotNull(order);
		Assert.assertEquals(1, order.getId());
		
		GregorianCalendar date = new GregorianCalendar();
		date.setTime(order.getDate());
		Assert.assertEquals(2013, date.get(Calendar.YEAR));
		Assert.assertEquals(11, date.get(Calendar.MONTH));
		Assert.assertEquals(2, date.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void testOrderLines()
	{
		List<OrderLine> lines = order.getLines();
		
		Assert.assertNotNull(lines);
		Assert.assertEquals(3, lines.size());
		
		Assert.assertEquals(10, lines.get(0).getId());
		Assert.assertEquals(4, lines.get(0).getQuantity());
		Assert.assertEquals(20, lines.get(0).getProduct().getId());
		Assert.assertEquals("Effective Java: A Programming Language Guide", lines.get(0).getProduct().getDesc());
		Assert.assertEquals(3495, lines.get(0).getProduct().getPrice());
	
		Assert.assertEquals(11, lines.get(1).getId());
		Assert.assertEquals(2, lines.get(1).getQuantity());
		Assert.assertEquals(21, lines.get(1).getProduct().getId());
		Assert.assertEquals("Hardcore Java", lines.get(1).getProduct().getDesc());
		Assert.assertEquals(2870, lines.get(1).getProduct().getPrice());
		
		Assert.assertEquals(12, lines.get(2).getId());
		Assert.assertEquals(5, lines.get(2).getQuantity());
		Assert.assertEquals(22, lines.get(2).getProduct().getId());
		Assert.assertEquals("The Java Programming Language", lines.get(2).getProduct().getDesc());
		Assert.assertEquals(4095, lines.get(2).getProduct().getPrice());
	}
	
	
	@Test
	public void testToString()
	{
		final String EXPECTED = 
				"1,02.12.2013"
				+ "["
				+ 	"10,4,20,Effective Java: A Programming Language Guide,3495, "
				+ 	"11,2,21,Hardcore Java,2870, "
				+ 	"12,5,22,The Java Programming Language,4095"
				+ "]";
		
		Assert.assertEquals(EXPECTED, order.toString());
	}
}
