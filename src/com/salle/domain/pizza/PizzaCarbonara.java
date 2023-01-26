package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaCarbonara extends AbsPizza {
    public PizzaCarbonara() {
        super();
        fillPizzaIngredients(ConstantUtilities.carbonaraPizzaIngredients);
        this.name = ConstantUtilities.carbonaraPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.carbonaraPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
