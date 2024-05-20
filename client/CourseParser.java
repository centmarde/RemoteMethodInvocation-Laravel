import java.sql.Connection;

public class CourseParser extends DataParser {

    public void parseAndInsertCourses(Connection connection, String filePath) {
        String insertQuery = "INSERT INTO courses (course_id, course_title, course_description) VALUES (?, ?, ?)";
        String[] attributes = {"course_id", "course_title", "course_description"};
        insertData(connection, filePath, "Course", insertQuery, attributes);
    }
}
