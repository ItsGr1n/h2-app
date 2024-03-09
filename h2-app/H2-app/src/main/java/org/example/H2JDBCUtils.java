package org.example;

import java.sql.Connection;// Apelam biblioteca java.sql.Connection
import java.sql.DriverManager;// Apelam biblioteca java.sql.DriverManager
import java.sql.SQLException;// Apelam biblioteca java.sql.SQLException

// Clasa H2JDBCUtils
public class H2JDBCUtils {

	// Predifinim urmaoarele parametrii ai bazei de date
    private static String jdbcURL = "jdbc:h2:~/test2";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    // Metoda care face conectiunea
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    // Cream metoda care are grija ca codul sa primeasca eruari
    public static void printSQLException(SQLException ex) {
    	// Ciclul for care va trece prin toate 
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
