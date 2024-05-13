import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.sql.*;
import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/rmilaravel";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established...");
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:/laragon/www/RMILaravel/Students.xml");
            document.getDocumentElement().normalize();
            NodeList studentList = document.getElementsByTagName("Student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                // Parse student details from XML
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    String student_id = studentElement.getAttribute("student_id");
                    String name = studentElement.getAttribute("name");
                    String age = studentElement.getAttribute("age");
                    String address = studentElement.getAttribute("address");
                    String contact_number = studentElement.getAttribute("contact_number");
                    System.out.println("Parsed student details: " + student_id + ", " + name + ", " + age + ", " + address + ", " + contact_number);
                }
            }
            // Exporting and binding of Objects has been completed
            Enrollment serve = new Enrollment();
            EnrollmentInterface enrollment = (EnrollmentInterface) UnicastRemoteObject.exportObject(serve, 0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("EnrollmentBinder", enrollment);
            System.out.println("Exporting and binding of Objects has been completed...");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }
    }
}