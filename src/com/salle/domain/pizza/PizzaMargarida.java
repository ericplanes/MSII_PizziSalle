package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaMargarida extends AbsPizza {
    public PizzaMargarida() {
        super();
        fillPizzaIngredients(ConstantUtilities.margaridaPizzaIngredients);
        this.name = ConstantUtilities.margaridaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.margaridaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
