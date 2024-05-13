import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

           
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

          
            EnrollmentInterface Enrollment = (EnrollmentInterface) registry.lookup("EnrollmentBinder");

        
           

        } catch (RemoteException re) {
            System.out.println("RMI communication error: " + re);
        } catch (NotBoundException nbe) {
            System.out.println("Object not bound in RMI Registry: " + nbe);
        } catch (Exception e) {
            System.out.println("Client side error: " + e);
        }
    }
}