import java.rmi.RemoteException;

public interface Student {
    String getId() throws RemoteException;
    String getName() throws RemoteException;
    String getAge() throws RemoteException;
    String getAddress() throws RemoteException;
    String getContactNumber() throws RemoteException;
    void displayInfo() throws RemoteException;
}
