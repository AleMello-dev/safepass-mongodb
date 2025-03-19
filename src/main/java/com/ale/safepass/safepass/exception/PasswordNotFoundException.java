package com.ale.safepass.safepass.exception;

public class PasswordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PasswordNotFoundException(String msg) {
        super(msg);
    }
}

