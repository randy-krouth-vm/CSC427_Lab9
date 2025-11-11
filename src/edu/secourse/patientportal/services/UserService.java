package edu.secourse.patientportal.services;

import edu.secourse.patientportal.models.User;

import java.util.ArrayList;

public class UserService {
    ArrayList<User> users = new ArrayList<User>();




    //Create User
    public boolean createUser(User user) {




        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUsername().equals(user.getUsername())) {


               throw new IllegalArgumentException("Username already exists");


            }

            if (users.get(i).getEmail().equals(user.getEmail())) {


               throw new IllegalArgumentException("Email already exists");


            }




        }


        users.add(user);
        return true;
    }


    //Remove User
    public boolean removeUser(User user) {
        if (users.contains(user) == false) {
            return false;
        }

        users.remove(user);
        return true;
    }


    //Update User details

    public boolean updateUser(int accountNumber, String username, String hashedPassword, String name, String email) {


        //Checks to see if new username is already taken by another user

        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if (currentUser.getUsername().equals(username) && currentUser.getAccountNumber() != accountNumber) {
                return false;
            }
        }


        //Finds correct user and updates the information
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getAccountNumber() == accountNumber) {

                user.setUsername(username);
                user.setHashedPassword(hashedPassword);
                user.setName(name);
                user.setEmail(email);

                return true;


            }


        }
        return false;
    }


}
