package com.mysql.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Cricketproject {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "admin";
        String insertQuery = "INSERT INTO cricket (player_id, name, age, role, runs) VALUES (?, ?, ?, ?, ?)";
        
       
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully\n");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database\n");

            Scanner scanner = new Scanner(System.in);

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            System.out.print("Enter the player ID: ");
            int playerId = scanner.nextInt();
            preparedStatement.setInt(1, playerId);

            System.out.print("Enter the player's name: ");
            String name = scanner.next();
            preparedStatement.setString(2, name);

            System.out.print("Enter the player's age: ");
            int age = scanner.nextInt();
            preparedStatement.setInt(3, age);

            System.out.print("Enter the player's role: ");
            String role = scanner.next();
            preparedStatement.setString(4, role);

            System.out.print("Enter the player's runs: ");
            int runs = scanner.nextInt();
            preparedStatement.setInt(5, runs);

            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully");

            // Close resources
            scanner.close();
            preparedStatement.close();
            connection.close();
        
    }
}
