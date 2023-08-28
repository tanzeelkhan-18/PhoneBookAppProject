package main.java.com.phonebookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String loginName;
	private String password;
	private String status;
	private String role;
}
