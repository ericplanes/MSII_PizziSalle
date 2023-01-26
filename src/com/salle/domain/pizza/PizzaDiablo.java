package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaDiablo extends AbsPizza {
    public PizzaDiablo() {
        super();
        fillPizzaIngredients(ConstantUtilities.diabloPizzaIngredients);
        this.name = ConstantUtilities.diabloPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.diabloPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
