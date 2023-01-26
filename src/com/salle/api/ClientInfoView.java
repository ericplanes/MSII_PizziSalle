package com.salle.api;

import com.salle.application.controller.ClientController;
import com.salle.utilities.ApiStrings;
import com.salle.utilities.Print;
import com.salle.utilities.exceptions.InvalidParameterException;
import com.salle.utilities.exceptions.NotFoundException;
import com.salle.utilities.exceptions.NullParameterValueException;

import java.time.LocalDate;

public class ClientInfoView {

    Print console;

    public ClientInfoView(Print console) {
        this.console = console;
    }

    public ClientController getClientInformation(int delegationCode) {
        ClientController clientController = null;
        String phoneNumber;
        boolean clientCorrect = false;

        while (!clientCorrect) {
            console.printTitle(ApiStrings.clientPhoneTitle);
            console.printWHITE(ApiStrings.readPhoneNumber);
            phoneNumber = console.readORANGE();

            try {
                checkClientPhone(phoneNumber);
                clientController = new ClientController(phoneNumber);
                clientCorrect = true;
            } catch (NotFoundException NFE) {
                console.clear();
                clientController = fillClientData(phoneNumber, delegationCode);
                clientCorrect = true;
            } catch (Exception e) {
                console.printErrorMessage(e.getMessage());
            }
        }

        console.clear();
        return clientController;
    }

    //Check the phone string
    private void checkClientPhone(String phone) throws NullParameterValueException, InvalidParameterException {
        if (phone == null) throw new NullParameterValueException("Client phone number was Null");
        try {
            Integer.parseInt(phone);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Client phone has some characters that aren't numbers");
        }
        if (phone.length() != 9) throw new InvalidParameterException("Client phone has more or less than 9 numbers");
    }

    //Fills the data of the client and inserts it on the data base
    private ClientController fillClientData(String phoneNumber, int delegationCode) {
        ClientController clientController = null;

        String name, surname, address;
        LocalDate birthDate;
        boolean clientCorrect = false;

        while (!clientCorrect) {
            console.printTitle(ApiStrings.clientInformationTitle);
            console.printWHITE(ApiStrings.askClientInfo);

            try {
                console.printYELLOW(ApiStrings.askName);
                name = console.readORANGE();
                console.printYELLOW(ApiStrings.askSurname);
                surname = console.readORANGE();
                console.printYELLOW(ApiStrings.askAddress);
                address = console.readORANGE();
                console.printYELLOW(ApiStrings.askBirthDate);
                birthDate = LocalDate.parse(console.readORANGE());
                clientController = new ClientController(name, surname, address, phoneNumber, delegationCode, birthDate);
                if (clientController.saveClientOnBDD()) {
                    clientCorrect = true;
                } else {
                    throw new Exception(ApiStrings.updateClientError);
                }
            } catch (Exception e) {
                console.printErrorMessage(e.getMessage());
            }
        }
        console.clear();
        return clientController;
    }

}













