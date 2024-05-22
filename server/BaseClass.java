import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass implements Serializable {

    private static final long serialVersionUID = 1L;

    protected static final String URL = "jdbc:mysql://localhost:3306/rmilaravel";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "";

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load MySQL driver");
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
