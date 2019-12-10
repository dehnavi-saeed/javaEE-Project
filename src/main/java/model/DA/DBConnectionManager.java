package model.DA;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
    private String dbURL;
    private String user;
    private String password;

    public DBConnectionManager(String dbURL, String user, String password) {
        this.dbURL = dbURL;
        this.user = user;
        this.password = password;
    }

    public Connection openConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbURL,user,password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
