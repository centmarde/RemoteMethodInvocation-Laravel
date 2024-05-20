import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class DataParser {

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
                        System.out.println(attributes[j] + ": " + value);
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

    protected Document parseXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
