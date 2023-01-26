package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaTraviata extends AbsPizza {
    public PizzaTraviata() {
        super();
        fillPizzaIngredients(ConstantUtilities.traviataPizzaIngredients);
        this.name = ConstantUtilities.traviataPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.traviataPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
