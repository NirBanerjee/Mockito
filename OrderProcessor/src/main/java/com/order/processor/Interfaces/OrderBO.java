package com.order.processor.Interfaces;

import com.order.processor.Domain.Order;
import com.order.processor.Exceptions.BOException;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;
    boolean cancelOrder(int id) throws BOException;
    boolean deleteOrder(int id) throws BOException;
}
