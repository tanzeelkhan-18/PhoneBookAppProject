package main.java.com.phonebookapp.service;

import java.io.IOException;

public interface UserServices {
    void add() throws IOException;
    void update() throws IOException;
    void listAllEntries() throws IOException;
    void findById() throws IOException;
    void findByName() throws IOException;
    void findByPhoneNumber() throws IOException;
    void findByDob() throws IOException;
}
