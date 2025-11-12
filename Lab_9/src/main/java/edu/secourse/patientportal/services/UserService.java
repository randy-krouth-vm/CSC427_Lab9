package edu.secourse.patientportal.services;

import edu.secourse.patientportal.models.Appointment;
import edu.secourse.patientportal.models.User;
import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users = new ArrayList<User>();

    //Create User
    public boolean createUser(User user) {
        try {
            if(user != null && users != null){
                if (!users.contains(user)) {
                    users.add(user);
                    return true;
                }
            }
        }catch(Exception e){
            IO.println(e);
        }
        return false;
    }

    //Remove User
    public boolean removeUser(User user) {
        try {
            if(user != null && users != null){
                if (users.contains(user)) {
                    users.remove(user);
                    return true;
                }
            }
        }catch(Exception e){
            IO.println(e);
        }
        return false;
    }

    //Update User details
    public boolean updateUser(User userToUpdate) {
        //Checks to see if new username is already taken by another user

        try {
            //Finds correct user and updates the information
            if(users != null && userToUpdate != null) {
                for (int i = 0; i < users.size(); i++) {
                    User current = users.get(i);
                    if (current.getAccountNumber() == userToUpdate.getAccountNumber()) {
                        users.set(i, userToUpdate);
                        break;
                    }
                }
            }
        }catch(Exception e){
            IO.println(e);
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        try{
            if(users != null) {
                return users;
            }
        } catch (Exception e) {
            IO.println(e);
        }
        return null;
    }
}