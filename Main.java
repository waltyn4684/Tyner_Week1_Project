/*
Name: Wallace Tyner
Course: SDC330L
Week: 3
File: Main.java
Purpose:
- Main driver for Contact Manager
- Demonstrates abstraction, constructors, and access specifiers
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice = 0;

        System.out.println("Week 3 Project - Contact Manager");
        System.out.println("Wallace Tyner");

        while (choice != 3) {

            System.out.println("\n1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {

                System.out.print("First Name: ");
                String f = sc.nextLine();

                System.out.print("Last Name: ");
                String l = sc.nextLine();

                System.out.print("Phone: ");
                String p = sc.nextLine();

                System.out.print("Email: ");
                String e = sc.nextLine();

                System.out.print("Type (Business, Family, Friend): ");
                String type = sc.nextLine();

                // Using constructor
                Contact c = new Contact(f, l, p, e, type);
                contacts.add(c);

                System.out.println("Contact added.");

            } else if (choice == 2) {

                if (contacts.isEmpty()) {
                    System.out.println("No contacts available.");
                } else {
                    for (Contact c : contacts) {
                        c.display(); // polymorphism in action
                    }
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}