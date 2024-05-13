import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    // Lets us define API
    public String getStudentId() throws RemoteException;  
    public String getName() throws RemoteException;
    public String getAge() throws RemoteException;
    public String getAddress() throws RemoteException;  
    public String getContactNumber() throws RemoteException;  
    

}

