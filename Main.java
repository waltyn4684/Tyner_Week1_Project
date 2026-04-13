/*
Name: Wallace Tyner
Course: SDC330L
Week: 1
Purpose:
- Demonstrates inheritance (Contact -> types)
- Demonstrates composition (ContactManager has contacts)
*/

import java.util.Scanner;

// Base class (Inheritance)
class Contact {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;

    public Contact(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

// Derived class (Business)
class BusinessContact extends Contact {
    public BusinessContact(String f, String l, String p, String e) {
        super(f, l, p, e);
    }

    @Override
    public void display() {
        System.out.println("Type: Business");
        super.display();
        System.out.println("----------------------");
    }
}

// Derived class (Family)
class FamilyContact extends Contact {
    public FamilyContact(String f, String l, String p, String e) {
        super(f, l, p, e);
    }

    @Override
    public void display() {
        System.out.println("Type: Family");
        super.display();
        System.out.println("----------------------");
    }
}

// Derived class (Friend)
class FriendContact extends Contact {
    public FriendContact(String f, String l, String p, String e) {
        super(f, l, p, e);
    }

    @Override
    public void display() {
        System.out.println("Type: Friend");
        super.display();
        System.out.println("----------------------");
    }
}

// Composition class (manages contacts)
class ContactManager {
    private Contact[] contacts = new Contact[20];
    private int count = 0;

    public void addContact(Contact c) {
        if (count < contacts.length) {
            contacts[count] = c;
            count++;
            System.out.println("Contact added.\n");
        } else {
            System.out.println("Contact list is full.\n");
        }
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("No contacts available.\n");
            return;
        }

        for (int i = 0; i < count; i++) {
            contacts[i].display();
        }
    }

    public void displayByLetter(char letter) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (contacts[i].lastName.toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                contacts[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found for that letter.\n");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        System.out.println("Week 1 Project – Contact Manager");
        System.out.println("Wallace Tyner\n");

        boolean run = true;

        while (run) {
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. View by Letter");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            if (choice == 1) {

                System.out.print("First Name: ");
                String f = sc.nextLine();

                System.out.print("Last Name: ");
                String l = sc.nextLine();

                System.out.print("Phone: ");
                String p = sc.nextLine();

                System.out.print("Email: ");
                String e = sc.nextLine();

                System.out.println("Type (1=Business, 2=Family, 3=Friend): ");
                int type = sc.nextInt();
                sc.nextLine();

                if (type == 1) {
                    manager.addContact(new BusinessContact(f, l, p, e));
                } else if (type == 2) {
                    manager.addContact(new FamilyContact(f, l, p, e));
                } else {
                    manager.addContact(new FriendContact(f, l, p, e));
                }

            } else if (choice == 2) {
                manager.displayAll();

            } else if (choice == 3) {
                System.out.print("Enter starting letter: ");
                char letter = sc.nextLine().charAt(0);
                manager.displayByLetter(letter);

            } else if (choice == 4) {
                run = false;
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid option.\n");
            }
        }

        sc.close();
    }
}