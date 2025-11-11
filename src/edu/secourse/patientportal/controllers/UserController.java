package edu.secourse.patientportal.controllers;

import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.services.UserService;

public class UserController {

    UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    //Create User
    public void createUser(User user) {

        boolean isValid = true;

        String role = user.getRole();


        if (user.getUsername() == null || user.getUsername().isBlank()) {

            System.out.println("Enter in a valid username");
            isValid = false;


        }

        if (user.getHashedPassword() == null || user.getHashedPassword().isBlank()) {

            System.out.println("Enter in a valid password");
            isValid = false;


        }

        if (user.getName() == null || user.getName().isBlank() || !user.getName().trim().matches("^[A-Za-z\\s]+$")) {

            System.out.println("Enter in a name without numbers or special characters");
            isValid = false;


        }


        if (user.getEmail() == null || user.getEmail().isBlank() || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            System.out.println("Enter in a valid email address");
            isValid = false;


        }

        if (user.getRole().isBlank() || (!role.equals("patient") && !role.equals("doctor") && !role.equals("admin"))) {

            System.out.println("Enter in a valid role");
            isValid = false;


        }


        if (!isValid) {
            return;
        }



        try {
            boolean success = userService.createUser(user);
            if (success) {
                System.out.println("User created successfully");
            }
        }catch (IllegalArgumentException e){

                System.out.println("There was an error while creating the user: " + e.getMessage());


            }

        }



    public void updateUser(int accountNumber, String username, String hashedPassword, String name, String email) {
        boolean success = userService.updateUser(accountNumber, username, hashedPassword, name, email);
        if (success) {
            System.out.println("User updated successfully");

        } else {
            System.out.println("User update failed");
        }

    }

    public void deleteUser(User user) {
        boolean success = userService.removeUser(user);
        if (success) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("User delete failed");
        }
    }

    public void validateUser(String username, String hashedPassword, String name, String email) {
        
    }


}
