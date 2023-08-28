package main.java.com.phonebookapp.service;

import main.java.com.phonebookapp.dao.PhoneBookDao;
import main.java.com.phonebookapp.dao.PhoneBookDaoImpl;
import main.java.com.phonebookapp.exceptions.DuplicateNameException;
import main.java.com.phonebookapp.exceptions.DuplicatePhoneNumberException;
import main.java.com.phonebookapp.model.PhoneBook;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminServicesImpl implements AdminServices{

    PhoneBookDao pd = new PhoneBookDaoImpl();
    Scanner scObj = new Scanner(System.in);

    @Override
    public void add() throws IOException {
        System.out.println("Add to PhoneBook");
        System.out.print("Enter NumberId: ");
        int numberId = scObj.nextInt();
        scObj.nextLine();
        System.out.print("Enter Name: ");
        String name = scObj.nextLine();
        System.out.print("Enter PhoneNumber: ");
        String phoneNumber = scObj.nextLine();
        System.out.print("Enter DOB(YYYY-MM-DD): ");
        String DOB = scObj.nextLine();
        LocalDate dob = LocalDate.parse(DOB);

        PhoneBook pb = new PhoneBook(numberId,name,phoneNumber,dob);
        try {
            pd.addToPhoneBook(pb);
        } catch (DuplicateNameException | DuplicatePhoneNumberException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() throws IOException {
        System.out.println("Update in PhoneBook");
        System.out.print("Enter NumberId to Update: ");
        int numberId = scObj.nextInt();
        scObj.nextLine();
        System.out.print("Enter Name: ");
        String name = scObj.nextLine();
        System.out.print("Enter PhoneNumber: ");
        String phoneNumber = scObj.nextLine();
        System.out.print("Enter DOB(YYYY-MM-DD): ");
        String DOB = scObj.nextLine();
        LocalDate dob = LocalDate.parse(DOB);

        PhoneBook pb = new PhoneBook(numberId,name,phoneNumber,dob);
        pd.updateInPhoneBook(pb);
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Delete in PhoneBook");
        System.out.print("Enter NumberId to Delete: ");
        int numberId = scObj.nextInt();
        pd.deleteFromPhoneBook(numberId);
    }

    @Override
    public void listAllEntries() throws IOException {
        List<PhoneBook> phoneBook = pd.listAllEntries();
        for (PhoneBook entry: phoneBook) {
            System.out.println(entry);
        }
    }

    @Override
    public void findById() throws IOException {
        System.out.print("Enter numberId: ");
        int id = scObj.nextInt();
        PhoneBook obj = pd.findById(id);
        System.out.println(obj);
    }

    @Override
    public void findByName() throws IOException {
        System.out.print("Enter Name: ");
        String name = scObj.nextLine();
        PhoneBook obj = pd.findByName(name);
        System.out.println(obj);
    }

    @Override
    public void findByPhoneNumber() throws IOException {
        System.out.print("Enter PhoneNumber: ");
        String phoneNumber = scObj.nextLine();
        PhoneBook obj = pd.findByName(phoneNumber);
        System.out.println(obj);
    }

    @Override
    public void findByDob() throws IOException {
        System.out.print("Enter DOB(YYYY-MM-DD): ");
        String DOB = scObj.nextLine();
        LocalDate dob = LocalDate.parse(DOB);
        PhoneBook obj = pd.findByDob(dob);
        System.out.println(obj);
    }

    public void driverCode() throws IOException {
        boolean flag = true;
        while(flag){
            System.out.println("----------Admin Phonebook-----------");
            System.out.println("Enter 1 to view Phonebook");
            System.out.println("Enter 2 to Add to Phonebook");
            System.out.println("Enter 3 to Edit in Phonebook");
            System.out.println("Enter 4 to Delete in Phonebook");
            System.out.println("Enter 5 to Find entry by Id");
            System.out.println("Enter 6 to Find entry by Name");
            System.out.println("Enter 7 to Find entry by Number");
            System.out.println("Enter 8 to Find entry by DOB");
            System.out.println("Enter 0 to Exit.");
            System.out.print("Enter your Choice: ");
            int choice = scObj.nextInt();
            scObj.nextLine();
            switch(choice) {
                case 1:
                    this.listAllEntries();
                    break;
                case 2:
                    this.add();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    this.findById();
                    break;
                case 6:
                    this.findByName();
                    break;
                case 7:
                    this.findByPhoneNumber();
                    break;
                case 8:
                    this.findByDob();
                    break;
                case 0:
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter a Valid Choice.");
            }
        }
    }

}
