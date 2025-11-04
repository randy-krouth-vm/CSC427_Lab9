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
        User user1 = new Patient("john_doe", "pass123", "John Doe", "john@example.com");
        userController.createUser(user1);

        User user2 = new Patient("john_p", "pass123", "John Poe", "john@example.com");
        userController.createUser(user2);




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