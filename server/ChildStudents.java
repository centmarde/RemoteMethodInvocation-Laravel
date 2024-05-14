import java.rmi.RemoteException;


public class ChildStudents extends ParentStudent implements StudentInterface {
    
    public ChildStudents() throws RemoteException {
        super();
    }

    public ChildStudents(String newStudentId, String newName, String newAge,String newAddress,
    String newContactNumber) throws RemoteException {
        super(newStudentId, newName, newAge, newAddress,newContactNumber);
    }
}
