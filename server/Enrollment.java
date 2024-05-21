import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Enrollment extends UnicastRemoteObject implements EnrollmentInterface {

    private static final String URL = "jdbc:mysql://localhost:3306/rmilaravel";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private String id;
    private String courseId;
    private String studentId;
    private static Map<String, Enrollment> enrollments = new HashMap<>();

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load MySQL driver");
        }
    }

    protected Enrollment() throws RemoteException {
        super();
    }

    public Enrollment(String id, String courseId, String studentId) throws RemoteException {
        super();
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public void displayEnrollment() throws RemoteException {
        System.out.println("Enrollment ID: " + id);
        System.out.println("Course ID: " + courseId);
        System.out.println("Student ID: " + studentId);
    }

    @Override
    public String getId() throws RemoteException {
        return id;
    }

    @Override
    public String getCourseId() throws RemoteException {
        return courseId;
    }

    @Override
    public String getStudentId() throws RemoteException {
        return studentId;
    }

    @Override
    public synchronized String addEnrollment(String id, String courseId, String studentId) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertQuery = "INSERT INTO enrollment (id, course_id, student_id) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, courseId);
                preparedStatement.setString(3, studentId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Enrollment added: ID=" + id + ", CourseID=" + courseId + ", StudentID=" + studentId);
                    return "Enrollment added successfully.";
                } else {
                    System.out.println("Failed to add enrollment: ID=" + id + ", CourseID=" + courseId + ", StudentID=" + studentId);
                    return "Failed to add enrollment.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
