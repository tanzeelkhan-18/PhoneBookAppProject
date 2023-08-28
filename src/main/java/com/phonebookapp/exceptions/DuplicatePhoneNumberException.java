package main.java.com.phonebookapp.exceptions;

public class DuplicatePhoneNumberException extends Exception {
    public DuplicatePhoneNumberException(String errorMessage){
        super(errorMessage);
    }
}
