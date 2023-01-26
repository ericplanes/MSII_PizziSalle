package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaMallorquina extends AbsPizza {
    public PizzaMallorquina() {
        super();
        fillPizzaIngredients(ConstantUtilities.mallorquinaPizzaIngredients);
        this.name = ConstantUtilities.mallorquinaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.mallorquinaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
