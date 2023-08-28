package main.java.com.phonebookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBook {
	private int numberId;
	private String name;
	private String phoneNumber;
	private LocalDate dob;
}
