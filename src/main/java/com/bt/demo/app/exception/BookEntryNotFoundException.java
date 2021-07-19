package com.bt.demo.app.exception;


public class BookEntryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookEntryNotFoundException(String message) {
        super(message);
    }

    public BookEntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}