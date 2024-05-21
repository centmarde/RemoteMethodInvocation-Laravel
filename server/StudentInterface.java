import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    void displayInfo() throws RemoteException;
    String addStudent(String studentId, String name, int age, String address, String contactNumber) throws RemoteException;
}
