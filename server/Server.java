import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            Course course = new Course();

            Registry registry = LocateRegistry.createRegistry(9101);
            registry.rebind("StudentRMIInterface", student);
            registry.rebind("CourseRMIInterface", course);

            System.out.println("Server is ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
