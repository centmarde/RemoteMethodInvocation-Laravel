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

      // Parse and insert students
      StudentParser studentParser = new StudentParser();
      studentParser.parseAndInsertStudents(connection, "C:/laragon/www/RMILaravel/Students.xml");

      // Parse and insert courses
      CourseParser courseParser = new CourseParser();
      courseParser.parseAndInsertCourses(connection, "C:/laragon/www/RMILaravel/Courses.xml");

      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
