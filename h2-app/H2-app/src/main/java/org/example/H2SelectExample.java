/*
Clasa H2Selecteexample permite afisarea inregistrarilor din tabel
*/
package org.example;

import java.sql.Connection;// Apelam biblioteca java.sql.Connection
import java.sql.PreparedStatement;// Apelam biblioteca java.sql.PreparedStatement
import java.sql.ResultSet;// Apelam biblioteca java.sql.ResultSet
import java.sql.SQLException;// Apelam biblioteca java.sql.SQLException
import java.util.ArrayList;

// Clasa H2Selecteexample
public class H2SelectExample {
	// Cream un querry cu care sa se permita afisarea inregistrarilor din tabelul users
    private static final String QUERY = "SELECT * FROM memes ORDER BY memePopularity DESC";

    public ArrayList<Meme> getMemes()
    { 
    	ArrayList<Meme> ret = new ArrayList<Meme>();
        // Stabilirea  conexiunii
        try (Connection connection = H2JDBCUtils.getConnection();

            // Creati o declaratie folosind obiectul de conexiune
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            System.out.println(preparedStatement);
            // Executati interogarea sau actualizati interogarea
            ResultSet rs = preparedStatement.executeQuery();

            // Procesati ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("memeId");
                String name = rs.getString("memeName");
                int pop = rs.getInt("memePopularity");
                ret.add(new Meme(id, name, pop));
            }
        } catch (SQLException e) {
        	 // afisarea SQL exception innformare
            H2JDBCUtils.printSQLException(e);
        }
        return ret;
    }
}// Finisarea clasei H2Selecteexample
