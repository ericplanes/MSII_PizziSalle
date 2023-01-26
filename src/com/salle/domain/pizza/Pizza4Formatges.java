package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class Pizza4Formatges extends AbsPizza {
    public Pizza4Formatges() {
        super();
        fillPizzaIngredients(ConstantUtilities.formatges4PizzaIngredients);
        this.name = ConstantUtilities.formatges4PizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.formatges4PizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
