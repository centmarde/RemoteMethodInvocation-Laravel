import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) {
        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/rmilaravel";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established...");
            
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");
            
            // Create Enrollment object
            Enrollment enrollment = new Enrollment();
            
            // Check if the object is already exported
            EnrollmentInterface stub;
            try {
                stub = (EnrollmentInterface) UnicastRemoteObject.exportObject(enrollment, 0);
            } catch (java.rmi.server.ExportException e) {
                // If the object is already exported, use the existing reference
                stub = (EnrollmentInterface) enrollment;
            }

            // Create RMI registry and bind the remote object
            Registry registry = LocateRegistry.getRegistry(9100);
            registry.rebind("EnrollmentBinder", stub);
            System.out.println("Enrollment object bound to 'EnrollmentBinder' in the registry");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some server error: " + e);
            e.printStackTrace();
        }
    }
}
