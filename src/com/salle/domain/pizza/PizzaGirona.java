package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaGirona extends AbsPizza {
    public PizzaGirona() {
        super();
        this.delegationAvailable = ConstantUtilities.delegationGIR;
        fillPizzaIngredients(ConstantUtilities.gironaPizzaIngredients);
        this.name = ConstantUtilities.gironaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.gironaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
