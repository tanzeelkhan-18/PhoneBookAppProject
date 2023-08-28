package main.java.com.phonebookapp.controller;

import main.java.com.phonebookapp.model.Users;
import main.java.com.phonebookapp.service.*;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationController {
    public static void main(String[] args) throws IOException {
        System.out.println("\n-----------------------------------\n");
        System.out.println("--------Java 8 Exam------------\n");
        System.out.println("----------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter LoginName: ");
        String loginName = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        Authenticator authenticatorService = new Authenticator();
        Users user = authenticatorService.authenticate(loginName,password);
        if(user!=null){
            if(user.getStatus().equals("active") && user.getRole().equals("admin")){
                AdminServicesImpl adminServices = new AdminServicesImpl();
                adminServices.driverCode();
            }
            if(user.getStatus().equals("active") && user.getRole().equals("user")){
                UserServicesImpl userServices = new UserServicesImpl();
                userServices.driverCode();
            }
            else {
                System.out.println("User is Deactivated");
            }
        }
        else {
            System.out.println("Please enter Correct Username and Password");
            main(args);
        }
    }
}
