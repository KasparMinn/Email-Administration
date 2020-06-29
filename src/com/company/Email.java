package com.company;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private String companySuffix = "minn.com";

    private int defaultPasswordLength = 10;
    private int mailboxCapacity;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAlternateEmail() { return alternateEmail; }
    public void setAlternateEmail(String alternateEmail) { this.alternateEmail = alternateEmail; }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public void setMailboxCapacity(int mailboxCapacity) { this.mailboxCapacity = mailboxCapacity; }

    // Constructor to receive the name.
    public Email(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println( "EMAIL CREATED: " + this.firstName + " " + this.lastName + "." );

        // Call a method that asks for the department - return the department.

        this.department = setDepartment();
        // System.out.println( "DEPARTMENT: " + this.department);

        // Call a method that returns a random PW.
        this.password = randomPassword(defaultPasswordLength);
        // System.out.println("Password: [ " + this.password + " ]");

        // Combine elements to generate email.
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        // System.out.println("Your email is: " + email);

    }

    // Ask for the department.
    public String getDepartment() { return department; }
    public String setDepartment() {

        System.out.println("Enter the department: \n 1. for Sales \n 2. for Development \n 3. for Accounting \n 0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        switch (depChoice) {

            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "accounting";
            case 0:
                return "";

        }

        this.department = department;
        return department;
    }

    // Generate a random password.
    private String randomPassword(int length) {

        String passwordSet = "abcdefghijklmnopqrstvwxyzABCDEFGHIJKLMOPQRSTUWZXYZ1234567890";
        this.defaultPasswordLength = 10;
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {

            int rando = (int) ((Math.random()) * passwordSet.length());
            password[i] = passwordSet.charAt(rando);

        }

        return new String (password);

    }

    // Change the password.
    public void changePassword(String password) { this.password = password; }

    public String showInfo() {

        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
               "COMPANY NAME: " + email + "\n" +
               "MAILBOX CAPACITY: " + mailboxCapacity;

    }
}
