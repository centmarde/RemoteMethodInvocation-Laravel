import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Look up the remote object by name
            EnrollmentInterface enrollment = (EnrollmentInterface) registry.lookup("EnrollmentBinder");

            // Call remote method to fetch parsed details
            String parsedDetails = enrollment.getParsedDetails();

            // Display fetched parsed details
            System.out.println(parsedDetails);

        } catch (java.rmi.NotBoundException e) {
            System.err.println("The name 'EnrollmentBinder' is not currently bound in the registry.");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
