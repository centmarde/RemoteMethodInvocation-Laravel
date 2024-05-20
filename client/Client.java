import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;

public class Client {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/rmilaravel";
        String username = "root";
        String password = "";

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Verify database connection before proceeding
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connected to the database.");

                // Parse and insert students
                StudentParser studentParser = new StudentParser();
                studentParser.parseAndInsertStudents(connection, "C:/laragon/www/RMILaravel/Storage/Students.xml");

                // Parse and insert courses
                CourseParser courseParser = new CourseParser();
                courseParser.parseAndInsertCourses(connection, "C:/laragon/www/RMILaravel/Storage/Courses.xml");

                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
                return; // Exit the program if database connection fails
            }

            // RMI Client setup
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RMIInterface rmiStub = (RMIInterface) registry.lookup("RMIInterface");

            // Fetch and display student information using RMI
            Student student = rmiStub.getStudentInfo("1");
            if (student != null) {
              student.displayInfo();
          } else {
              System.out.println("Client is Running...");
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
