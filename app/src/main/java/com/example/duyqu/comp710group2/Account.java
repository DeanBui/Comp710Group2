package com.example.duyqu.comp710group2;

/**
 * Created by duyqu on 2/28/2018.
 */
//test Regina
public class Account {

    private String UserName;
    private String Password;
    private int id;
    public Account (){

    }
    public Account(String UserName, String Password){

    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}