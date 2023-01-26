package com.salle.utilities.exceptions;

public class NotFoundException extends Exception {
    public static final long serialVersionUID = 4L;

    public NotFoundException() {
        super("The object hadn't been found.");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
