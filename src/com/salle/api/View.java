package com.salle.api;

import com.salle.application.controller.ClientController;
import com.salle.application.controller.CommandController;
import com.salle.application.controller.DelegationController;
import com.salle.application.controller.PizzaController;
import com.salle.utilities.ApiStrings;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.Print;
import jconsole.JConsole;

public class View {
    private static Print console;

    public static void main(String[] args) {
        //Create the window
        JConsole window = new JConsole(ConstantUtilities.consoleHorizontal, ConstantUtilities.consoleVertical);
        console = new Print(window);

        //Declare all the variables that we are going to use
        DelegationController delegationController = null;
        ClientController clientController = null;
        PizzaController pizzaController = null;
        CommandController commandController = null;

        //Initialize all the views
        InitialPageView initialPageView = new InitialPageView(console);
        ClientInfoView clientInfoView = new ClientInfoView(console);
        CommandSelectionView commandSelectionView;

        //Initial page
        delegationController = initialPageView.logInPage();
        pizzaController = new PizzaController(delegationController.getDelegationCode());
        console.printTitle(ApiStrings.checkInfoGathered);
        console.printGREEN(delegationController.getDelegationString());
        console.space(1);
        console.readKey();
        console.clear();

        do {
            //Client identification page
            clientController = clientInfoView.getClientInformation(delegationController.getDelegationCode());
            console.printTitle(ApiStrings.checkInfoGathered);
            console.printGREEN(clientController.getClientString());
            console.space(1);
            console.readKey();
            console.clear();

            //Get the command from the client
            commandSelectionView = new CommandSelectionView(console, pizzaController, clientController.isMajor());
            commandSelectionView.getCommandDone();
            clientController.increaseCommandNumber();

            //Ask the user if he wants to continue registering orders
        } while (keepWithTheProgram());
        exitProgram();
    }

    //Asks if wants to add more ingredients
    private static boolean keepWithTheProgram() {
        String answer;
        boolean ansYes, ansNo;

        while (true) {
            console.space(1);
            console.printWHITE(ApiStrings.keepRegistering);
            answer = console.readORANGE();
            ansYes = answer.contains("y") || answer.contains("Y");
            ansNo = answer.contains("n") || answer.contains("N");

            //Check the answer nature
            if (ansYes && !ansNo) {
                return true;
            } else if (ansNo && !ansYes) {
                return false;
            } else {
                console.printRED("\n" + ApiStrings.answerYorN + "\n");
            }
        }
    }

    //Exits the program
    private static void exitProgram() {
        console.printTitle(ApiStrings.exitMessage);
        console.space(1);
        for (int i = 0; i < ConstantUtilities.consoleVertical - 4; i++) {
            if (i < (ConstantUtilities.consoleVertical - 4) / 3 || i >= (2 * ConstantUtilities.consoleVertical - 4) / 3) {
                for (int j = 0; j < ConstantUtilities.consoleHorizontal; j++) {
                    console.printRED("-");
                }
            } else {
                for (int j = 0; j < ConstantUtilities.consoleHorizontal; j++) {
                    console.printYELLOW("-");
                }
            }
        }
        console.readKey();
        System.exit(0);
    }
}
