import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

public class Enrollment extends UnicastRemoteObject implements EnrollmentInterface {

    public Enrollment() throws RemoteException {
        super();
    }

    @Override
    public void addStudent(String student) throws RemoteException {
        
    }

    @Override
    public String viewAllStudentsinQueue() throws RemoteException {
        
        return null;
    }

    @Override
    public void insertStudent(String student_id, String name, String age, String address, String contact_number) throws RemoteException {
        
    }

    @Override
    public String getParsedDetails() throws RemoteException {
        StringBuilder details = new StringBuilder();
    
        try {
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document studentDocument = builder.parse("C:/laragon/www/RMILaravel/Students.xml");
            studentDocument.getDocumentElement().normalize();
            NodeList studentList = studentDocument.getElementsByTagName("Student");
    
            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    String student_id = studentElement.getAttribute("student_id");
                    String name = studentElement.getAttribute("name");
                    String age = studentElement.getAttribute("age");
                    String address = studentElement.getAttribute("address");
                    String contact_number = studentElement.getAttribute("contact_number");
                    details.append("Parsed student details: ").append(student_id).append(", ").append(name).append(", ").append(age).append(", ").append(address).append(", ").append(contact_number).append("\n");
                }
            }
    
            
            Document courseDocument = builder.parse("C:/laragon/www/RMILaravel/Courses.xml");
            courseDocument.getDocumentElement().normalize();
            NodeList courseList = courseDocument.getElementsByTagName("Course");
    
            for (int i = 0; i < courseList.getLength(); i++) {
                Node courseNode = courseList.item(i);
                if (courseNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element courseElement = (Element) courseNode;
                    String course_id = courseElement.getAttribute("course_id");
                    String title = courseElement.getAttribute("course_title");
                    String description = courseElement.getAttribute("course_description");
                    details.append("Parsed course details: ").append(course_id).append(", ").append(title).append(", ").append(description).append("\n");
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    
        return details.toString();
    }
    
}
