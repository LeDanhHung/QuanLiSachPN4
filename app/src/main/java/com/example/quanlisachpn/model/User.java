package com.example.quanlisachpn.model;

import android.graphics.Bitmap;

public class User {
    private String name;
    private String phoneNumber;
    private String password;
    private Bitmap image;

    public User(String name, String phoneNumber, String password, Bitmap image) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
