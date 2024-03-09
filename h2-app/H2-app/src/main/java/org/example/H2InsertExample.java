package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class H2InsertExample {
	static String insertSql = "INSERT INTO memes VALUES (?, ?, ?)";
	 // Metoda care face legatura cu baza de date si unde chemam querry
    public void addMeme(Meme m) {
    	

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setInt(1, m.memeId);
            preparedStatement.setString(2, m.memeName);
            preparedStatement.setInt(3, m.popularity);
           
            System.out.println(preparedStatement);
            // Executarea query sau update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}
