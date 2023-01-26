package com.salle.utilities;

public class ApiStrings {

    //Initial page strings
    public static final String initialPageTitle = "Log in page";
    public static final String selectDelegation = "Select your delegation: \n" +
            "\t(1) " + ConstantUtilities.delegationStringBCN + "\n" +
            "\t(2) " + ConstantUtilities.delegationStringGIR + "\n" +
            "\t(3) " + ConstantUtilities.delegationStringTAR + "\n" +
            "\t(4) " + ConstantUtilities.delegationStringLLE + "\n";

    //Client information strings
    public static final String clientPhoneTitle = "Client phone number";
    public static final String readPhoneNumber = "Introduce the client phone number: ";

    public static final String clientInformationTitle = "Register a new client";
    public static final String askClientInfo = "Fill the client data: \n";
    public static final String askName = " Name: ";
    public static final String askSurname = " Surname: ";
    public static final String askAddress = " Address: ";
    public static final String askBirthDate = " Birth date with the format [YYYY-MM-DD]: ";

    //Command information strings
    public static final String pizzaListTitle = "Pizza selection";
    public static final String addIngredientsToPizza = "Add ingredients to pizza";
    public static final String chooseIngredients = "Choose the ingredients: ";
    public static final String ingredientAdded = "Ingredient added successfully";
    public static final String currentIngredients = "Current ingredients: ";

    public static final String doughTitle = "Change the dough";
    public static final String drinkTitle = "Select the drink";
    public static final String keepAskingTitle = "Keep asking for pizzas";
    public static final String commandTitle = "Final command";
    public static final String commandConfirmationTitle = "Is it already done?";
    public static final String selectPizzaText = "Select one of the following pizzas (by number): \n";
    public static final String askAddIngredients = "Do you want to add more ingredients? (Yes / No) ";
    public static final String askChangeDough = "Do you want to modify the dough? (Yes / No) ";
    public static final String askForMorePizzas = "Do you want to add more pizzas to the command? (Yes / No) ";
    public static final String askToFinish = "Is the command already done? (Yes / No) ";

    public static final String selectDough = "Select the dough type:\n" +
            "\t(1). " + ConstantUtilities.thinDoughString + "\n" +
            "\t(2). " + ConstantUtilities.originalDoughString + "\n" +
            "\t(3). " + ConstantUtilities.thickDoughString + "\n";

    public static String selectDrinkMajor = "Select the drink:\n" +
            "\t(1). " + ConstantUtilities.waterDrink + "\n" +
            "\t(2). " + ConstantUtilities.sodaDrink + "\n" +
            "\t(3). " + ConstantUtilities.beerDrink + "\n";

    public static String selectDrinkMinor = "Select the drink:\n" +
            "\t(1). " + ConstantUtilities.waterDrink + "\n" +
            "\t(2). " + ConstantUtilities.sodaDrink + "\n";

    //Error Strings
    public static final String answerBetween1and4 = "The answer must be one of this numbers: [1, 2, 3, 4]";
    public static final String answerBetween1and3 = "The answer must be one of this numbers: [1, 2, 3]";
    public static final String answerYorN = "Invalid answer, answer must contains Y or N.";
    public static final String updateClientError = "The client couldn't be updated";
    public static final String pizzaNotInTheList = "Select a pizza of the list, this number doesn't correspond to a pizza.";
    public static final String numberFormatError = "The answer must be a number";
    public static final String unknownException = "An unknown source of exception occurred: ";

    //General strings
    public static final String readNavigationAnswer = "Answer: ";
    public static final String checkInfoGathered = "Check the information";
    public static final String keepRegistering = "Do you want to keep registering commands? (Yes / No) ";
    public static final String exitMessage = "Thank you for using our software, see you soon";
}
