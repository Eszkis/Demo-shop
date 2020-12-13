package com.codecool.shop.model;

public class Customer {

    public String firstName;
    public String lastName;
    public String country;
    public String city;
    public String address;
    public String zipCode;
    public String email;
    public String phone;

    public Customer(String firstName, String lastName, String country, String city,
            String address, String zipCode, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
    }
}
