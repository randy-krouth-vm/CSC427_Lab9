package edu.secourse.patientportal.models;

public class Patient extends User {

    private int patientId;
    private static int nextPatientId = 1;


    public Patient(String username, String hashedPassword, String name, String email) {
        super(username, hashedPassword, name, email, "patient");
        this.patientId = nextPatientId++;
    }

    public int getPatientId() {
        return patientId;
    }
}

