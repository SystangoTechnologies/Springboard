package com.systango.springboard.service.exception;

/**
 * Created by Arpit Khandelwal.
 */
public class UserExistsException extends Exception {

    public UserExistsException() {
        super("This User already exists!");
    }

    public UserExistsException(Throwable throwable) {
        super(throwable);
    }
}
