package edu.secourse.patientportal.models;

public class Admin extends User {


    public Admin(int accountNumber, String username, String hashedPassword, String name, String email ){
        super(accountNumber,username, hashedPassword, name, email, "admin");
    }

}
