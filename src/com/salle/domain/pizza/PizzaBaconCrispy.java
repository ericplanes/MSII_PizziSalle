package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaBaconCrispy extends AbsPizza {
    public PizzaBaconCrispy() {
        super();
        fillPizzaIngredients(ConstantUtilities.baconcrispyPizzaIngredients);
        this.name = ConstantUtilities.baconcrispyPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.baconcrispyPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
