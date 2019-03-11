package com.order.processor.BO;

import com.order.processor.DAO.OrderDAO;
import com.order.processor.Domain.Order;
import com.order.processor.Exceptions.BOException;
import com.order.processor.Interfaces.OrderBO;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO;

    @Override
    public boolean placeOrder(Order order) throws BOException {
        try {
            int orderId = orderDAO.create(order);
            if (orderId == 0)    {
                return false;
            }
        }   catch (SQLException ex) {
            ex.printStackTrace();
            throw new BOException(ex);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try {
            Order order = orderDAO.read(id);
            order.setStatus("cancelled");
            int result = orderDAO.update(order);
            if (result == 0)    {
                return false;
            }
        }   catch (SQLException ex) {
            ex.printStackTrace();
            throw new BOException(ex);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try {
            int result = orderDAO.delete(id);
            if (result == 0)    {
                return false;
            }
        }   catch (SQLException ex) {
            ex.printStackTrace();
            throw new BOException(ex);
        }
        return true;
    }
}
