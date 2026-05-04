/*
Name: Wallace Tyner
Course: SDC330L
Week: 4
File: SQLiteDatabase.java
Purpose:
- Handles SQLite database
- Performs CRUD operations
*/

import java.sql.*;

public class SQLiteDatabase {

    private static final String DB_URL = "jdbc:sqlite:contacts.db";

    // Create table
    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "firstName TEXT," +
                     "lastName TEXT," +
                     "phone TEXT," +
                     "email TEXT," +
                     "type TEXT);";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // CREATE
    public static void addContact(Contact contact) {
        String sql = "INSERT INTO contacts(firstName, lastName, phone, email, type) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contact.getFirstName());
            pstmt.setString(2, contact.getLastName());
            pstmt.setString(3, contact.getPhone());
            pstmt.setString(4, contact.getEmail());
            pstmt.setString(5, contact.getType());

            pstmt.executeUpdate();
            System.out.println("Contact saved to database.");

        } catch (SQLException e) {
            System.out.println("Error adding contact: " + e.getMessage());
        }
    }

    // READ
    public static void viewContacts() {
        String sql = "SELECT * FROM contacts";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("firstName") + " " +
                        rs.getString("lastName") +
                        " | Phone: " + rs.getString("phone") +
                        " | Email: " + rs.getString("email") +
                        " | Type: " + rs.getString("type")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error reading contacts: " + e.getMessage());
        }
    }

    // UPDATE
    public static void updateContact(String firstName, String newPhone) {
        String sql = "UPDATE contacts SET phone = ? WHERE firstName = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newPhone);
            pstmt.setString(2, firstName);

            pstmt.executeUpdate();
            System.out.println("Contact updated.");

        } catch (SQLException e) {
            System.out.println("Error updating contact: " + e.getMessage());
        }
    }

    // DELETE
    public static void deleteContact(String firstName) {
        String sql = "DELETE FROM contacts WHERE firstName = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.executeUpdate();

            System.out.println("Contact deleted.");

        } catch (SQLException e) {
            System.out.println("Error deleting contact: " + e.getMessage());
        }
    }
}