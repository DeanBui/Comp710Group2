package com.example.duyqu.comp710group2;

import android.location.Location;

public class Profile{

    private String occupation;
    private String email;
    private int age;
    private Location locate;
    private int group;
    private String name;
    public Profile(){

    }

    public Profile ( String email, int age ,String occupation, int group, String name){
        this.setEmail(email);
        this.setAge(age);
        this.setOccupation(occupation);
        this.setGroup(group);
        this.setName(name);
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getLocate() {
        return locate;
    }

    public void setLocate(Location locate) {
        this.locate = locate;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
