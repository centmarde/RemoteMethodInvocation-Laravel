

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentImpl extends UnicastRemoteObject {
  private String id;
  private String programId;
  private String name;
  private String age;
  private String address;
  private String contactNumber;

  public StudentImpl(
    String id,
    String programId,
    String name,
    String age,
    String address,
    String contactNumber
  )
    throws RemoteException {
    this.id = id;
    this.programId = programId;
    this.name = name;
    this.age = age;
    this.address = address;
    this.contactNumber = contactNumber;
  }

  public String getId() throws RemoteException {
    return id;
  }

  public String getProgramId() throws RemoteException {
    return programId;
  }

  public String getName() throws RemoteException {
    return name;
  }

  public String getAge() throws RemoteException {
    return age;
  }

  public String getAddress() throws RemoteException {
    return address;
  }

  public String getContactNumber() throws RemoteException {
    return contactNumber;
  }

  public void displayInfo() {
    System.out.println(
      "Student ID: " +
      id +
      "\nProgram ID: " +
      programId +
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
