/*
Name: Wallace Tyner
Course: SDC330L
Week: 4
File: ContactBase.java
Purpose:
- Abstract base class for contacts
*/

public abstract class ContactBase {

    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;

    // Constructor
    public ContactBase(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // Abstract method
    public abstract void display();
}