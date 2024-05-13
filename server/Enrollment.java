import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Enrollment implements EnrollmentInterface {
    private String addedStudent1;
    private String addedStudent2;

    public Enrollment() {
        this.addedStudent1 = "none";
        this.addedStudent2 = "none";
    }

    public void addStudent(String student) {
        if (addedStudent1.equals("none")) {
            System.out.println("Adding student 1.");
            addedStudent1 = student;
        } else if (addedStudent2.equals("none")) {
            System.out.println("Adding student 2.");
            addedStudent2 = student;
        } else {
            System.out.println("Queue of Enrollment is full. Cannot add more students.");
        }
    }

    public void insertStudent(String student_id, String name, String age, String address,String contact_number) {
        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/rmilaravel";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Insert student details into the database
            String insertQuery = "INSERT INTO students (student_id, age, address, contact_number) VALUES (?, ?, ?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, student_id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, contact_number);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student inserted successfully: " + name);
            } else {
                System.out.println("Failed to insert student: " + name);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inserting student: " + e);
        }
    }

    public String viewAllStudentsinQueue() {
        StringBuilder students = new StringBuilder("\nAll Students in Queue: ");
        if (!addedStudent1.equals("none")) {
            students.append(addedStudent1).append(", ");
        }
        if (!addedStudent2.equals("none")) {
            students.append(addedStudent2).append(", ");
        }
        return students.length() > 0 ? students.substring(0, students.length() - 2) : "No Students in Queue.";
    }
}