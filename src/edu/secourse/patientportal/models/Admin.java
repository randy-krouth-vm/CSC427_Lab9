package edu.secourse.patientportal.models;

public class Admin extends User {

    private int adminId;
    private static int nextAdminId = 1;

    public Admin(String username, String hashedPassword, String name, String email ){
        super(username, hashedPassword, name, email, "admin");
        this.adminId = nextAdminId++;
    }

    public int getAdminId() {
        return adminId;
    }

}