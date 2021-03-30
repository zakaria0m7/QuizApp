package com.example.quizapp;

import android.icu.text.Replaceable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User {
    String name,mail,password;

    public User(String n,String m,String p) {
        this.name = n;
        this.mail = m;
        this.password = p;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
