import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

           
            EnrollmentInterface enrollment = (EnrollmentInterface) registry.lookup("EnrollmentBinder");

            
            String parsedDetails = enrollment.getParsedDetails();

            
            System.out.println("Fetched parsed details:\n" + parsedDetails);

           
            insertParsedDetailsIntoDatabase(parsedDetails);

        } catch (java.rmi.NotBoundException e) {
            System.err.println("The name 'EnrollmentBinder' is not currently bound in the registry.");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void insertParsedDetailsIntoDatabase(String parsedDetails) {
       
        String url = "jdbc:mysql://localhost:3306/rmilaravel";
        String username = "root";
        String password = "";
    
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection established...");
    
           
            String[] detailsArray = parsedDetails.split("\n");
    
          
            String insertStudentSQL = "INSERT INTO students (student_id, name, age, address, contact_number) VALUES (?, ?, ?, ?, ?)";
            String insertCourseSQL = "INSERT INTO courses (course_id, course_title, course_description) VALUES (?, ?, ?)";
    
            for (String detail : detailsArray) {
                if (detail.startsWith("Parsed student details:")) {
                    
                    String[] studentDetails = detail.replace("Parsed student details: ", "").split(", ");
                    if (studentDetails.length == 5) {
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertStudentSQL)) {
                            preparedStatement.setString(1, studentDetails[0].trim());
                            preparedStatement.setString(2, studentDetails[1].trim());
                            preparedStatement.setInt(3, Integer.parseInt(studentDetails[2].trim()));
                            preparedStatement.setString(4, studentDetails[3].trim());
                            preparedStatement.setString(5, studentDetails[4].trim());
                            int rowsInserted = preparedStatement.executeUpdate();
                            System.out.println("Inserted " + rowsInserted + " row(s) for student: " + studentDetails[0]);
                        }
                    } else {
                        System.err.println("Invalid student details: " + detail);
                    }
                } else if (detail.startsWith("Parsed course details:")) {
                    
                    String[] courseDetails = detail.replace("Parsed course details: ", "").split(", ");
                    if (courseDetails.length == 3) {
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCourseSQL)) {
                            preparedStatement.setString(1, courseDetails[0].trim());
                            preparedStatement.setString(2, courseDetails[1].trim());
                            preparedStatement.setString(3, courseDetails[2].trim());
                            int rowsInserted = preparedStatement.executeUpdate();
                            System.out.println("Inserted " + rowsInserted + " row(s) for course: " + courseDetails[0]);
                        }
                    } else {
                        System.err.println("Invalid course details: " + detail);
                    }
                }
            }
    
            System.out.println("Details successfully inserted into the database.");
    
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}