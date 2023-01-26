package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaBurguer extends AbsPizza {
    public PizzaBurguer() {
        super();
        fillPizzaIngredients(ConstantUtilities.burguerPizzaIngredients);
        this.name = ConstantUtilities.burguerPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.burguerPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
