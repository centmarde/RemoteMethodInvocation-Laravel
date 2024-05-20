import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/rmilaravel";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public RMIServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            RMIServer server = new RMIServer();
            RMIInterface stub = (RMIInterface) server;

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RMIInterface", stub);

            System.out.println("Server is ready...");
            System.out.println("Binding Info from Database... ");
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentInfo(String studentId) throws RemoteException {
        StudentImpl student = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            // Prepare SQL query
            String query = "SELECT * FROM students WHERE student_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, studentId);
            
            // Execute query
            resultSet = statement.executeQuery();

            // Process result set
            if (resultSet.next()) {
                // Retrieve student details
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String address = resultSet.getString("address");
                String contactNumber = resultSet.getString("contact_number");

                // Create StudentImpl object
                student = new StudentImpl(studentId, name, age, address, contactNumber);
             
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching student information", e);
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return student;
    }

    @Override
    public void displayInfo() throws RemoteException {
        System.out.println("Displaying server info...");
    }
}
