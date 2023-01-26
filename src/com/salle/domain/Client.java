package com.salle.domain;

import com.salle.application.dto.ClientDTO;
import com.salle.utilities.ConstantUtilities;
import com.salle.utilities.exceptions.EmptyStringException;
import com.salle.utilities.exceptions.InvalidParameterException;
import com.salle.utilities.exceptions.NotFoundException;
import com.salle.utilities.exceptions.NullParameterValueException;

import java.time.LocalDate;
import java.time.Period;

public class Client {

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String delegation;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private int commandsDone;

    //Empty Constructor
    public Client() {
    }

    //Normal Constructor
    public Client(String name, String surname, String phone, String address, int delegation, LocalDate birthDate) throws NullParameterValueException, EmptyStringException, InvalidParameterException, NotFoundException {
        checkClientName(name);
        checkClientSurname(surname);
        checkClientPhone(phone);
        checkClientAddress(address);
        checkClientBirthDate(birthDate);

        this.name = name.toUpperCase();
        this.surname = surname.toUpperCase();
        this.phone = phone;
        this.address = address.toUpperCase();
        this.birthDate = birthDate;
        this.registrationDate = LocalDate.now();
        this.delegation = ConstantUtilities.getDelegationString(delegation);
        this.commandsDone = 0;
    }

    //Constructor from clientDTO (used for the application package to interact with the database)
    public Client(ClientDTO clientDTO) throws InvalidParameterException {
        if (clientDTO == null) throw new InvalidParameterException("ClientDTO is null");
        else {
            this.name = clientDTO.getName();
            this.surname = clientDTO.getSurname();
            this.phone = clientDTO.getPhone();
            this.address = clientDTO.getAddress();
            this.birthDate = clientDTO.getBirthDate();
            this.registrationDate = clientDTO.getRegistrationDate();
            this.delegation = clientDTO.getDelegation();
            this.commandsDone = clientDTO.getCommandsDone();
        }
    }

    //Checks the name string
    private void checkClientName(String name) throws NullParameterValueException, EmptyStringException, InvalidParameterException {
        if (name == null) throw new NullParameterValueException("Client name was Null");
        if (name.equals("")) throw new EmptyStringException("Client name was Empty");
        if (name.matches(".*\\d.*")) throw new InvalidParameterException("The name can't contain any number");
    }

    //Checks the surname string
    private void checkClientSurname(String surname) throws NullParameterValueException, EmptyStringException, InvalidParameterException {
        if (surname == null) throw new NullParameterValueException("Client surname was Null");
        if (surname.equals("")) throw new EmptyStringException("Client surname was Empty");
        if (surname.matches(".*\\d.*")) throw new InvalidParameterException("Client surname can't contain any number");
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

    //Check the address string
    private void checkClientAddress(String address) throws NullParameterValueException, EmptyStringException {
        if (address == null) throw new NullParameterValueException("Client address was Null");
        if (address.equals("")) throw new EmptyStringException("Client address was Empty");
    }

    //Check the age of the client
    private void checkClientBirthDate(LocalDate birthDate) throws InvalidParameterException, NullParameterValueException {
        if (birthDate == null) throw new NullParameterValueException("The date can't be null");
        if (birthDate.compareTo(LocalDate.now()) >= 0)
            throw new InvalidParameterException("The date of birth can't be later or equals than the system date");
    }

    //Increase the commands done
    public void increaseCommandsDone() {
        this.commandsDone++;
    }

    //Own functions
    public int computeClientAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
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

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    //Override methods
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Client)) return false;
        return this.compareTo((Client) obj) == 0;
    }

    public int compareTo(Client client) {
        if (this.phone.equals(client.getPhone()) && this.name.equals(client.getName()) && this.surname.equals(client.getSurname())) {
            return 0;
        }

        if (this.name.compareTo(client.getName()) != 0) {
            return this.name.compareTo(client.getName());
        }

        if (this.surname.compareTo(client.getSurname()) != 0) {
            return this.surname.compareTo(client.getSurname());
        }

        return this.phone.compareTo(client.getPhone());
    }

    @Override //Every client must be unique, so we can't clone it.
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Client can't be cloned");
    }

    @Override
    public String toString() {
        String str = "";
        str += "Client: " + this.name + " " + this.surname + "\n";
        str += "Phone Number: " + this.phone + "\n";
        str += "Address: " + this.address + "\n";
        str += "Age: " + this.computeClientAge() + "\n";
        str += "Registration date: " + this.registrationDate.toString() + "\n";
        str += "Commands done: " + this.commandsDone + "\n";
        str += "Delegation: " + this.delegation + "\n";
        return str;
    }
}
