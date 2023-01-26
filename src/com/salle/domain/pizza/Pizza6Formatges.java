package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class Pizza6Formatges extends AbsPizza {
    public Pizza6Formatges() {
        super();
        fillPizzaIngredients(ConstantUtilities.formatges6PizzaIngredients);
        this.name = ConstantUtilities.formatges6PizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.formatges6PizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
