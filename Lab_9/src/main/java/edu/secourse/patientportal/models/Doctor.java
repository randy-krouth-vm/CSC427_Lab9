package edu.secourse.patientportal.models;

import edu.secourse.patientportal.enums.Roles;

public class Doctor extends User {

    public Doctor(){

    }

    public Doctor(int accountNumber, String username, String hashedPassword, String name, String email, Roles role){
        super(accountNumber,username, hashedPassword, name, email, role);
    }
}
