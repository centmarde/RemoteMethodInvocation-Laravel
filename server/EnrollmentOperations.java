import java.rmi.RemoteException;

public class EnrollmentOperations extends EnrollmentBase {

    protected EnrollmentOperations() throws RemoteException {
        super();
    }

    public EnrollmentOperations(String id, String courseId, String studentId) throws RemoteException {
        super(id, courseId, studentId);
    }

    public String getId() throws RemoteException {
        return id;
    }

    public String getCourseId() throws RemoteException {
        return courseId;
    }

    public String getStudentId() throws RemoteException {
        return studentId;
    }
}
