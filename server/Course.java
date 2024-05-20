import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Course extends UnicastRemoteObject implements CourseInterface {

    protected Course() throws RemoteException {
        super();
    }

    private String courseId = "rebinding to client";
    private String courseTitle = "rebinding to client";
    private String courseDescription = "rebinding to client";

    @Override
    public void displayCourse() throws RemoteException {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Course Description: " + courseDescription);
    }

    @Override
    public String getId() throws RemoteException {
        return courseId;
    }

    @Override
    public String getTitle() throws RemoteException {
        return courseTitle;
    }

    public String getDescription() throws RemoteException {
        return courseDescription;
    }
    
}
