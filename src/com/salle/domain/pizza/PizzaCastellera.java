package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaCastellera extends AbsPizza {
    public PizzaCastellera() {
        super();
        fillPizzaIngredients(ConstantUtilities.castelleraPizzaIngredients);
        this.name = ConstantUtilities.castelleraPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.castelleraPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
