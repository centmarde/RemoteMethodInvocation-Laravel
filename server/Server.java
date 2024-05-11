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
                    String student_id =studentElement.getAttribute("student_id");
                    String fullname = studentElement.getAttribute("fullname");
                    String program = studentElement.getAttribute("program");
                    String course = studentElement.getAttribute("course");
                 

                    // Insert student details into the database
                    String insertQuery = "INSERT INTO students (student_id, fullname, program, course) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, student_id);
                    preparedStatement.setString(2, fullname);
                    preparedStatement.setString(3, program);
                    preparedStatement.setString(4, course);
                 

                    System.out.println("Inserted rows into the students table");

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Inserted Students: " + fullname);
                    } else {
                        System.out.println("Failed to insert Students: " + fullname);
                    }

                    preparedStatement.close();
                }
            }

            // Exporting and binding of Objects has been completed
            Enrollment serve = new Enrollment();
            EnrollmentInterface Enrollment = (EnrollmentInterface) UnicastRemoteObject.exportObject(serve, 0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("Enrollment", Enrollment);

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
