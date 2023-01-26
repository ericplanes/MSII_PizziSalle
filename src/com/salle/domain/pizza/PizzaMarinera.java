package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaMarinera extends AbsPizza {
    public PizzaMarinera() {
        super();
        fillPizzaIngredients(ConstantUtilities.marineraPizzaIngredients);
        this.name = ConstantUtilities.marineraPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.marineraPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
