package org.se.lab;

import java.util.List;

public class OrderTableStub implements OrderTable
{
    Order order;
    RuntimeException exception;

    @Override
    public void insertOrder(Order order)
    {}

    @Override
    public void deleteOrder(int id)
    {}

    @Override
    public List<Order> findAllOrders()
    {
        return null;
    }
    @Override
    public Order findOrderById(int id)
    {
        if (exception != null)
        {
            throw exception;
        }
        return order;
    }


}
