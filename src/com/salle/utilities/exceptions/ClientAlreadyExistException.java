package com.salle.utilities.exceptions;

public class ClientAlreadyExistException extends Exception {

    public static final long serialVersionUID = 0L;

    public ClientAlreadyExistException() {
        super("The client already exists.");
    }

    public ClientAlreadyExistException(String message) {
        super(message);
    }
}
