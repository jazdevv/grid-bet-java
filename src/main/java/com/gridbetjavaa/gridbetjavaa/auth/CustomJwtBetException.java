package com.gridbetjavaa.gridbetjavaa.auth;

public class CustomJwtBetException extends RuntimeException {
    public CustomJwtBetException(String message) {
        super(message);
    }
}