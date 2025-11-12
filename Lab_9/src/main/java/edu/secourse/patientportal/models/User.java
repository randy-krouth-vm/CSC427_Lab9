package edu.secourse.patientportal.models;

import edu.secourse.patientportal.enums.Roles;

public abstract class User {

    private int accountNumber = -1;
    private String username = "";
    private String hashedPassword = "";
    private String name = "";
    private String email = "";
    private Roles role = Roles.NotSpecified;

    public User(){

    }

    public User(int accountNumber, String username, String hashedPassword, String name, String email, Roles role) {

        boolean validAccount = accountNumber > 0;
        boolean validUsername = username != null && !username.isBlank();
        boolean validPassword = hashedPassword != null && !hashedPassword.isBlank();
        boolean validName = name != null && !name.isBlank();
        boolean validEmail = email != null && email.contains("@") && email.contains(".");
        boolean validRole = role != null;

        if (!validAccount) {
            IO.println("Invalid account number: must be positive.");
        }

        if (!validUsername) {
            IO.println("Invalid username: cannot be null or blank.");
        }

        if (!validPassword) {
            IO.println("Invalid password: cannot be null or blank.");
        }

        if (!validName) {
            IO.println("Invalid name: cannot be null or blank.");
        }

        if (!validEmail) {
            IO.println("Invalid email address format: " + email);
        }

        if (!validRole) {
            IO.println("Invalid role: cannot be null.");
        }

        if(validAccount && validUsername && validPassword && validName &&
           validEmail && validRole) {
            this.accountNumber = accountNumber;
            this.username = username;
            this.hashedPassword = hashedPassword;
            this.name = name;
            this.email = email;
            this.role = role;
        }
    }

    public void setAccountNumber(int accountNumber) {
        boolean isValid = accountNumber > 0;
        if (isValid) {
            this.accountNumber = accountNumber;
        } else {
            IO.println("Invalid account number: must be positive.");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setUsername(String username) {
        boolean isValid = username != null && !username.isBlank();
        if (isValid) {
            this.username = username;
        } else {
            IO.println("Invalid username: cannot be empty or null.");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setHashedPassword(String hashedPassword) {
        boolean isValid = hashedPassword != null && !hashedPassword.isBlank();
        if (isValid) {
            this.hashedPassword = hashedPassword;
        } else {
            IO.println("Invalid password: cannot be empty or null.");
        }
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setName(String name) {
        boolean isValid = name != null && !name.isBlank();
        if (isValid) {
            this.name = name;
        } else {
            IO.println("Invalid name: cannot be empty or null.");
        }
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        boolean isValid = email != null && email.contains("@") && email.contains(".");
        if (isValid) {
            this.email = email;
        } else {
            IO.println("Invalid email address format: " + email);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setRole(Roles role) {
        if (role != null) {
            this.role = role;
        } else {
            IO.println("Invalid role: cannot be null.");
        }
    }

    public Roles getRole() {
        return role;
    }
}
