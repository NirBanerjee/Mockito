package com.order.processor.Exceptions;

import java.sql.SQLException;

public class BOException extends Exception {

    public BOException(SQLException ex) {
        super(ex);
    }
}
