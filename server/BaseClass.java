import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/RMI";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    static {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load PostgreSQL driver");
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
