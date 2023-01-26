package com.salle.utilities.exceptions;

public class EmptyStringException extends Exception {

    public static final long serialVersionUID = 1L;

    public EmptyStringException() {
        super("The String value cannot be empty.");
    }

    public EmptyStringException(String message) {
        super(message);
    }
}
