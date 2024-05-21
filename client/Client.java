import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            StudentInterface studentRemoteObject = (StudentInterface) registry.lookup("StudentService");
            CourseInterface courseRemoteObject = (CourseInterface) registry.lookup("CourseService");
            EnrollmentInterface enrollmentRemoteObject = (EnrollmentInterface) registry.lookup("EnrollmentService");

            System.out.println("Connected to the RMI server.");
            addStudentsFromXML(studentRemoteObject);
            addCourseFromXML(courseRemoteObject);
            registerStudentsForCoursesFromXML(enrollmentRemoteObject);
            try (Scanner scanner = new Scanner(System.in)) {
                boolean exit = false;

                while (!exit) {
                    System.out.println("Enter 1 to add a course, 2 to add a student, 3 to register a student for a course, or 0 to exit:");
                    int choice = getIntInput(scanner);
                    switch (choice) {
                        case 1:
                            addCourse(courseRemoteObject, scanner);
                            break;
                        case 2:
                            addStudent(studentRemoteObject, scanner);
                            break;
                        case 3:
                            registerStudentForCourse(enrollmentRemoteObject, scanner);
                            break;
                        case 0:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }

            System.out.println("Client exiting.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear input buffer
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    private static void addCourse(CourseInterface remoteObject, Scanner scanner) {
        try {
            System.out.println("Enter course ID:");
            String courseId = scanner.next();
            System.out.println("Enter course title:");
            String courseTitle = scanner.next();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter course description:");
            String courseDescription = scanner.nextLine();
            String response = remoteObject.addCourse(courseId, courseTitle, courseDescription);
            System.out.println(response);
        } catch (Exception e) {
            System.err.println("Error adding course: " + e.getMessage());
        }
    }

    private static void addStudent(StudentInterface remoteObject, Scanner scanner) {
        try {
            System.out.println("Enter student ID:");
            String studentId = scanner.next();
            System.out.println("Enter student name:");
            String name = scanner.next();
            System.out.println("Enter student age:");
            int age = getIntInput(scanner);
            scanner.nextLine(); // Consume newline
            System.out.println("Enter student address:");
            String address = scanner.nextLine();
            System.out.println("Enter student contact number:");
            String contactNumber = scanner.nextLine();
            String response = remoteObject.addStudent(studentId, name, age, address, contactNumber);
            System.out.println(response);
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }
    
    private static void registerStudentForCourse(EnrollmentInterface remoteObject, Scanner scanner) {
        try {
            System.out.println("Enter enrollment ID:");
            String enrollmentId = scanner.next();
            System.out.println("Enter course ID:");
            String courseId = scanner.next();
            System.out.println("Enter student ID:");
            String studentId = scanner.next();
            String response = remoteObject.addEnrollment(enrollmentId, courseId, studentId);
            System.out.println(response);
        } catch (Exception e) {
            System.err.println("Error registering student for course: " + e.getMessage());
        }
    }

    private static void addStudentsFromXML(StudentInterface remoteObject) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:/laragon/www/RMIlaravel/storage/Students.xml");

            NodeList studentList = document.getElementsByTagName("Student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Element studentElement = (Element) studentList.item(i);
                String studentId = studentElement.getAttribute("student_id");
                String name = studentElement.getAttribute("name");
                int age = Integer.parseInt(studentElement.getAttribute("age"));
                String address = studentElement.getAttribute("address");
                String contactNumber = studentElement.getAttribute("contact_number");
                String response = remoteObject.addStudent(studentId, name, age, address, contactNumber);
                System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

   private static void registerStudentsForCoursesFromXML(EnrollmentInterface remoteObject) {
    try {
        // Load the XML file
        File file = new File("C:/laragon/www/RMIlaravel/storage/Enrollment.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        // Get the root element
        Element root = document.getDocumentElement();

        // Get all enrollment elements
        NodeList enrollmentList = root.getElementsByTagName("Enrollment");
        for (int i = 0; i < enrollmentList.getLength(); i++) {
            Element enrollmentElement = (Element) enrollmentList.item(i);
            String enrollmentId = enrollmentElement.getAttribute("Id");
            String courseId = enrollmentElement.getAttribute("course_id");
            String studentId = enrollmentElement.getAttribute("student_id");

            // Call the remote object to add enrollment
            String response = remoteObject.addEnrollment(enrollmentId, courseId, studentId);
            System.out.println(response);
        }
    } catch (Exception e) {
        System.err.println("Error registering students for courses from XML: " + e.getMessage());
    }
}
    private static void addCourseFromXML(CourseInterface remoteObject) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:/laragon/www/RMIlaravel/storage/Courses.xml");
    
            NodeList courseList = document.getElementsByTagName("Course");
            for (int i = 0; i < courseList.getLength(); i++) {
                Element courseElement = (Element) courseList.item(i);
                String courseId = courseElement.getAttribute("course_id");
                String courseTitle = courseElement.getAttribute("title");
                String courseDescription = courseElement.getAttribute("description");
                String response = remoteObject.addCourse(courseId, courseTitle, courseDescription);
                System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("Error adding course: " + e.getMessage());
        }
    }
}
