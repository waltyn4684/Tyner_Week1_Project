/*
Name: Wallace Tyner
Course: SDC330L
Week: 4
File: Contact.java
Purpose:
- Extends ContactBase
- Demonstrates constructors, access specifiers, polymorphism
*/

public class Contact extends ContactBase {

    private String type;

    // Constructor
    public Contact(String firstName, String lastName, String phone, String email, String type) {
        super(firstName, lastName, phone, email);
        this.type = type;
    }

    // Getters (needed for database)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getType() { return type; }

    // Polymorphism
    @Override
    public void display() {
        System.out.println(firstName + " " + lastName +
                " | Phone: " + phone +
                " | Email: " + email +
                " | Type: " + type);
    }
}