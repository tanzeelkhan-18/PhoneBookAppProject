package main.java.com.phonebookapp.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.phonebookapp.model.Users;

public class UsersDaoImpl implements UsersDao {

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public Users authenticate(String loginName, String password) throws IOException {
		List<Users> usersList = Arrays.asList(mapper.readValue(new File("data/login.json"), Users[].class));
        Users userFound = usersList.stream()
                        .filter(user -> user.getLoginName().equals(loginName))
                .findAny().orElse(null);
        return userFound;
	}

}
