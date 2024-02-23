package no.ntnu.IDATA2306.Group6;

public class User {

    private String fname;
    private String lname;
    private String mail;
    private String gender;
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "User [fname="+ fname +",lname="+ lname +", mail="+ mail +", gender="+ gender +"]";

    }

    
}