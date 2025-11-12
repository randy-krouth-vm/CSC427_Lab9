package edu.secourse.patientportal;

import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.services.UserService;
import edu.secourse.patientportal.controllers.UserController;

public class Main {
    public static void main(String[] args) {
        try {
        while(true) {
                try {
                    IO.println("============================================================");
                    IO.println("Hello! Welcome to Madhav's Office.");
                    IO.println("Please make a selection from the following choices: ");

                    IO.println("1. Create User");
                    IO.println("2. Create Appointment");
                    IO.println("3. Exit");

                    String selectedInput = IO.readln();

                    if (selectedInput.equals("1")) {

                    } else if (selectedInput.equals("2")) {

                    } else if(selectedInput.equals("3")) {
                        return;
                    }
                    else {
                        IO.println("============================================================");
                        IO.println("Invalid Input. Please try again from the provided choices.");
                        throw new RuntimeException("Invalid Input. Please try again from the provided choices.");
                    }
                }
                catch(Exception e){
                    // IO.println(e);
                }
            }
        }
        catch (Exception e) {
            IO.println(e);
        }
    }
}
