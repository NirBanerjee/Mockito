package com.order.processor.BO;

import com.order.processor.DAO.OrderDAO;
import com.order.processor.Domain.Order;
import com.order.processor.Exceptions.BOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderBOImplTest {

    @Mock
    OrderDAO dao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void placeOrderShouldCreateAnOrder() throws SQLException, BOException {
        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        Order order = new Order();
        when(dao.create(order)).thenReturn(Integer.valueOf(1));
        boolean result = orderBOImpl.placeOrder(order);

        assertTrue(result);
        verify(dao).create(order);
    }

    @Test
    public void placeOrderShouldCreateNotAnOrder() throws SQLException, BOException {
        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        Order order = new Order();
        when(dao.create(order)).thenReturn(Integer.valueOf(0));
        boolean result = orderBOImpl.placeOrder(order);

        assertFalse(result);
        verify(dao).create(order);
    }

    @Test
    public void placeOrderShouldThrowBOException() throws SQLException, BOException {

        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        Order order = new Order();
        when(dao.create(order)).thenThrow(SQLException.class);
        assertThrows(BOException.class, () -> orderBOImpl.placeOrder(order));
    }

    @Test
    public void cancelOrderShouldCancelAnOrder() throws SQLException, BOException {

        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenReturn(Integer.valueOf(1));
        boolean result = orderBOImpl.cancelOrder(123);
        assertTrue(result);

        verify(dao).read(123);
        verify(dao).update(order);
    }

    @Test
    public void cancelOrderShouldNotCancelAnOrder() throws SQLException, BOException {

        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenReturn(Integer.valueOf(0));
        boolean result = orderBOImpl.cancelOrder(123);
        assertFalse(result);

        verify(dao).read(123);
        verify(dao).update(order);
    }

    @Test
    public void cancelOrderShouldThrowBOExceptionOnRead() throws SQLException, BOException {
        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        when(dao.read(123)).thenThrow(SQLException.class);
        assertThrows(BOException.class, () -> orderBOImpl.cancelOrder(123));
    }

    @Test
    public void cancelOrderShouldThrowBOExceptionOnUpdate() throws SQLException, BOException {
        OrderBOImpl orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(dao);

        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenThrow(SQLException.class);
        assertThrows(BOException.class, () -> orderBOImpl.cancelOrder(123));
    }

}