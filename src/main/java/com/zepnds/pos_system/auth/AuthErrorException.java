package com.zepnds.pos_system.auth;

public class AuthErrorException extends RuntimeException {
    public AuthErrorException(String message) {
        super(message);
    }
}