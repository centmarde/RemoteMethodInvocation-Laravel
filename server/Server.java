import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create instances of your remote objects
            Student student = new Student();
            Course course = new Course();
            ServerNotificationImpl notification = new ServerNotificationImpl();

            // Create RMI registry
            Registry registry = LocateRegistry.createRegistry(9101);

            // Bind remote objects to the registry
            registry.rebind("StudentRMIInterface", student);
            registry.rebind("CourseRMIInterface", course);
            registry.rebind("NotificationInterface", notification);

            System.out.println("Server is ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
