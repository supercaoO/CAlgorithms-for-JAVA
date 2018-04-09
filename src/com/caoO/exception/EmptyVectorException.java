package com.caoO.exception;

public class EmptyVectorException extends RuntimeException {
    public EmptyVectorException() { super(); }

    public EmptyVectorException(String s) { super(s); }
}
