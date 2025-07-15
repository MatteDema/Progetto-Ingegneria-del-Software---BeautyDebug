package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {

    public static String url = "jdbc:mysql://localhost:3306/";
    public static String dbName = "dbcentroestetico";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String userName = "root";
    public static String password = "admin"; // ognuno mette la propria password di MySQL


    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        //1. configurare il Driver Manager
        Connection conn = null;
        Class.forName(driver);

        //2. creazione della connessione tramite il Driver Manager
        conn = DriverManager.getConnection(url+dbName, userName, password);

        //3. restituisce la connessione
        return conn;
    }

    public static void closeConnection(Connection c) throws SQLException {

        // chiusura della connessione
        c.close();
    }



    public static ResultSet selectQuery(String query) throws ClassNotFoundException, SQLException {

        // creazione della connessione
        Connection conn = getConnection();

        // creazione dello statement
        Statement statement = conn.createStatement();

        // eseguo la query di select che ho fornito come input
        ResultSet ret = statement.executeQuery(query);

        //ritorna il Result Set (risultato della query di SELECT, ovvero le tuple prelevate dalle tabelle del database)
        return ret;
    }

    public static int updateQuery(String query) throws ClassNotFoundException, SQLException {

        // creazione della connessione
        Connection conn = getConnection();

        // creazione dello statement
        Statement statement = conn.createStatement();

        // eseguo la query di update/insert/delete che ho fornito come input
        int ret = statement.executeUpdate(query);

        // chiudo la connessione
        conn.close();

        return ret;
    }

}
