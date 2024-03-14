package no.ntnu.IDATA2306.Group6;

import java.util.Objects;

/**
 * Represents a resource: a User. We store user objects in the application state.
 */
public final class User {
    
    private final String email;
    private final String password;

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return Objects.equals(this.email, that.email) &&
                Objects.equals(this.password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    @Override
    public String toString() {
        return "User[" +
                "email=" + email + ", " +
                "password=" + password + ']';
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
