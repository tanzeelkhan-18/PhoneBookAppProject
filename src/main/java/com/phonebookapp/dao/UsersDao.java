package main.java.com.phonebookapp.dao;

import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import main.java.com.phonebookapp.model.Users;

public interface UsersDao {
	public Users authenticate(String loginName, String password) throws IOException;
}
