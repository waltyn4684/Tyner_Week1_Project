/*
Name: Wallace Tyner
Course: SDC330L
Week: 3
File: Contact.java
Purpose:
- Extends ContactBase
- Demonstrates constructors, access specifiers, and polymorphism
*/

public class Contact extends ContactBase {

    private String type; // private for encapsulation

    // Constructor
    public Contact(String firstName, String lastName, String phone, String email, String type) {
        super(firstName, lastName, phone, email);
        this.type = type;
    }

    // Required abstract method implementation
    @Override
    public String getType() {
        return type;
    }

    // Override display method
    @Override
    public void display() {
        System.out.println("Type: " + type);
        super.display();
        System.out.println("----------------------");
    }
}