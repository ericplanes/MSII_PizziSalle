package com.salle.application.controller;

import com.salle.application.dto.ClientDTO;
import com.salle.domain.Client;
import com.salle.persistence.ClientRepository;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.EmptyStringException;
import com.salle.utilities.exceptions.InvalidParameterException;
import com.salle.utilities.exceptions.NotFoundException;
import com.salle.utilities.exceptions.NullParameterValueException;

import java.sql.SQLException;
import java.time.LocalDate;

public class ClientController {
    private Client client;

    //Constructor with just phone number
    public ClientController(String phoneNumber) throws InvalidParameterException, SQLException, NotFoundException {
        this.client = getClientFromBDD(phoneNumber);
    }

    //Full constructor
    public ClientController(String name, String surname, String address, String phoneNumber, int delegation, LocalDate birthDate) throws InvalidParameterException, EmptyStringException, NullParameterValueException, NotFoundException {
        this.client = new Client(name, surname, phoneNumber, address, delegation, birthDate);
    }

    //Increase commands done
    public void increaseCommandNumber(){
        this.client.increaseCommandsDone();
        this.updateClientFromBDD();
    }

    /*
     * Get a client from the data base:
     *      if the client doesn't exist yet, throws NotFoundException.
     *      if the phone number format isn't correct, throws InvalidParameterException.
     *      if there is any problem with the connection to the data base, prints the error on the console and throws SQLException.
     */
    private Client getClientFromBDD(String phone) throws NotFoundException, InvalidParameterException, SQLException {
        try {

            if (phone == null || phone.length() != 9)
                throw new InvalidParameterException("The phone number format isn't correct");
            ClientDTO clientDTO = new ClientRepository().getClient(phone);
            return new Client(clientDTO);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        } catch (InvalidParameterException e) {
            throw new InvalidParameterException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }

    /*
     * Save a new client on the database:
     *      returns true if the client is saved successfully.
     *      returns false if there is any problem while saving the client on the database
     *
     */
    public boolean saveClientOnBDD() {
        try {
            ClientDTO clientDTO = new ClientDTO(this.client);
            new ClientRepository().saveClient(clientDTO);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * Updates the client on the data base.
     *      Returns true if it has been updated.
     *      Returns false if it couldn't be updated.
     */
    public boolean updateClientFromBDD() {
        try {
            new ClientRepository().updateClient(new ClientDTO(this.client));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Checks if the client is major (at the moment is 18 because the software is developed for a catalan company)
    public boolean isMajor() {
        return this.client.computeClientAge() >= ConstantUtilities.ageToBeMajor;
    }

    //Get client string in order to print it
    public String getClientString(){
        return this.client.toString();
    }
}
