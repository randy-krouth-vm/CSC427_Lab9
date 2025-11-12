package edu.secourse.controllers.services;

import edu.secourse.patientportal.enums.Roles;
import edu.secourse.patientportal.models.Appointment;
import edu.secourse.patientportal.models.Doctor;
import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.services.AppointmentsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppointmentServiceTest {
    @Test
    @DisplayName("createAppointment(): create an appointment")
    void createAppointment() {
        // Arrange
        AppointmentsService appointmentsService = new AppointmentsService();
        Patient patient = new Patient(11234, "alice3", "23lkjsdf03j", "Alice Fiona", "alicefiona3@gmail.com", Roles.Patient);
        Doctor doctor = new Doctor(11093, "Doctor Jones", "sljdfoj23j5l", "Raul Jones", "RaulJones@gmail.com", Roles.Doctor);
        Appointment appointment = new Appointment(1, patient, doctor);

        // Act
        appointmentsService.createAppointment(appointment);

        // Assert
        assertEquals(1, appointmentsService.getAppointments().size());
        assertTrue(appointmentsService.getAppointments().contains(appointment));
    }

    @Test
    @DisplayName("cancelAppointment(): cancel an appointment")
    public void cancelAppointment()
    {
        // Arrange
        AppointmentsService appointmentsService = new AppointmentsService();
        Patient patient = new Patient(11234, "alice3", "23lkjsdf03j", "Alice Fiona", "alicefiona3@gmail.com", Roles.Patient);
        Doctor doctor = new Doctor(11093, "Doctor Jones", "sljdfoj23j5l", "Raul Jones", "RaulJones@gmail.com", Roles.Doctor);
        Appointment appointment = new Appointment(1, patient, doctor);

        // Act
        appointmentsService.createAppointment(appointment);
        appointmentsService.cancelAppointment(appointment);

        // Assert
        assertEquals(0, appointmentsService.getAppointments().size());
        assertFalse(appointmentsService.getAppointments().contains(appointment));
    }

    @Test
    @DisplayName("modifyAppointment(): modify an appointment")
    public void modifyAppointment()
    {
        // Arrange
        AppointmentsService appointmentsService = new AppointmentsService();

        Patient patient = new Patient(11234, "alice3", "23lkjsdf03j", "Alice Fiona", "alicefiona3@gmail.com", Roles.Patient);
        Doctor doctor = new Doctor(11093, "Doctor Jones", "sljdfoj23j5l", "Raul Jones", "RaulJones@gmail.com", Roles.Doctor);
        Appointment appointment = new Appointment(1, patient, doctor);

        Patient patientTwo = new Patient(11234, "bob3", "23lsljdlff03j", "Bob Bushay", "bobbybushay@gmail.com", Roles.Patient);
        Doctor doctorTwo = new Doctor(11093, "Doctor Knoxs", "lkjldfslkoaaf", "Johnny Knoxs", "JohnnyKnoxs@gmail.com", Roles.Doctor);
        Appointment appointmentTwo = new Appointment(1, patientTwo, doctorTwo);

        // Act
        appointmentsService.createAppointment(appointment);
        appointmentsService.modifyAppointment(appointmentTwo);

        // Assert
        assertEquals(1, appointmentsService.getAppointments().size());
        assertTrue(appointmentsService.getAppointments().contains(appointmentTwo));
    }

    @Test
    @DisplayName("getAppointments(): gets appointments")
    public void getAppointmentsTest() {
        // Arrange
        AppointmentsService appointmentsService = new AppointmentsService();

        Patient patient = new Patient(11234, "alice3", "23lkjsdf03j", "Alice Fiona", "alicefiona3@gmail.com", Roles.Patient);
        Doctor doctor = new Doctor(11093, "Doctor Jones", "sljdfoj23j5l", "Raul Jones", "RaulJones@gmail.com", Roles.Doctor);
        Appointment appointment = new Appointment(1, patient, doctor);

        Patient patientTwo = new Patient(11234, "bob3", "23lsljdlff03j", "Bob Bushay", "bobbybushay@gmail.com", Roles.Patient);
        Doctor doctorTwo = new Doctor(11093, "Doctor Knoxs", "lkjldfslkoaaf", "Johnny Knoxs", "JohnnyKnoxs@gmail.com", Roles.Doctor);
        Appointment appointmentTwo = new Appointment(1, patientTwo, doctorTwo);

        // Act
        appointmentsService.createAppointment(appointment);
        appointmentsService.createAppointment(appointmentTwo);

        // Assert
        assertEquals(2, appointmentsService.getAppointments().size());
        assertTrue(appointmentsService.getAppointments().contains(appointment));
        assertTrue(appointmentsService.getAppointments().contains(appointmentTwo));
    }
}
