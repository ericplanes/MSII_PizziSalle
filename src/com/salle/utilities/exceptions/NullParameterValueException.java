package com.salle.utilities.exceptions;

public class NullParameterValueException extends Exception {
    public static final long serialVersionUID = 5L;

    public NullParameterValueException() {
        super("The value of the parameter sended in this function is null.");
    }

    public NullParameterValueException(String message) {
        super(message);
    }
}
