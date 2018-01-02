package com.systango.springboard.service.exception;

/**
 * Created by Arpit Khandelwal.
 */
public class UserException extends Exception {

    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable throwable) {
        super(throwable);
    }
}
