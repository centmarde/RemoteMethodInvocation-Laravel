import java.sql.Connection;
import java.sql.PreparedStatement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StudentParser extends XMLParser {

  @Override
  public void parseAndInsert(Connection connection, String filePath) {
    try {
      Document studentDocument = parseXML(filePath);
      if (studentDocument == null) return;

      System.out.println("Root element: " + studentDocument.getDocumentElement().getNodeName());
      NodeList nList = studentDocument.getElementsByTagName("Student");

      String insertQuery = "INSERT INTO students (student_id, name, age, address, contact_number) VALUES (?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

      System.out.println("----------------------------");
      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        System.out.println("\nCurrent Element: " + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          String student_id = eElement.getAttribute("student_id");
          String name = eElement.getAttribute("name");
          String age = eElement.getAttribute("age");
          String contactNumber = eElement.getAttribute("contact_number");
          String address = eElement.getAttribute("address");

          if (!student_id.isEmpty() && !name.isEmpty() && !age.isEmpty() && !contactNumber.isEmpty() && !address.isEmpty()) {
            preparedStatement.setString(1, student_id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, contactNumber);
            preparedStatement.setString(5, address);

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
