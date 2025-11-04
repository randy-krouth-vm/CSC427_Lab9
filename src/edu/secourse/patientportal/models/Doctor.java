package edu.secourse.patientportal.models;

public class Doctor extends User {

    private int doctorId;
    private static int nextDoctorId = 1;

    public Doctor(String username, String hashedPassword, String name, String email ){
        super(username, hashedPassword, name, email, "doctor");
        this.doctorId = nextDoctorId++;
    }

    public int getDoctorId() {
        return doctorId;
    }

}
