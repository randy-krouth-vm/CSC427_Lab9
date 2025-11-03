package edu.secourse.patientportal.controllers;

import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.services.UserService;

public class UserController {

    UserService userService = new UserService();

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //Create User
    public void createUser(User user){
        boolean success = userService.createUser(user);
        if(success){
            System.out.println("User created successfully");
        }
        else{
            System.out.println("User creation failed");
        }
    }


    public void updateUser(int accountNumber, String username, String hashedPassword, String name, String email){
        boolean success = userService.updateUser(accountNumber, username, hashedPassword, name, email);
        if(success){
            System.out.println("User updated successfully");

        }
        else{
            System.out.println("User update failed");
        }

    }

    public void deleteUser(User user){
        boolean success = userService.removeUser(user);
        if(success){
            System.out.println("User deleted successfully");
        }
        else{
            System.out.println("User delete failed");
        }
    }





}
