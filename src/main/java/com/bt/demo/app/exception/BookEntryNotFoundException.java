package com.bt.demo.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookEntryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookEntryNotFoundException(String message) {
        super(message);
    }

    public BookEntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}