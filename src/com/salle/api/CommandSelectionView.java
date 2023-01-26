package com.salle.api;

import com.salle.application.controller.CommandController;
import com.salle.application.controller.PizzaController;
import com.salle.utilities.ApiStrings;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.Print;
import com.salle.utilities.exceptions.InvalidNumOfIngredientsException;
import com.salle.utilities.exceptions.InvalidParameterException;

public class CommandSelectionView {
    private final Print console;
    private final boolean isMajor;
    private final PizzaController pizzaController;
    private final CommandController commandController;


    public CommandSelectionView(Print console, PizzaController pizzaController, boolean isMajor) {
        this.console = console;
        this.isMajor = isMajor;
        this.pizzaController = pizzaController;
        this.commandController = new CommandController();
    }

    public void getCommandDone() {
        while (true) {
            //Select pizza
            selectPizza();

            //Want to add more ingredients?
            addIngredientsToPizza();


            //Change the dough if wanted
            if (askChangeDough()) {
                changePizzaDough();
            }

            //Ask for the drink
            if (isMajor) {
                selectDrinkMajor();
            } else {
                selectDrinkMinor();
            }

            //Ask if he wants more pizzas
            if (!continueAsking()) {
                printFinalCommand();
                if (askCommandDone()) {
                    //If needed, save the command on the database
                    break;
                }
            }
        }
    }

    //Select a pizza from the pizza list and add it to the command
    private void selectPizza() {
        int answer;
        boolean answerCorrect = false;

        do {
            console.printTitle(ApiStrings.pizzaListTitle);
            console.printWHITE(ApiStrings.selectPizzaText);
            console.printYELLOW(pizzaController.getPizzaListString());
            try {
                console.printWHITE(ApiStrings.readNavigationAnswer);
                answer = Integer.parseInt(console.readORANGE());
                commandController.addPizza(pizzaController.getPizza(answer - 1));
                answerCorrect = true;
                console.space(1);
            } catch (NumberFormatException NFE) {
                console.printErrorMessage("You must write a number, words or letters aren't accepted");
            } catch (InvalidParameterException IPE) {
                console.printErrorMessage(IPE.getMessage());
            } catch (IndexOutOfBoundsException iob) {
                console.printErrorMessage(ApiStrings.pizzaNotInTheList);
            }
        } while (!answerCorrect);
    }

    //Asks ifs wants to add more ingredients
    private boolean askAddMoreIngredients() {
        String answer;
        boolean ansYes, ansNo;

        while (true) {
            console.space(1);
            console.printWHITE(ApiStrings.askAddIngredients);
            answer = console.readORANGE();
            ansYes = answer.contains("y") || answer.contains("Y");
            ansNo = answer.contains("n") || answer.contains("N");

            //Check the answer nature
            if (ansYes && !ansNo) {
                console.space(1);
                return true;
            } else if (ansNo && !ansYes) {
                console.space(1);
                return false;
            } else {
                console.printRED("\n" + ApiStrings.answerYorN + "\n");
            }
        }
    }

    //Add extra ingredients to the pizza
    private void addIngredientsToPizza(){
        int answer;
        String ingredient;
        while(askAddMoreIngredients()){
            console.printTitle(ApiStrings.addIngredientsToPizza);
            console.printWHITE(ApiStrings.chooseIngredients);
            console.space(2);
            console.printYELLOW(pizzaController.getIngredientList());
            console.space(1);
            console.printWHITE(ApiStrings.readNavigationAnswer);
            try {
                answer = Integer.parseInt(console.readORANGE());
                ingredient = pizzaController.getIngredient(answer - 1);
                commandController.addIngredientToPizza(ingredient);
                console.printGREEN(ApiStrings.ingredientAdded);
                console.space(2);
                console.printWHITE(ApiStrings.currentIngredients);
                console.printYELLOW(commandController.getCurrentIngredients());
                console.space(1);
            } catch (NumberFormatException nfe){
                nfe.printStackTrace();
                console.printErrorMessage(ApiStrings.numberFormatError);
            } catch (InvalidParameterException | InvalidNumOfIngredientsException ipe) {
                ipe.printStackTrace();
                console.printErrorMessage(ipe.getMessage());
            } catch (Exception e ) {
                e.printStackTrace();
                console.printErrorMessage(ApiStrings.unknownException + "\n\n" + e.getMessage());
            }
        }
    }

    //Asks ifs wants to change the dough, returns 1 if yes, 0 if no.
    private boolean askChangeDough() {
        String answer;
        boolean ansYes, ansNo;

        while (true) {
            console.printWHITE(ApiStrings.askChangeDough);
            answer = console.readORANGE();
            ansYes = answer.contains("y") || answer.contains("Y");
            ansNo = answer.contains("n") || answer.contains("N");

            //Check the answer nature
            if (ansYes && !ansNo) {
                console.clear();
                return true;
            } else if (ansNo && !ansYes) {
                console.clear();
                return false;
            } else {
                console.printRED("\n" + ApiStrings.answerYorN + "\n");
            }
        }
    }

    //Change the dough of the pizza
    private void changePizzaDough() {
        int answer;
        while (true) {
            console.printTitle(ApiStrings.doughTitle);
            console.printWHITE(ApiStrings.selectDough);
            console.printWHITE(ApiStrings.readNavigationAnswer);
            try {
                answer = Integer.parseInt(console.readORANGE());
                switch (answer) {
                    case 1:
                        commandController.changeDough(ConstantUtilities.thinDoughCode);
                        break;
                    case 2:
                        commandController.changeDough(ConstantUtilities.originalDoughCode);
                        break;
                    case 3:
                        commandController.changeDough(ConstantUtilities.thickDoughCode);
                        break;
                    default:
                        throw new Exception();
                }
                console.clear();
                return;
            } catch (Exception e) {
                console.printErrorMessage(ApiStrings.answerBetween1and3);
            }
        }
    }

    //Select the drink as a major client
    private void selectDrinkMajor() {
        int answer;
        while (true) {
            console.printTitle(ApiStrings.drinkTitle);
            console.printWHITE(ApiStrings.selectDrinkMajor);
            console.printWHITE(ApiStrings.readNavigationAnswer);
            try {
                answer = Integer.parseInt(console.readORANGE());
                switch (answer) {
                    case 1:
                        commandController.addDrink(ConstantUtilities.waterDrink);
                        console.clear();
                        return;
                    case 2:
                        commandController.addDrink(ConstantUtilities.sodaDrink);
                        console.clear();
                        return;
                    case 3:
                        commandController.addDrink(ConstantUtilities.beerDrink);
                        console.clear();
                        return;
                    default:
                        throw new Exception();
                }
            } catch (NumberFormatException nfe) {
                console.printErrorMessage(ApiStrings.numberFormatError);
            } catch (Exception e) {
                e.printStackTrace();
                console.printErrorMessage(ApiStrings.answerBetween1and3);
            }
        }
    }

    //Select the drink as a minor client
    private void selectDrinkMinor() {
        int answer;
        while (true) {
            console.printTitle(ApiStrings.drinkTitle);
            console.printWHITE(ApiStrings.selectDrinkMinor);
            console.printWHITE(ApiStrings.readNavigationAnswer);
            try {
                answer = Integer.parseInt(console.readORANGE());
                switch (answer) {
                    case 1:
                        commandController.addDrink(ConstantUtilities.waterDrink);
                        console.clear();
                        return;
                    case 2:
                        commandController.addDrink(ConstantUtilities.sodaDrink);
                        console.clear();
                        return;
                    default:
                        throw new Exception();
                }
            } catch (NumberFormatException nfe) {
                console.printErrorMessage(ApiStrings.numberFormatError);
            } catch (Exception e) {
                e.printStackTrace();
                console.printErrorMessage(ApiStrings.answerBetween1and3);
            }
        }
    }

    private boolean continueAsking() {
        String answer;
        boolean ansYes, ansNo;

        while (true) {
            console.printTitle(ApiStrings.keepAskingTitle);
            console.printWHITE(ApiStrings.askForMorePizzas);
            answer = console.readORANGE();
            ansYes = answer.contains("y") || answer.contains("Y");
            ansNo = answer.contains("n") || answer.contains("N");

            //Check the answer nature
            if (ansYes && !ansNo) {
                console.clear();
                return true;
            } else if (ansNo && !ansYes) {
                console.clear();
                return false;
            } else {
                console.printRED("\n" + ApiStrings.answerYorN + "\n");
            }
        }
    }

    private void printFinalCommand() {
        console.printTitle(ApiStrings.commandTitle);
        console.printGREEN(commandController.getCommandString());
        console.space(1);
        console.readKey();
        console.clear();
    }

    private boolean askCommandDone() {
        String answer;
        boolean ansYes, ansNo;

        while (true) {
            console.printTitle(ApiStrings.commandConfirmationTitle);
            console.printWHITE(ApiStrings.askToFinish);
            answer = console.readORANGE();
            ansYes = answer.contains("y") || answer.contains("Y");
            ansNo = answer.contains("n") || answer.contains("N");

            //Check the answer nature
            if (ansYes && !ansNo) {
                console.clear();
                return true;
            } else if (ansNo && !ansYes) {
                console.clear();
                return false;
            } else {
                console.printRED("\n" + ApiStrings.answerYorN + "\n");
            }
        }
    }
}
