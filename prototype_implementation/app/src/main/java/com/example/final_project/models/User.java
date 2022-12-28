package com.example.final_project.models;

public class User {
    private String username;
    private String password;
    private String acct_type;

    public User(String user, String pass, String type) {
        username = user;
        password = pass;
        acct_type = type;
    }

    public String getAcctType() {
        return this.acct_type;
    }

    public String getpwd() {
        return this.password;
    }
}
