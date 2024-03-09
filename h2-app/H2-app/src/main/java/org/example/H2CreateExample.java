package org.example;

import java.sql.Connection;// Apelam biblioteca java.sql.Connection
import java.sql.SQLException;// Apelam biblioteca java.sql.SQLException
import java.sql.Statement;// Apelam biblioteca java.sql.Statement

// Clasa H2CreateExample
public class H2CreateExample {

	// Creeam un querry in care introducem parametrii care dorim sai avem in tabel
    private static final String createTableSQL = "CREATE TABLE memes (memeId INT PRIMARY KEY, memeName varchar(50), memePopularity INT); " +
    		 "INSERT INTO memes VALUES(1, 'kliuv', 20);"
    		+ "INSERT INTO memes VALUES(2, 'mafon', 50);"
    		+ "INSERT INTO memes VALUES(3, 'gycha', 75);";


    // Metoda care face legatura cu baza de date si unde chemam querry
    public void createTable() {

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
   
}// Finisarea clasei H2CreateExample
