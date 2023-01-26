package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaPepperoni extends AbsPizza{
    public PizzaPepperoni() {
        super();
        fillPizzaIngredients(ConstantUtilities.pepperoniPizzaIngredients);
        this.name = ConstantUtilities.pepperoniPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.pepperoniPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
