package edu.secourse.patientportal.models;

public class Patient extends User {


    public Patient(int accountNumber, String username, String hashedPassword, String name, String email ){
        super(accountNumber,username, hashedPassword, name, email, "patient");
    }

}
