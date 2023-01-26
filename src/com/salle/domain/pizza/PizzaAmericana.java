package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaAmericana extends AbsPizza {
    public PizzaAmericana() {
        super();
        fillPizzaIngredients(ConstantUtilities.americanaPizzaIngredients);
        this.name = ConstantUtilities.americanaPizzaName;
    }

    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.americanaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
