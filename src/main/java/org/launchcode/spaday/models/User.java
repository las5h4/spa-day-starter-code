package org.launchcode.spaday.models;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class User {

    @NotBlank
    @Size(min = 5, max = 15, message = "Username should be between 5 and 15 characters long")
    private String username;

    @Email(message = "Not a valid E-Mail")
    private String email;

    @NotBlank(message = "please create a password")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "Your passwords must match!")
    private String verify;

    private int id;
    private static int nextId = 1;
    private String dateCreated;

    public User(String username, String email, String password, String verify) {
        this ();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;

        Date currentDate = new Date();
        this.dateCreated = currentDate.toString();
    }

    public User() {
        this.id = nextId;
        nextId++;
    }

    private void checkPassword() {
        if (!password.equals(verify) && (password != null) && (verify != null)) {
            verify = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.checkPassword();
    }

    public int getId() {
        return id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        this.checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
