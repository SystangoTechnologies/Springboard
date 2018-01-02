package com.systango.springboard.service.exception;

/**
 * Created by Arpit Khandelwal.
 */
public class AdminException extends Exception {

    public AdminException(String message) {
        super(message);
    }

    public AdminException(Throwable throwable) {
        super(throwable);
    }
}
