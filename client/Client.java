import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

           /*  ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
            ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface p3 = (ProductInterface) registry.lookup("charger");
            ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");
            ProductInterface p5 = (ProductInterface) registry.lookup("keyboard"); */
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

          
            EnrollmentInterface Enrollment = (EnrollmentInterface) registry.lookup("Enrollment");

            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                System.out.println("\n1. View Students");
                System.out.println("2. Add Students to Queue");
                System.out.println("3. View All Students in Queue");  
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        
                        System.out.println("\nAvailable Students:");
                        String[] studentNames = registry.list();
                        for (String studentName : studentNames) {
                            if (!studentName.equals("queue")) {
                                StudentInterface student = (StudentInterface) registry.lookup(studentName);
                                System.out.println("Fullname: " + student.getFullname() + ", Course: " + student.getCourse());
                            }
                        }
                        break;

                    case 2:
                        
                        System.out.print("Enter the name of the student to add: ");
                        String studentNameToAdd = scanner.next();
                        StudentInterface studentToAdd = (StudentInterface) registry.lookup(studentNameToAdd);
                        Enrollment.addStudent(studentToAdd.getFullname());
                        System.out.println(studentToAdd.getFullname() + " added to Queue.");
                        break;

                    case 3:
                        
                        System.out.println(Enrollment.viewAllStudentsinQueue());
                        break;

                    case 4:
                        
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 4);

            scanner.close();

        } catch (RemoteException re) {
            System.out.println("RMI communication error: " + re);
        } catch (NotBoundException nbe) {
            System.out.println("Object not bound in RMI Registry: " + nbe);
        } catch (Exception e) {
            System.out.println("Client side error: " + e);
        }
    }
}