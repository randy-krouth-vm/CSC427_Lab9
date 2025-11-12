package edu.secourse.controllers.models;

import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.models.Admin;
import edu.secourse.patientportal.models.Doctor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import edu.secourse.patientportal.enums.Roles;

public class UserTest {

    @Test
    @DisplayName("Constructor sets valid fields correctly")
    void testValidConstructor() {
        // Arrange & Act
        User user = new Admin(
                1001,
                "jdoe",
                "hashed123",
                "John Doe",
                "john@example.com",
                Roles.Admin
        );

        // Assert
        assertEquals(1001, user.getAccountNumber());
        assertEquals("jdoe", user.getUsername());
        assertEquals("hashed123", user.getHashedPassword());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals(Roles.Admin, user.getRole());
    }

    @Test
    @DisplayName("Constructor ignores invalid fields and keeps defaults")
    void testInvalidConstructor() {
        // Arrange & Act
        User user = new Patient(
            -5,
            "",
            "",
            null,
            "bademail",
            null
        );

        // Assert
        assertEquals(-1, user.getAccountNumber());
        assertEquals("", user.getUsername());
        assertEquals("", user.getHashedPassword());
        assertEquals("", user.getName());
        assertEquals("", user.getEmail());
        assertEquals(Roles.NotSpecified, user.getRole());
    }

    @Test
    @DisplayName("setAccountNumber(): updates only if positive; getter reflects latest value")
    void testSetGetAccountNumber() {
        // Arrange
        User user = new Patient();

        // Act
        user.setAccountNumber(123);

        // Assert
        assertEquals(123, user.getAccountNumber());

        // Act
        user.setAccountNumber(-10);

        // Assert
        assertEquals(123, user.getAccountNumber());
    }

    @Test
    @DisplayName("setUsername(): updates only if non-empty; getter returns correct value")
    void testSetGetUsername() {
        // Arrange
        User user = new Doctor();

        // Act
        user.setUsername("alice");

        // Assert
        assertEquals("alice", user.getUsername());

        // Act
        user.setUsername("");

        // Assert
        assertEquals("alice", user.getUsername());
    }

    @Test
    @DisplayName("setHashedPassword(): updates only if non-empty; getter returns correct value")
    void testSetGetHashedPassword() {
        // Arrange
        User user = new Admin();

        // Act
        user.setHashedPassword("hash123");

        // Assert
        assertEquals("hash123", user.getHashedPassword());

        // Act
        user.setHashedPassword(null);

        // Assert
        assertEquals("hash123", user.getHashedPassword());
    }

    @Test
    @DisplayName("setName(): updates only if valid; getter returns correct value")
    void testSetGetName() {
        // Arrange
        User user = new Patient();

        // Act
        user.setName("Bob Builder");

        // Assert
        assertEquals("Bob Builder", user.getName());

        // Act
        user.setName("");

        // Assert
        assertEquals("Bob Builder", user.getName());
    }

    @Test
    @DisplayName("setEmail(): updates only if valid format; getter returns correct value")
    void testSetGetEmail() {
        // Arrange
        User user = new Doctor();

        // Act
        user.setEmail("bob@mail.com");

        // Assert
        assertEquals("bob@mail.com", user.getEmail());

        // Act
        user.setEmail("invalidemail");

        // Assert
        assertEquals("bob@mail.com", user.getEmail());
    }

    @Test
    @DisplayName("setRole(): updates only if non-null; getter returns correct value")
    void testSetGetRole() {
        // Arrange
        User user = new Admin();

        // Act
        user.setRole(Roles.Patient);

        // Assert
        assertEquals(Roles.Patient, user.getRole());

        // Act
        user.setRole(null);

        // Assert
        assertEquals(Roles.Patient, user.getRole());
    }

    @Test
    @DisplayName("User maintains consistent data through valid setters and getters")
    void testUserStateConsistency() {
        // Arrange
        User user = new Patient();

        // Act
        user.setAccountNumber(2024);
        user.setUsername("msharma");
        user.setHashedPassword("securehash");
        user.setName("Madhav Sharma");
        user.setEmail("madhav@health.com");
        user.setRole(Roles.Doctor);

        // Assert
        assertAll("User Data",
                () -> assertEquals(2024, user.getAccountNumber()),
                () -> assertEquals("msharma", user.getUsername()),
                () -> assertEquals("securehash", user.getHashedPassword()),
                () -> assertEquals("Madhav Sharma", user.getName()),
                () -> assertEquals("madhav@health.com", user.getEmail()),
                () -> assertEquals(Roles.Doctor, user.getRole())
        );
    }
}
