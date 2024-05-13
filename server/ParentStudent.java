
public class ParentStudent extends GrandParentStudent {
    public ParentStudent() {
        super();
    }

    public ParentStudent(String newStudentId, String newName, String newAge,String newAddress,
    String newContactNumber) {
        super(newStudentId, newName, newAge, newAddress, newContactNumber);
    }

  /*   public void changeStudentName(String newFullname) {
        super.changeStudentName(newFullname);
    } */

    public void viewStudents() {
        System.out.println("Student Id: " + this.student_id);
        System.out.println("Student name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Address: " + this.address);
        System.out.println("Contact Number: " + this.contact_number);
       
    }
}