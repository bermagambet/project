package com.company;

import java.io.Serializable;

public class LoginPassword implements Serializable {
    private String login;
    private String password;
    public LoginPassword(String login, String password){
        this.login = login;
        this.password = password;
    }
}
