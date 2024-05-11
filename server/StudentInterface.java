import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    // Lets us define API
    public int getStudentId() throws RemoteException;  
    public String getFullname() throws RemoteException;
    public String getProgram() throws RemoteException;
    public String getCourse() throws RemoteException;  
    

}

