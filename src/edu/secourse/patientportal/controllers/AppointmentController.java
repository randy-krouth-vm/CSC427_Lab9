package edu.secourse.patientportal.controllers;
import edu.secourse.patientportal.models.*;
import edu.secourse.patientportal.services.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    public void createAppointment(Appointment appointment) {
        try {
            boolean success = appointmentService.createAppointment(appointment);
            if (success) {
                System.out.println("Appointment created successfully");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating the appointment: " + e.getMessage());
        }
    }


    public void cancelAppointment(int appointmentId) {
        boolean success = appointmentService.cancelAppointment(appointmentId);
        if (success) {
            System.out.println("Appointment cancelled successfully");
        } else {
            System.out.println("Appointment not found");
        }
    }


    public void modifyAppointment(int appointmentId, Patient patient, Doctor doctor, LocalDateTime newDateTime) {
        try {
            boolean success = appointmentService.modifyAppointment(appointmentId, patient, doctor, newDateTime);
            if (success) {
                System.out.println("Appointment modified successfully");
            } else {
                System.out.println("Appointment not found");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error modifying appointment: " + e.getMessage());
        }
    }


    public void printAppointmentsForPatient(Patient patient) {
        List<Appointment> appointments = appointmentService.getAppointmentsForPatient(patient);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for patient: " + patient.getName());
        } else {
            System.out.println("Appointments for patient " + patient.getName() + ":");
            for (int i = 0; i < appointments.size(); i++) {
                Appointment appointment = appointments.get(i);
                System.out.println("Appointment #" + appointment.getAppointmentId() +
                        " with Dr. " + appointment.getDoctor().getName() +
                        " at " + appointment.getAppointmentDateTime() +
                        " [" + appointment.getStatus() + "]");
            }
        }
    }


    public void printAppointmentsForDoctor(Doctor doctor) {
        List<Appointment> appointments = appointmentService.getAppointmentsForDoctor(doctor);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for doctor: " + doctor.getName());
        } else {
            System.out.println("Appointments for Dr. " + doctor.getName() + ":");
            for (int i = 0; i < appointments.size(); i++) {
                Appointment appointment = appointments.get(i);
                System.out.println("Appointment #" + appointment.getAppointmentId() +
                        " with patient " + appointment.getPatient().getName() +
                        " at " + appointment.getAppointmentDateTime() +
                        " [" + appointment.getStatus() + "]");
            }
        }

    }
}
