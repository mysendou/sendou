package com.aug.jeff.excel.exception;

public class ExcelException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ExcelException(String message) {
        super(message);
    }

    public ExcelException(Throwable cause) {
        super(cause);
    }
}
