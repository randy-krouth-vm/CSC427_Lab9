package edu.secourse.patientportal;

import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.services.UserService;
import edu.secourse.patientportal.controllers.UserController;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        // Create a new user
        User user1 = new Patient(1,"john_doe", "pass123", "John Doe", "john@example.com");
        userController.createUser(user1);

        userController.updateUser(1,"jane_doe", "pass1234", "Jane Doe", "jane@example.com");



        // Remove a user
        userController.deleteUser(user1);

        // Try to remove again
        userController.deleteUser(user1);
    }
}