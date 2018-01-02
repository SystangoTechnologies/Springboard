package com.systango.springboard.service.exception;

/**
 * Created by Arpit Khandelwal.
 */
public class PaymentException extends Exception {
    public PaymentException() {
        super("This Wallet already exists!");
    }

    public PaymentException(Throwable throwable) {
        super(throwable);
    }
}
