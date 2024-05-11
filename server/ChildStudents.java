import java.rmi.RemoteException;


public class ChildStudents extends ParentStudent implements StudentInterface {
    
    public ChildStudents() throws RemoteException {
        super();
    }

    public ChildStudents(int newStudentId, String newFullname, String newProgram,
                       String newCourse) throws RemoteException {
        super(newStudentId, newFullname, newProgram, newCourse);
    }
}
