package com.salle.utilities.exceptions;

public class InvalidNumOfIngredientsException extends Exception {

    public static final long serialVersionUID = 2L;

    public InvalidNumOfIngredientsException() {
        super("Number of ingredients on the pizza at its limit. ");
    }

    public InvalidNumOfIngredientsException(String message) {
        super(message);
    }
}
