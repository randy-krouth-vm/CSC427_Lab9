package edu.secourse.patientportal.models;

public class Doctor extends User {


    public Doctor(int accountNumber, String username, String hashedPassword, String name, String email ){
        super(accountNumber,username, hashedPassword, name, email, "doctor");
    }

}
