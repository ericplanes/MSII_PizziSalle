package com.salle.domain.pizza;

import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsPizza {
    protected String name, dough;
    protected int delegationAvailable;
    protected List<String> pizzaIngredients;

    public AbsPizza() {
        this.pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(ConstantUtilities.tomaquet);
        pizzaIngredients.add(ConstantUtilities.mozzarella);
        this.delegationAvailable = ConstantUtilities.delegationGENERAL;
        this.dough = ConstantUtilities.originalDoughString;
    }

    protected void fillPizzaIngredients(String[] ingredients) {
        for (String ingredient : ingredients) {
            if (!ingredient.equals("")) this.pizzaIngredients.add(ingredient);
        }
    }

    //Getters
    public String getName() {
        return name.toUpperCase();
    }

    public int getNumIngredients() {
        return pizzaIngredients.size();
    }

    public int getDelegationAvailable() {
        return delegationAvailable;
    }

    public String getDough() {
        return dough;
    }

    //Returns the ingredients list
    public List<String> getPizzaIngredients() {
        return this.pizzaIngredients;
    }

    //Setters
    public void setPizzaDough(int doughCode) throws NotFoundException {
        this.dough = ConstantUtilities.getDoughString(doughCode);
    }

    //Clone the pizza
    public abstract AbsPizza clone();

    private int getNumOfInstanceIngredient(String ingredient) {
        int num = 0;
        for (String instance : this.pizzaIngredients) {
            if (ingredient.equals(instance)) num++;
        }
        return num;
    }

    //Override Methods from Object class
    @Override
    public String toString() {
        List<String> used = new ArrayList<>();
        int widthController = 0;
        String str = "";
        str += this.name.toUpperCase() + "\n";
        str += "\tMassa: " + this.dough + "\n";
        str += "\tIngredients: ";
        for (String ingredient : this.pizzaIngredients) {
            if (!used.contains(ingredient)) {
                if(widthController > 4){
                    str += "\n\t";
                    widthController = 0;
                }
                str += ingredient.toLowerCase() + " x" + getNumOfInstanceIngredient(ingredient) + ", ";
                used.add(ingredient);
                widthController ++;
            }
        }
        str = str.substring(0, str.length() - 2);
        str += ".\n";
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbsPizza)) return false;
        return this.compareTo((AbsPizza) o) == 0;
    }

    public int compareTo(AbsPizza pizza) {
        if (this.getNumIngredients() == pizza.getNumIngredients()) {
            return this.name.compareTo(pizza.getName());
        }
        return pizza.getNumIngredients() - this.getNumIngredients();
    }
}
