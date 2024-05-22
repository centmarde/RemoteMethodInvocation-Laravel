import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EnrollmentBase extends BaseClass {

    protected String id;
    protected String courseId;
    protected String studentId;

    protected EnrollmentBase() throws RemoteException {
        super();
    }

    public EnrollmentBase(String id, String courseId, String studentId) throws RemoteException {
        super();
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }
}
