import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentImpl extends UnicastRemoteObject implements Student {
  private String student_id;
  private String name;
  private String age;
  private String address;
  private String contactNumber;

  public StudentImpl(
    String student_id,
    String name,
    String age,
    String address,
    String contactNumber
  ) throws RemoteException {
    super();
    this.student_id = student_id;
    this.name = name;
    this.age = age;
    this.address = address;
    this.contactNumber = contactNumber;
  }

  @Override
  public String getId() throws RemoteException {
    return student_id;
  }

  @Override
  public String getName() throws RemoteException {
    return name;
  }

  @Override
  public String getAge() throws RemoteException {
    return age;
  }

  @Override
  public String getAddress() throws RemoteException {
    return address;
  }

  @Override
  public String getContactNumber() throws RemoteException {
    return contactNumber;
  }

  @Override
  public void displayInfo() throws RemoteException {
    System.out.println(
      "Student ID: " +
      student_id +
      "\nName: " +
      name +
      "\nAge: " +
      age +
      "\nAddress: " +
      address +
      "\nContact Number: " +
      contactNumber +
      "\n"
    );
  }
}
