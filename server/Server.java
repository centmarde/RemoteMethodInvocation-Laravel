import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) {
        try {
            
            String url = "jdbc:mysql://localhost:3306/rmilaravel";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established...");
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");
            
            
            Enrollment enrollment = new Enrollment();
            
           
            EnrollmentInterface stub;
            try {
                stub = (EnrollmentInterface) UnicastRemoteObject.exportObject(enrollment, 0);
            } catch (java.rmi.server.ExportException e) {
             
                stub = (EnrollmentInterface) enrollment;
            }

           
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
