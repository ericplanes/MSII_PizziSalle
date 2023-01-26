package com.salle.domain;

import com.salle.domain.pizza.AbsPizza;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidNumOfIngredientsException;
import com.salle.utilities.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private List<AbsPizza> pizzaList;
    private List<String> drinkList;

    public Command() {
        pizzaList = new ArrayList<>();
        drinkList = new ArrayList<>();
    }

    public boolean addPizza(AbsPizza pizza) {
        if (pizzaList.size() == drinkList.size())
            return this.pizzaList.add(pizza);
        return false;
    }

    public boolean addDrink(String drink) {
        if (drinkList.size() == pizzaList.size() - 1)
            return this.drinkList.add(drink);
        return false;
    }

    //Changes the dough of the pizza passed as parameter
    public void changePizzaDough(int doughCode) throws NotFoundException {
        AbsPizza pizza = pizzaList.get(pizzaList.size() - 1);
        pizza.setPizzaDough(doughCode);
    }

    //Add ingredients to the pizza
    public boolean addIngredient(String ingredient) throws InvalidNumOfIngredientsException {
        AbsPizza pizza = pizzaList.get(pizzaList.size() - 1);
        if (pizza.getNumIngredients() < ConstantUtilities.maxNumOfIngredients) {
            return pizza.getPizzaIngredients().add(ingredient);
        } else {
            throw new InvalidNumOfIngredientsException("The pizza has already the limit amount of ingredients");
        }
    }

    /*
    //Quit ingredients from the pizza
    public void removeIngredient(String ingredient) throws InvalidNumOfIngredientsException {
        AbsPizza pizza = pizzaList.get(pizzaList.size() - 1);
        if (pizza.getNumIngredients() > 0 && pizza.getPizzaIngredients().contains(ingredient)) {
            pizza.getPizzaIngredients().remove(ingredient);
        } else {
            throw new InvalidNumOfIngredientsException("The pizza doesn't contain the ingredient selected");
        }
    }
    */


    //Returns a string showing all the ingredients of the actual pizza
    public String currentIngredients() {
        AbsPizza pizza = pizzaList.get(pizzaList.size() - 1);
        String str = "";
        List<String> list = pizza.getPizzaIngredients();
        List<String> used = new ArrayList<>();

        for (String ingredient : list) {
            if(!used.contains(ingredient)){
                str += "\n" + ingredient + " x" + numOfIngredientInstances(ingredient, list);
                used.add(ingredient);
            }
        }

        str += ".\n";

        return str;
    }

    private int numOfPizzaInstances(AbsPizza pizza) {
        int num = 0;
        for (AbsPizza otherPizzas : this.pizzaList) {
            if (pizza.getName().equals(otherPizzas.getName()))
                num++;
        }
        return num;
    }

    private int numOfDrinkInstances(String drink) {
        int num = 0;
        for (String otherDrinks : this.drinkList) {
            if (drink.equals(otherDrinks)) {
                num++;
            }
        }
        return num;
    }

    private int numOfIngredientInstances(String ingredient, List<String> list) {
        int num = 0;
        for (String otherIngredient : list) {
            if (ingredient.equals(otherIngredient)) {
                num++;
            }
        }
        return num;
    }

    @Override
    public String toString() {
        String str = "";
        int index = 1;
        List <String> used = new ArrayList<>();

        str += "Pizzas: \n";
        for (AbsPizza pizza : this.pizzaList) {
            str += "\t(" + index + ")." + pizza.toString() + "\n";
            index++;
        }

        index = 1;
        str += "Begudes: \n";
        for (String drink : this.drinkList) {
            if(!used.contains(drink)){
                str += "\t(" + index + ")." + drink + " x" + numOfDrinkInstances(drink) + "\n";
                index++;
                used.add(drink);
            }
        }

        return str;
    }
}
