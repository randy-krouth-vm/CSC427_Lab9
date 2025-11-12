package edu.secourse.controllers.services;

import edu.secourse.patientportal.enums.Roles;
import edu.secourse.patientportal.models.Patient;
import edu.secourse.patientportal.models.User;
import edu.secourse.patientportal.models.Doctor;
import edu.secourse.patientportal.models.Admin;
import edu.secourse.patientportal.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserServiceTest {

    @Test
    @DisplayName("createUser(): create a user")
    public void createUserTest()
    {
        // Arrange
        UserService userService = new UserService();
        User patient = new Patient(1004, "jfox", "lskjdlfjsdj", "John Fox", "johnfox8@gmail.com", Roles.Patient);
        User admin = new Admin(1304, "bjones", "sdlfkjlsj", "Brian Jones", "brianjones@gmail.com", Roles.Admin);
        User doctor = new Doctor(1024, "rraux", "lkmlksljdioj", "Raul Rox", "raulrox23@gmail.com", Roles.Doctor);

        // Act
        userService.createUser(patient);
        userService.createUser(admin);
        userService.createUser(doctor);

        // Assert
        assertTrue(userService.getUsers().contains(patient));
        assertTrue(userService.getUsers().contains(admin));
        assertTrue(userService.getUsers().contains(doctor));
    }

    @Test
    @DisplayName("removeUser(): remove a user")
    public void removeUserTest()
    {
        // Arrange
        UserService userService = new UserService();
        User patient = new Patient(1004, "jfox", "lskjdlfjsdj", "John Fox", "johnfox8@gmail.com", Roles.Patient);
        User admin = new Admin(1304, "bjones", "sdlfkjlsj", "Brian Jones", "brianjones@gmail.com", Roles.Admin);
        User doctor = new Doctor(1024, "rraux", "lkmlksljdioj", "Raul Rox", "raulrox23@gmail.com", Roles.Doctor);

        // Act
        userService.createUser(patient);
        userService.createUser(admin);
        userService.createUser(doctor);

        userService.removeUser(patient);
        userService.removeUser(admin);
        userService.removeUser(doctor);

        // Assert
        assertFalse(userService.getUsers().contains(patient));
        assertFalse(userService.getUsers().contains(admin));
        assertFalse(userService.getUsers().contains(doctor));
        assertEquals(0, userService.getUsers().size());
    }

    @Test
    @DisplayName("updateUserTest(): update a user")
    public void updateUserTest()
    {
        // Arrange
        UserService userService = new UserService();
        User patient = new Patient(1004, "jfox", "lskjdlfjsdj", "John Fox", "johnfox8@gmail.com", Roles.Patient);
        User admin = new Admin(1004, "bjones", "sdlfkjlsj", "Brian Jones", "brianjones@gmail.com", Roles.Admin);

        // Act
        userService.createUser(patient);
        userService.updateUser(admin);

        // Assert
        assertEquals(1, userService.getUsers().size());
        assertTrue(userService.getUsers().contains(admin));
    }

    @Test
    @DisplayName("getUsersTest(): get users")
    public void getUsersTest()
    {
        // Arrange
        UserService userService = new UserService();
        User patient = new Patient(1004, "jfox", "lskjdlfjsdj", "John Fox", "johnfox8@gmail.com", Roles.Patient);
        User admin = new Admin(1304, "bjones", "sdlfkjlsj", "Brian Jones", "brianjones@gmail.com", Roles.Admin);
        User doctor = new Doctor(1024, "rraux", "lkmlksljdioj", "Raul Rox", "raulrox23@gmail.com", Roles.Doctor);

        // Act
        userService.createUser(patient);
        userService.createUser(admin);
        userService.createUser(doctor);

        // Assert
        assertEquals(3, userService.getUsers().size());
        assertTrue(userService.getUsers().contains(patient));
        assertTrue(userService.getUsers().contains(admin));
        assertTrue(userService.getUsers().contains(doctor));
    }
}
