import java.sql.Connection;

public class StudentParser extends DataParser {

    public void parseAndInsertStudents(Connection connection, String filePath) {
        String insertQuery = "INSERT INTO students (student_id, name, age, address, contact_number) VALUES (?, ?, ?, ?, ?)";
        String[] attributes = {"student_id", "name", "age", "address", "contact_number"};
        insertData(connection, filePath, "Student", insertQuery, attributes);
    }
}
