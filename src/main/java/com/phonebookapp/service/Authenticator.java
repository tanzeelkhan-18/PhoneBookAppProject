package main.java.com.phonebookapp.service;

import main.java.com.phonebookapp.dao.UsersDao;
import main.java.com.phonebookapp.dao.UsersDaoImpl;
import main.java.com.phonebookapp.model.Users;

import java.io.IOException;

public class Authenticator {
    public Users authenticate(String loginName, String password) throws IOException {
        UsersDao ud = new UsersDaoImpl();
        return ud.authenticate(loginName,password);
    }
}
