package com.salle.application.controller;

import com.salle.domain.Command;
import com.salle.domain.pizza.AbsPizza;
import com.salle.utilities.exceptions.InvalidNumOfIngredientsException;
import com.salle.utilities.exceptions.InvalidParameterException;
import com.salle.utilities.exceptions.NotFoundException;

public class CommandController {
    private Command command;

    public CommandController() {
        this.command = new Command();
    }

    public void addPizza(AbsPizza pizza) throws InvalidParameterException {
        if(!command.addPizza(pizza))
            throw new InvalidParameterException("The pizza couldn't be added");
    }

    public boolean addIngredientToPizza(String ingredient) throws InvalidNumOfIngredientsException {
        return command.addIngredient(ingredient);
    }

    public String getCurrentIngredients(){
        return command.currentIngredients();
    }

    public void addDrink(String drink) {
        command.addDrink(drink);
    }

    public String getCommandString(){
        return this.command.toString();
    }

    public void changeDough(int doughCode) throws NotFoundException {
        command.changePizzaDough(doughCode);
    }
}
