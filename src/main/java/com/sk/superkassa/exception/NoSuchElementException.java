package com.sk.superkassa.exception;

public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException() {
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
