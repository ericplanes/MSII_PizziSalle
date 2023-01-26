package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaVegetal extends AbsPizza {
    public PizzaVegetal() {
        super();
        fillPizzaIngredients(ConstantUtilities.vegetalPizzaIngredients);
        this.name = ConstantUtilities.vegetalPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.vegetalPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
