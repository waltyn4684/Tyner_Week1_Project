/*
Name: Wallace Tyner
Course: SDC330L
Week: 2
Purpose:
- Demonstrates inheritance
- Demonstrates composition
- Demonstrates polymorphism
- Demonstrates interface usage
*/

import java.util.Scanner;

// Interface (NEW - Week 2 requirement)
interface Displayable {
    void display();
}

// Base class
class Contact implements Displayable {
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

    // Base display (can be overridden)
    public void display() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

// Derived classes (Polymorphism happens here)
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

// Composition class
class ContactManager {
    private Contact[] contacts = new Contact[20];
    private int count = 0;

    public void addContact(Contact c) {
        contacts[count++] = c;
        System.out.println("Contact added.\n");
    }

    // Polymorphism in action
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            contacts[i].display(); // calls different versions
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        System.out.println("Week 2 Project – Contact Manager");
        System.out.println("Wallace Tyner\n");

        boolean run = true;

        while (run) {
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

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

                if (type == 1)
                    manager.addContact(new BusinessContact(f, l, p, e));
                else if (type == 2)
                    manager.addContact(new FamilyContact(f, l, p, e));
                else
                    manager.addContact(new FriendContact(f, l, p, e));

            } else if (choice == 2) {
                manager.displayAll();

            } else if (choice == 3) {
                run = false;
                System.out.println("Exiting...");
            }
        }

        sc.close();
    }
}