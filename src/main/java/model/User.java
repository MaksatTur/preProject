package model;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String passport;

    public User() {
    }

    public User(long id, String name, String surname, Date dateOfBirth, String passport) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
    }

    public User(String name, String surname, Date dateOfBirth, String passport) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
