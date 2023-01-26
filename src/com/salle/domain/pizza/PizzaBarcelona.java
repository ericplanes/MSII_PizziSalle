package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaBarcelona extends AbsPizza {
    public PizzaBarcelona() {
        super();
        this.delegationAvailable = ConstantUtilities.delegationBCN;
        fillPizzaIngredients(ConstantUtilities.barcelonaPizzaIngredients);
        this.name = ConstantUtilities.barcelonaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.barcelonaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
