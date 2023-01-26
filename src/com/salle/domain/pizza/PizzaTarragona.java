package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaTarragona extends AbsPizza {
    public PizzaTarragona() {
        super();
        this.delegationAvailable = ConstantUtilities.delegationTAR;
        fillPizzaIngredients(ConstantUtilities.tarragonaPizzaIngredients);
        this.name = ConstantUtilities.tarragonaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.tarragonaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
