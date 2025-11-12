package edu.secourse.controllers.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.models.Doctor;
import edu.secourse.patientportal.models.Appointment;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    @DisplayName("Constructor sets valid fields correctly")
    void testValidConstructor() {
        // Arrange
        Patient patient = new Patient();
        Doctor doctor = new Doctor();

        // Act
        Appointment appointment = new Appointment(10, patient, doctor);

        // Assert
        assertEquals(10, appointment.getAppointmentId());
        assertEquals(patient, appointment.getPatient());
        assertEquals(doctor, appointment.getDoctor());
        assertNotNull(appointment.getAppointmentDateTime());
    }

    @Test
    @DisplayName("Constructor ignores invalid data and keeps defaults")
    void testInvalidConstructor() {
        // Arrange & Act
        Appointment appointment = new Appointment(-5, null, null);

        // Assert
        assertEquals(-1, appointment.getAppointmentId());
        assertNotNull(appointment.getPatient());
        assertNotNull(appointment.getDoctor());
        assertNotNull(appointment.getAppointmentDateTime());
    }

    @Test
    @DisplayName("setAppointmentId() updates only if positive")
    void testSetAppointmentId() {
        // Arrange
        Appointment appointment = new Appointment();

        // Act
        appointment.setAppointmentId(42);

        // Assert
        assertEquals(42, appointment.getAppointmentId());

        // Act
        appointment.setAppointmentId(-9);

        // Assert
        assertEquals(42, appointment.getAppointmentId());
    }

    @Test
    @DisplayName("setPatient() updates only if non-null")
    void testSetPatient() {
        // Arrange
        Appointment appointment = new Appointment();
        Patient patient = new Patient();

        // Act
        appointment.setPatient(patient);

        // Assert
        assertEquals(patient, appointment.getPatient());

        // Act
        appointment.setPatient(null);

        // Assert
        assertEquals(patient, appointment.getPatient());
    }

    @Test
    @DisplayName("setDoctor() updates only if non-null")
    void testSetDoctor() {
        // Arrange
        Appointment appointment = new Appointment();
        Doctor doctor = new Doctor();

        // Act
        appointment.setDoctor(doctor);

        // Assert
        assertEquals(doctor, appointment.getDoctor());

        // Act
        appointment.setDoctor(null);

        // Assert
        assertEquals(doctor, appointment.getDoctor()); // unchanged
    }

    @Test
    @DisplayName("setAppointmentDateTime() updates only if valid")
    void testSetAppointmentDateTime() {
        // Arrange
        Appointment appointment = new Appointment();
        LocalDateTime now = LocalDateTime.now();

        // Act
        appointment.setAppointmentDateTime(now.plusDays(1));

        // Assert
        assertEquals(now.plusDays(1).getDayOfMonth(), appointment.getAppointmentDateTime().getDayOfMonth());

        // Act
        appointment.setAppointmentDateTime(null);

        // Assert
        assertNotNull(appointment.getAppointmentDateTime());
    }

    @Test
    @DisplayName("Appointment maintains valid state through getters")
    void testGettersReturnCorrectValues() {
        // Arrange
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        LocalDateTime date = LocalDateTime.of(2025, 11, 12, 9, 30);
        Appointment appointment = new Appointment();

        // Act
        appointment.setAppointmentId(111);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDateTime(date);

        // Assert
        assertAll("Appointment Data",
                () -> assertEquals(111, appointment.getAppointmentId()),
                () -> assertEquals(patient, appointment.getPatient()),
                () -> assertEquals(doctor, appointment.getDoctor()),
                () -> assertEquals(date, appointment.getAppointmentDateTime())
        );
    }
}

