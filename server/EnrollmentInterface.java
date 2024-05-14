import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EnrollmentInterface extends Remote{
    public void addStudent(String student) throws RemoteException;
    public String viewAllStudentsinQueue() throws RemoteException;
    public String getParsedDetails() throws RemoteException;
    public void insertStudent(String student_id, String name, String age, String address,String contact_number) throws RemoteException;
}