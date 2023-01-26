package com.salle.domain.pizza;

import com.salle.application.factory.PizzaFactory;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaHawaiana extends AbsPizza {
    public PizzaHawaiana() {
        super();
        fillPizzaIngredients(ConstantUtilities.hawaianaPizzaIngredients);
        this.name = ConstantUtilities.hawaianaPizzaName;
    }
    @Override
    public AbsPizza clone() {
        try {
            return PizzaFactory.createPizza(ConstantUtilities.hawaianaPizzaCode);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return null;
        }
    }

}
