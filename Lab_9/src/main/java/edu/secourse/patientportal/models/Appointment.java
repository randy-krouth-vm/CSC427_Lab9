package edu.secourse.patientportal.models;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class Appointment {

    private int appointmentId = -1;
    private Patient patient = new Patient();
    private Doctor doctor = new Doctor();
    private LocalDateTime appointmentDateTime = LocalDateTime.now();

    public Appointment() { }

    public Appointment(int appointmentId, Patient patient, Doctor doctor) {

        boolean validId = appointmentId > 0;
        boolean validPatient = patient != null;
        boolean validDoctor = doctor != null;

        if (!validId) {
            IO.println("Invalid appointment ID: must be positive.");
        }

        if (!validPatient) {
            IO.println("Invalid patient: cannot be null.");
        }

        if (!validDoctor) {
            IO.println("Invalid doctor: cannot be null.");
        }

        // assign only if all are valid
        if (validId && validPatient && validDoctor) {
            this.appointmentId = appointmentId;
            this.patient = patient;
            this.doctor = doctor;
            this.appointmentDateTime = LocalDateTime.now();
        }
    }

    public void setAppointmentId(int appointmentId) {
        if (appointmentId > 0) {
            this.appointmentId = appointmentId;
        } else {
            IO.println("Invalid appointment ID: must be positive.");
        }
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setPatient(Patient patient) {
        if (patient != null) {
            this.patient = patient;
        } else {
            IO.println("Invalid patient: cannot be null.");
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setDoctor(Doctor doctor) {
        if (doctor != null) {
            this.doctor = doctor;
        } else {
            IO.println("Invalid doctor: cannot be null.");
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        if (appointmentDateTime != null ) {
            this.appointmentDateTime = appointmentDateTime;
        } else {
            IO.println("Invalid date/time: cannot be null or excessively old.");
        }
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
}

