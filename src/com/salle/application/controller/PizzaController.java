package com.salle.application.controller;

import com.salle.application.factory.PizzaFactory;
import com.salle.domain.pizza.AbsPizza;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;

public class PizzaController {
    private final List<AbsPizza> pizzaList = new ArrayList<>();
    private final List<String> ingredientList = new ArrayList<>();
    private final int delegationCode;

    //Constructor
    public PizzaController(int delegationCode) {
        this.delegationCode = delegationCode;
        fillPizzaList();
    }

    //Returns a new pizza from the factory (in order to keep the original pizzas on the list)
    public AbsPizza getPizza(int position) throws InvalidParameterException {
        if(position < 0 || position > pizzaList.size()) throw new InvalidParameterException("The answer must be a position of the list.");
        return pizzaList.get(position).clone();
    }

    public String getIngredient(int position) throws InvalidParameterException {
        if(position < 0 || position > ingredientList.size()) throw new InvalidParameterException("The answer must be a position of the list.");
        return ingredientList.get(position);
    }

    //Returns a string with all the pizzas and its ingredients
    public String getPizzaListString() {
        String str = "";
        int position = 1, numIngredients = 0;
        for (AbsPizza pizza : pizzaList) {
            str += "\t" + position + ". " + pizza.getName() + "\n";
            position++;
        }
        return str;
    }

    //Returns a string of all the available ingredients
    public String getIngredientList() {
        int position = 1;
        String str = "";
        for (String ingredient : ingredientList) {
            if (position % 5 == 0){
                str += "\n";
            }
            str += "(" + position + ") " + ingredient + ", ";
                position++;
        }
        str = str.substring(0, str.length() - 2);
        str += ".\n";
        return str;
    }

    //Fills the list within pizzas and at the same time fills the ingredient list
    private void fillPizzaList() {
        AbsPizza pizza;
        for (int code : ConstantUtilities.allPizzaCodes) {
            try {
                pizza = PizzaFactory.createPizza(code);
                if (addPizzaToPizzaList(pizza)) {
                    addIngredientsToPizza(pizza);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Adds a pizza to the pizza list, if it already contains the pizza, returns false
    private boolean addPizzaToPizzaList(AbsPizza pizza) {
        if ((pizza.getDelegationAvailable() == this.delegationCode || pizza.getDelegationAvailable() == ConstantUtilities.delegationGENERAL) && !(pizzaList.contains(pizza))) {
            return pizzaList.add(pizza);
        }
        return false;
    }

    //Adds an ingredient on the ingredient list (if it doesn't already exist on the list)
    private void addIngredientsToPizza(AbsPizza pizza) {
        for (String ingredient : pizza.getPizzaIngredients()) {
            if (!ingredientList.contains(ingredient)) ingredientList.add(ingredient);
        }
    }
}
