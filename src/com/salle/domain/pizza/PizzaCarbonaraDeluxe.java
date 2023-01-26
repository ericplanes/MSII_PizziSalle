package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaCarbonaraDeluxe extends AbsPizza {
    public PizzaCarbonaraDeluxe() {
        super();
        fillPizzaIngredients(ConstantUtilities.carbonaradeluxePizzaIngredients);
        this.name = ConstantUtilities.carbonaradeluxePizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.carbonaradeluxePizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
