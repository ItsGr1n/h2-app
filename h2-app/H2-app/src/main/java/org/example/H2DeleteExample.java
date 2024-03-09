package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2DeleteExample {
	static String deleteSql = "DELETE FROM memes WHERE memeId = ?";
	 // Metoda care face legatura cu baza de date si unde chemam querry
   public void deleteMeme(int memeId) {
   	

       // Step 1: Establishing a Connection
       try (Connection connection = H2JDBCUtils.getConnection();
       	PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
           preparedStatement.setInt(1, memeId);
           System.out.println(preparedStatement);
           // Executarea query sau update query
           preparedStatement.executeUpdate();


       } catch (SQLException e) {
           // print SQL exception information
           H2JDBCUtils.printSQLException(e);
       }
   }
}
