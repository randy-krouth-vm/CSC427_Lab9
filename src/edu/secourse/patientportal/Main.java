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

        //Manual patient creation
        User newUser = new Patient("john123", "John Smith", "pass123", "johnsmith123@gmail.com");
        userService.createUser(newUser);


        System.out.println("Admin Dashboard");
        System.out.println("1. Create User");
        System.out.println("2. Print User");
        System.out.println("3. Delete User");
        choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {



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


            //Need to test more
            if (role.equals("patient")) {

                User user = new Patient(username, name, password, email);
                user.setRole(role);
                userController.createUser(user);


            }

            else if (role.equals("doctor")) {

                User user = new Doctor(username, name, password, email);
                user.setRole(role);
                userController.createUser(user);


            }


            else if (role.equals("admin")) {

                User user = new Admin(username, name, password, email);
                user.setRole(role);
                userController.createUser(user);


            }

            else {
                System.out.println("Invalid role");
            }


        }

        else if (choice == 2) {
            System.out.print("Please enter a username: ");
            String username = input.nextLine().trim();

            try {
                //Get user
                User user = userService.getUser(username);

                userController.printUser(user);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        else if (choice == 3) {
            System.out.print("Please enter a username: ");
            String username = input.nextLine().trim();

            try {
                //Get user
                User user = userService.getUser(username);

                userController.printUser(user);

                System.out.println("\nAre you sure you want to delete this user");
                System.out.print("Re-enter the username to confirm or type no to exit: ");
                String confirm = input.nextLine().trim();

                if(confirm.equals(username)) {
                    userController.removeUser(user);
                }

                else{
                    System.out.println("Deletion cancelled");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }



    }
}