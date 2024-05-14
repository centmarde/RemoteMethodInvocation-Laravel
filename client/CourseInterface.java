import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CourseInterface extends Remote {
    public String getCourseId() throws RemoteException;  
    public String getCourseTitle() throws RemoteException;
    public String getCourseDescription() throws RemoteException;
   
}
