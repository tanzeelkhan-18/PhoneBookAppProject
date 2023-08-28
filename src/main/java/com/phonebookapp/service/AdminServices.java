package main.java.com.phonebookapp.service;

import main.java.com.phonebookapp.model.PhoneBook;

import java.io.IOException;
import java.util.List;

public interface AdminServices {
    void add() throws IOException;
    void update() throws IOException;
    void delete() throws IOException;
    void listAllEntries() throws IOException;
    void findById() throws IOException;
    void findByName() throws IOException;
    void findByPhoneNumber() throws IOException;
    void findByDob() throws IOException;
}
