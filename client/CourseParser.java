import java.sql.Connection;
import java.sql.PreparedStatement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CourseParser extends XMLParser {

  @Override
  public void parseAndInsert(Connection connection, String filePath) {
    try {
      Document courseDocument = parseXML(filePath);
      if (courseDocument == null) return;

      System.out.println("Root element: " + courseDocument.getDocumentElement().getNodeName());
      NodeList nList = courseDocument.getElementsByTagName("Course");

      String insertQuery = "INSERT INTO courses (course_id, course_title, course_description) VALUES (?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

      System.out.println("----------------------------");
      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        System.out.println("\nCurrent Element: " + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          String course_id = eElement.getAttribute("course_id");
          String course_title = eElement.getAttribute("course_title");
          String course_description = eElement.getAttribute("course_description");

          if (!course_id.isEmpty() && !course_title.isEmpty() && !course_description.isEmpty()) {
            preparedStatement.setString(1, course_id);
            preparedStatement.setString(2, course_title);
            preparedStatement.setString(3, course_description);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
              System.out.println("Data inserted successfully.");
            } else {
              System.out.println("Data insertion failed.");
            }
          } else {
            System.out.println("Missing data for one of the fields. Skipping this record.");
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
