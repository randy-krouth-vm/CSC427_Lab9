package edu.secourse.patientportal.services;

import edu.secourse.patientportal.models.Appointment;

import java.util.ArrayList;

public class AppointmentsService {

    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public AppointmentsService() {

    }

    public void createAppointment(Appointment appointment) {
        try {
            if(appointment != null && appointments != null) {
                appointments.add(appointment);
            }
        } catch (Exception e) {
            IO.println(e);
        }
    }

    public void cancelAppointment(Appointment appointmentToCancel)
    {
        try {
            if(appointmentToCancel != null && appointments != null) {
                appointments.removeIf(appointment -> appointment.equals(appointmentToCancel));
            }
        } catch (Exception e) {
            IO.println(e);
        }
    }

    public void modifyAppointment(Appointment modifiedAppointment)
    {
        try {
            if(modifiedAppointment != null && appointments != null) {
                for (int i = 0; i < appointments.size(); i++) {
                    Appointment current = appointments.get(i);
                    if (current.getAppointmentId() == modifiedAppointment.getAppointmentId()) {
                        appointments.set(i, modifiedAppointment);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            IO.println(e);
        }
    }

    public ArrayList<Appointment> getAppointments() {
        try{
            if(appointments != null) {
                return appointments;
            }
        } catch (Exception e) {
            IO.println(e);
        }
        return null;
    }
}
