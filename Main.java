/*
Name: Wallace Tyner
Course: SDC330L
Week: 4
File: Main.java
Purpose:
- Runs Contact Manager with database integration
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Initialize database
        SQLiteDatabase.initializeDatabase();

        System.out.println("Week 4 Project - Contact Manager");

        while (running) {

            System.out.println("\n1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();

                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Type (Business/Family/Friend): ");
                    String type = scanner.nextLine();

                    Contact contact = new Contact(fn, ln, phone, email, type);
                    SQLiteDatabase.addContact(contact);
                    break;

                case 2:
                    SQLiteDatabase.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter first name to update: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();

                    SQLiteDatabase.updateContact(updateName, newPhone);
                    break;

                case 4:
                    System.out.print("Enter first name to delete: ");
                    String deleteName = scanner.nextLine();

                    SQLiteDatabase.deleteContact(deleteName);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}