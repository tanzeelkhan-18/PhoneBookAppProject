package main.java.com.phonebookapp.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import main.java.com.phonebookapp.exceptions.DuplicateNameException;
import main.java.com.phonebookapp.exceptions.DuplicatePhoneNumberException;
import main.java.com.phonebookapp.model.PhoneBook;

public class PhoneBookDaoImpl implements PhoneBookDao {

	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.findAndRegisterModules().writer(new DefaultPrettyPrinter());

	@Override
	public boolean addToPhoneBook(PhoneBook pb) throws IOException, DuplicateNameException, DuplicatePhoneNumberException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		for (PhoneBook entry: phoneBook) {
			if (entry.getName().equals(pb.getName())){
				throw new DuplicateNameException("Duplicate Name found.");
			}
			if (entry.getPhoneNumber().equals(pb.getPhoneNumber())){
				throw new DuplicatePhoneNumberException("Duplicate Number found");
			}
		}
		phoneBook.add(pb);
		writer.writeValue(Paths.get("data/phonebook.json").toFile(), phoneBook);
		return true;
	}

	@Override
	public boolean updateInPhoneBook(PhoneBook pb) throws IOException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		for (PhoneBook entry: phoneBook) {
			if (entry.getNumberId()==pb.getNumberId()){
					phoneBook.set(phoneBook.indexOf(entry), pb);
					writer.writeValue(Paths.get("data/phonebook.json").toFile(), phoneBook);
					return true;
				}
			}
		return false;
	}

	@Override
	public boolean deleteFromPhoneBook(int numberId) throws IOException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		for (PhoneBook entry: phoneBook) {
			if (entry.getNumberId()==numberId){
				phoneBook.remove(phoneBook.indexOf(entry));
				writer.writeValue(Paths.get("data/phonebook.json").toFile(), phoneBook);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<PhoneBook> listAllEntries() throws IOException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		return phoneBook;
	}

	@Override
	public PhoneBook findById(int numberId) throws IOException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		for (PhoneBook entry: phoneBook) {
			if (entry.getNumberId()==numberId){
				return entry;
			}
		}
		return null;
	}

	@Override
	public PhoneBook findByName(String name) throws IOException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		for (PhoneBook entry: phoneBook) {
			if (name.equals(entry.getName())){
				return entry;
			}
		}
		return null;
	}

	@Override
	public PhoneBook findByPhoneNumber(String phoneNumber) throws IOException {
		List<PhoneBook> phoneBook = new LinkedList<PhoneBook>(Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class)));
		for (PhoneBook entry: phoneBook) {
			if (phoneNumber.equals(entry.getPhoneNumber())){
				return entry;
			}
		}
		return null;
	}

	@Override
	public PhoneBook findByDob(LocalDate dob) throws IOException {
		List<PhoneBook> phoneBook = Arrays.asList(mapper.readValue(new File("data/phonebook.json"), PhoneBook[].class));
		for (PhoneBook entry: phoneBook) {
			if (dob.equals(entry.getDob())){
				return entry;
			}
		}
		return null;
	}
}
