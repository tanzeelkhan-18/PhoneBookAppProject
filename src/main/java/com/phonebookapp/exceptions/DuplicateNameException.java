package main.java.com.phonebookapp.exceptions;

public class DuplicateNameException extends Exception {
    public DuplicateNameException(String errorMessage){
        super(errorMessage);
    }
}
