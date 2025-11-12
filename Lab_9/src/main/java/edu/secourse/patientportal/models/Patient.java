package edu.secourse.patientportal.models;

import edu.secourse.patientportal.enums.Roles;

public class Patient extends User {

    public Patient() {

    }

    public Patient(int accountNumber, String username, String hashedPassword, String name, String email, Roles role ){
        super(accountNumber,username, hashedPassword, name, email, role);
    }
}
