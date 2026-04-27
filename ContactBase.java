/*
Name: Wallace Tyner
Course: SDC330L
Week: 3
File: ContactBase.java
Purpose:
- Abstract base class for contacts
- Demonstrates abstraction and constructors
*/

public abstract class ContactBase {

    // Protected so child classes can access
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

    // Abstract method (must be implemented in child class)
    public abstract String getType();

    // Shared display method
    public void display() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}