package org.se.lab;

import org.junit.Assert;

public class CustomAssertion {


    public static void testOrder( Order expected, Order actual)
    {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getOrderLines().size(), actual.getOrderLines().size());

    }

    public static void testLine(OrderLine expected, OrderLine actual)
    {


        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());

        Assert.assertNotNull(expected.getProduct());
        Assert.assertNotNull(actual.getProduct());

        Product expectedProduct = expected.getProduct();
        Product actualProduct = actual.getProduct();

        testProduct(expectedProduct, actualProduct);


    }

    public static void testProduct(Product expected, Product actual)
    {


        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

}
