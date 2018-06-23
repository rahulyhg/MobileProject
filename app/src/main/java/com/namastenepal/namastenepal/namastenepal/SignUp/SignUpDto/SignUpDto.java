package com.namastenepal.namastenepal.namastenepal.SignUp.SignUpDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignUpDto {
    public static List<SignUpDto> signUpDtoList = new ArrayList<>();
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String email;
    private String password1;
    private String password2;
    private String username;

    public SignUpDto(String email, String password1, String password2, String username) {
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
