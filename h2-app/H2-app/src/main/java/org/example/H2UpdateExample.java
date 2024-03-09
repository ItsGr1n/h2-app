package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2UpdateExample {
	static String updateSql = "UPDATE memes SET memeName = ?, memePopularity = ? WHERE memeId = ?";
	 // Metoda care face legatura cu baza de date si unde chemam querry
  public void updateMeme(Meme m) {
  	

      // Step 1: Establishing a Connection
      try (Connection connection = H2JDBCUtils.getConnection();
      	PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
          preparedStatement.setString(1, m.memeName);
          preparedStatement.setInt(2,  m.popularity);
          preparedStatement.setInt(3,  m.memeId);
          System.out.println(preparedStatement);
          // Executarea query sau update query
          preparedStatement.executeUpdate();


      } catch (SQLException e) {
          // print SQL exception information
          H2JDBCUtils.printSQLException(e);
      }
  }
}
