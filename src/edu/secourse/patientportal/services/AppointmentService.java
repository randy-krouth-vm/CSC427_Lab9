package edu.secourse.patientportal.services;

import edu.secourse.patientportal.models.Appointment;
import edu.secourse.patientportal.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    ArrayList<Appointment> appointments = new ArrayList<Appointment>();


    //create appointment
    public boolean createAppointment(Appointment appointment) {

        for(int i = 0; i < appointments.size(); i++) {

            Appointment existingAppointment = appointments.get(i);
            if(existingAppointment.getAppointmentId() == appointment.getAppointmentId()) {
                throw new IllegalArgumentException("Appointment already exists");
            }
        }

        if (appointment.getPatient() == null) {
            throw new IllegalArgumentException("Appointment must have a patient");
        }


        if (appointment.getDoctor() == null) {
            throw new IllegalArgumentException("Appointment must have a doctor");
        }


        if (appointment.getAppointmentDateTime() == null || appointment.getAppointmentDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment date/time must be in the future");
        }


        appointments.add(appointment);
        return true;
    }





    // Cancel Appointment
    public boolean cancelAppointment(int appointmentId) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (appointment.getAppointmentId() == appointmentId) {
                appointment.setStatus(Appointment.Status.CANCELLED);
                return true;
            }
        }
        return false;
    }


    public boolean modifyAppointment(int appointmentId, Patient patient, Doctor doctor, LocalDateTime newDateTime) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (appointment.getAppointmentId() == appointmentId) {
                appointment.setPatient(patient);
                appointment.setDoctor(doctor);
                appointment.setAppointmentDateTime(newDateTime);
                appointment.setStatus(Appointment.Status.ACTIVE);
                return true;
            }
        }
        return false;
    }


    public List<Appointment> getAppointmentsForPatient(Patient patient) {
        List<Appointment> result = new ArrayList<>();
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (appointment.getPatient().equals(patient)) {
                result.add(appointment);
            }
        }
        return result;
    }


    public List<Appointment> getAppointmentsForDoctor(Doctor doctor) {
        List<Appointment> result = new ArrayList<>();
        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment = appointments.get(i);
            if (appointment.getDoctor().equals(doctor)) {
                result.add(appointment);
            }
        }
        return result;
    }







}