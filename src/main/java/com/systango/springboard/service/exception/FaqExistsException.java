package com.systango.springboard.service.exception;

/**
 * Created by Arpit Khandelwal.
 */
public class FaqExistsException extends Exception {

    public FaqExistsException() {
        super("This FAQ already exists!");
    }

    public FaqExistsException(Throwable throwable) {
        super(throwable);
    }
}
