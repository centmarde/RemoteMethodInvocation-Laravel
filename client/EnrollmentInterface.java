import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EnrollmentInterface extends Remote{
    public void addStudent(String student) throws RemoteException;
    public String viewAllStudentsinQueue() throws RemoteException;
}