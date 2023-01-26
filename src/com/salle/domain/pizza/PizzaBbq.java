package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaBbq extends AbsPizza {
    public PizzaBbq() {
        super();
        fillPizzaIngredients(ConstantUtilities.bbqPizzaIngredients);
        this.name = ConstantUtilities.bbqPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.bbqPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
