package com.example.android.boostgym;

public class Instructors {
    private  String name,contact,email,gender ;

    public Instructors(String name, String contact, String email, String gender){
        this.name= name;
        this.contact=contact;
        this.email=email;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
