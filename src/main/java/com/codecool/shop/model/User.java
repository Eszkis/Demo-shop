package com.codecool.shop.model;

public class User {
    private String username;
    private  String passwordToken;
    private String email;


    public User(String username, String passwordToken, String email) {
        this.username = username;
        this.passwordToken = passwordToken;
        this.email = email;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public void setPasswordToken(char[] password) {
        this.passwordToken = passwordToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
