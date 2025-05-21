import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Course extends UnicastRemoteObject implements CourseInterface {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/RMI";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private String courseId;
    private String courseTitle;
    private String courseDescription;
    private static Map<String, Course> courses = new HashMap<>();

    static {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load PostgreSQL driver");
        }
    }

    protected Course() throws RemoteException {
        super();
        this.courseId = "N/A";
        this.courseTitle = "N/A";
        this.courseDescription = "N/A";
    }

    public Course(String courseId, String courseTitle, String courseDescription) throws RemoteException {
        super();
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
    }

    @Override
    public void displayCourse() throws RemoteException {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Course Description: " + courseDescription);
    }

    @Override
    public String getId() throws RemoteException {
        return courseId;
    }

    @Override
    public String getTitle() throws RemoteException {
        return courseTitle;
    }

    @Override
    public String getDescription() throws RemoteException {
        return courseDescription;
    }

    @Override
    public String addCourse(String courseId, String courseTitle, String courseDescription) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertQuery = "INSERT INTO courses (course_id, course_title, course_description) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, courseId);
                preparedStatement.setString(2, courseTitle);
                preparedStatement.setString(3, courseDescription);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Course added: ID=" + courseId + ", Title=" + courseTitle + ", Description=" + courseDescription);
                    return "Course added successfully.";
                } else {
                    System.out.println("Failed to add course: ID=" + courseId + ", Title=" + courseTitle + ", Description=" + courseDescription);
                    return "Failed to add course.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
