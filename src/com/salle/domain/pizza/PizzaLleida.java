package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaLleida extends AbsPizza {
    public PizzaLleida() {
        super();
        this.delegationAvailable = ConstantUtilities.delegationLLE;
        fillPizzaIngredients(ConstantUtilities.lleidaPizzaIngredients);
        this.name = ConstantUtilities.lleidaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.lleidaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
