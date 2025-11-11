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

    public User getUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }

        }


                throw new IllegalArgumentException("Username not found");


        }




    public void printUser(User user) {
        System.out.println("\nAccount Number: " + user.getAccountNumber());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());



    }


    //Remove User
    public boolean removeUser(User user) {


     for(int i = 0; i < users.size(); i++) {

         if (users.get(i).getUsername().equals(user.getUsername())) {
             users.remove(user);
             return true;

         }
     }

     throw new IllegalArgumentException("User not found");

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
