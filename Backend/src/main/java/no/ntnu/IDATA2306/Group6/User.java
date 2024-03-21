package no.ntnu.IDATA2306.Group6;
import java.util.Objects;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class User {

    private String name; 
    private String email;
    private String password;
    private String hashedPassword;
    private String address;
    private String gender;
    private String phone;
    private String dob;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

   
    public User(String name, String email, String password, String address, String gender, String phone, String dob) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.hashedPassword = hashPassword(); 
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
    }

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.hashedPassword = encoder.encode(password); 
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

   
    private String hashPassword() {
        return encoder.encode(this.password);
    }

    public boolean matchPassword(String rawPassword) {
        return encoder.matches(rawPassword, this.hashedPassword);
    }


}
