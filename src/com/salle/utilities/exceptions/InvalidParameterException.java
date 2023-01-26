package com.salle.utilities.exceptions;

public class InvalidParameterException extends Exception {

    public static final long serialVersionUID = 3L;

    public InvalidParameterException() {
        super("The parameter isn't correct.");
    }

    public InvalidParameterException(String message) {
        super(message);
    }
}

