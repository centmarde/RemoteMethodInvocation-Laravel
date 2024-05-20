import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;

public class Client {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rmilaravel";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Registry registry = LocateRegistry.getRegistry("localhost", 9101);
            StudentInterface studentRemoteObject = (StudentInterface) registry.lookup("StudentRMIInterface");
            studentRemoteObject.displayInfo();

            CourseInterface courseRemoteObject = (CourseInterface) registry.lookup("CourseRMIInterface");
            courseRemoteObject.displayCourse();

            System.out.println("Connected to the database.");

            // Parse and insert students
            System.out.println("Parsing and inserting students...");
            StudentParser studentParser = new StudentParser();
            studentParser.parseAndInsertStudents(connection, "C:/laragon/www/RMIlaravel/storage/Students.xml");

            // Parse and insert courses
            System.out.println("Parsing and inserting courses...");
            CourseParser courseParser = new CourseParser();
            courseParser.parseAndInsertCourses(connection, "C:/laragon/www/RMIlaravel/storage/Courses.xml");

            System.out.println("Data insertion completed.");

            connection.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
