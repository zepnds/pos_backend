package com.zepnds.pos_system.products.exception;

public class ProductErrorCreateException  extends  RuntimeException{
    public ProductErrorCreateException(String message) {
        super(message);
    }

    public ProductErrorCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
