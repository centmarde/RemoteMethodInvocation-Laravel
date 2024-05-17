import java.sql.Connection;
import java.sql.PreparedStatement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class DataParser extends XMLParser {

  protected void insertData(Connection connection, String filePath, String tagName, String insertQuery, String[] attributes) {
    try {
      Document document = parseXML(filePath);
      if (document == null) return;

      System.out.println("Root element: " + document.getDocumentElement().getNodeName());
      NodeList nList = document.getElementsByTagName(tagName);
      PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

      System.out.println("----------------------------");
      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        System.out.println("\nCurrent Element: " + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          for (int j = 0; j < attributes.length; j++) {
            String value = eElement.getAttribute(attributes[j]);
            preparedStatement.setString(j + 1, value);
          }

          int rowsAffected = preparedStatement.executeUpdate();
          if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
          } else {
            System.out.println("Data insertion failed.");
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
