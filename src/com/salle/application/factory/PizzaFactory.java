package com.salle.application.factory;

import com.salle.domain.pizza.*;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.InvalidParameterException;

public class PizzaFactory {

    public static AbsPizza createPizza(int pizzaCode) throws InvalidParameterException {
        switch (pizzaCode) {
            case ConstantUtilities.margaridaPizzaCode:
                return new PizzaMargarida();
            case ConstantUtilities.hawaianaPizzaCode:
                return new PizzaHawaiana();
            case ConstantUtilities.baconcrispyPizzaCode:
                return new PizzaBaconCrispy();
            case ConstantUtilities.americanaPizzaCode:
                return new PizzaAmericana();
            case ConstantUtilities.traviataPizzaCode:
                return new PizzaTraviata();
            case ConstantUtilities.burguerPizzaCode:
                return new PizzaBurguer();
            case ConstantUtilities.castelleraPizzaCode:
                return new PizzaCastellera();
            case ConstantUtilities.cowboyPizzaCode:
                return new PizzaCowboy();
            case ConstantUtilities.vaqueraPizzaCode:
                return new PizzaVaquera();
            case ConstantUtilities.marineraPizzaCode:
                return new PizzaMarinera();
            case ConstantUtilities.bbqPizzaCode:
                return new PizzaBbq();
            case ConstantUtilities.diabloPizzaCode:
                return new PizzaDiablo();
            case ConstantUtilities.carbonaraPizzaCode:
                return new PizzaCarbonara();
            case ConstantUtilities.serranaPizzaCode:
                return new PizzaSerrana();
            case ConstantUtilities.formatges4PizzaCode:
                return new Pizza4Formatges();
            case ConstantUtilities.pepperoniPizzaCode:
                return new PizzaPepperoni();
            case ConstantUtilities.vegetalPizzaCode:
                return new PizzaVegetal();
            case ConstantUtilities.barcelonaPizzaCode:
                return new PizzaBarcelona();
            case ConstantUtilities.gironaPizzaCode:
                return new PizzaGirona();
            case ConstantUtilities.tarragonaPizzaCode:
                return new PizzaTarragona();
            case ConstantUtilities.lleidaPizzaCode:
                return new PizzaLleida();
            case ConstantUtilities.formatges6PizzaCode:
                return new Pizza6Formatges();
            case ConstantUtilities.mallorquinaPizzaCode:
                return new PizzaMallorquina();
            case ConstantUtilities.carbonaradeluxePizzaCode:
                return new PizzaCarbonaraDeluxe();
        }
        throw new InvalidParameterException("Invalid pizza code");
    }
}
