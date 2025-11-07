package edu.secourse.patientportal;


import edu.secourse.patientportal.models.Admin;
import edu.secourse.patientportal.models.Doctor;
import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.services.UserService;
import edu.secourse.patientportal.controllers.UserController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        UserController userController = new UserController(userService);
        Scanner input = new Scanner(System.in);
        int choice;


        System.out.println("Admin Dashboard");
        System.out.println("1. Create User");
        choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {

            //Manual patient creation
            User newUser = new Patient("john123", "John Smith", "pass123", "johnsmith123@gmail.com");
            userService.createUser(newUser);

            System.out.println("Please enter a username: ");
            String username = input.nextLine().trim();
            System.out.println("Please enter a password: ");
            String password = input.nextLine().trim();
            System.out.println("Please enter a name: ");
            String name = input.nextLine().trim();
            System.out.println("Please enter a email: ");
            String email = input.nextLine().trim();
            System.out.println("Please enter a role: patient, doctor, admin ");
            String role = input.nextLine().toLowerCase();

            if (role.equals("patient")) {

                User user = new Patient(username, name, password, email);
                user.setRole(role);
                userController.createUser(user);


            }

            if (role.equals("doctor")) {

                User user = new Doctor(username, name, password, email);
                user.setRole(role);
                userController.createUser(user);


            }


            if (role.equals("admin")) {

                User user = new Admin(username, name, password, email);
                user.setRole(role);
                userController.createUser(user);


            }

            else {
                System.out.println("Invalid role");
            }


        }


//        if (user1 instanceof Patient) {
//            System.out.println(((Patient) user1).getPatientId());
//        }
//
//        if (user1 instanceof Patient) {
//            System.out.println(((Patient) user2).getPatientId());
//        }


//        System.out.println(user1.getAccountNumber());
//        System.out.println(user2.getAccountNumber());


//        // Remove a user
//        userController.deleteUser(user1);
//
//        // Try to remove again
//        userController.deleteUser(user1);
    }
}