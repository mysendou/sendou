package com.jeff;

public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;

    @Override
    public String toString() {
        return super.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DAOException(String string) {
    }

}
