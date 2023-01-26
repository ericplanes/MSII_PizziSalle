package com.salle.application.controller;

import com.salle.application.factory.DelegationFactory;
import com.salle.domain.delegation.AbsDelegation;
import com.salle.utilities.exceptions.InvalidParameterException;


public class DelegationController {
    private static AbsDelegation delegation;
    private static PizzaController pizzaController;

    public DelegationController(int delegationCode) throws InvalidParameterException {
        delegation = DelegationFactory.createDelegation(delegationCode);
        pizzaController = new PizzaController(delegationCode);
    }

    public PizzaController getPizzaController() {
        return pizzaController;
    }

    public int getDelegationCode() {
        return delegation.getDelegationCode();
    }

    public String getDelegationString() {
        return delegation.toString();
    }
}
