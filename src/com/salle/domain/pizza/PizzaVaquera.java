package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaVaquera extends AbsPizza {
    public PizzaVaquera() {
        super();
        fillPizzaIngredients(ConstantUtilities.vaqueraPizzaIngredients);
        this.name = ConstantUtilities.vaqueraPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.vaqueraPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
