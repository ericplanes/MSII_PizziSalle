package com.salle.application.dto;

import com.salle.domain.Client;
import com.salle.utilities.exceptions.NullParameterValueException;

import java.time.LocalDate;

public class ClientDTO {

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String delegation;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private int commandsDone;

    //Empty constructor
    public ClientDTO(){}

    //Constructor from a Client object
    public ClientDTO(Client client) throws NullParameterValueException {
        if(client == null){
            throw new NullParameterValueException("Client is null");
        } else {
            this.name = client.getName();
            this.surname = client.getSurname();
            this.phone = client.getPhone();
            this.address = client.getAddress();
            this.delegation = client.getDelegation();
            this.birthDate = client.getBirthDate();
            this.registrationDate = client.getRegistrationDate();
            this.commandsDone = client.getCommandsDone();
        }
    }

    //Constructor used for the database
    public ClientDTO(String name, String surname, String phone, String address, String delegation, LocalDate birthDate, LocalDate registrationDate, int commandsDone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.delegation = delegation;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.commandsDone = commandsDone;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDelegation() {
        return delegation;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public int getCommandsDone() {
        return commandsDone;
    }
}
