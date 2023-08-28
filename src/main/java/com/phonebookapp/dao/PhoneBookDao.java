package main.java.com.phonebookapp.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import main.java.com.phonebookapp.exceptions.DuplicateNameException;
import main.java.com.phonebookapp.exceptions.DuplicatePhoneNumberException;
import main.java.com.phonebookapp.model.PhoneBook;

public interface PhoneBookDao {
	public boolean addToPhoneBook(PhoneBook pb) throws IOException, DuplicateNameException, DuplicatePhoneNumberException;
	public boolean updateInPhoneBook(PhoneBook pb) throws IOException;
	public boolean deleteFromPhoneBook(int numberId) throws IOException;
	List<PhoneBook> listAllEntries() throws IOException;
	public PhoneBook findById(int numberId) throws IOException;
	public PhoneBook findByName(String name) throws IOException;
	public PhoneBook findByPhoneNumber(String phoneNumber) throws IOException;
	public PhoneBook findByDob(LocalDate dob) throws IOException;
}
