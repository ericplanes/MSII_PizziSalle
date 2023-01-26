package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaCowboy extends AbsPizza {
    public PizzaCowboy() {
        super();
        fillPizzaIngredients(ConstantUtilities.cowboyPizzaIngredients);
        this.name = ConstantUtilities.cowboyPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.cowboyPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
