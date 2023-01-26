package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaSerrana extends AbsPizza {
    public PizzaSerrana() {
        super();
        fillPizzaIngredients(ConstantUtilities.serranaPizzaIngredients);
        this.name = ConstantUtilities.serranaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.serranaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
