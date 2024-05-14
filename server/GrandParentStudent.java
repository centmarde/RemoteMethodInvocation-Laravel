
public class GrandParentStudent {
    protected String student_id;
    protected String name;
    protected String age;
    protected String address;
    protected String contact_number;
   

    public GrandParentStudent() {
        this.student_id = "N/A"; // Default student code
        this.name = "N/A";
        this.age = "N/A";
        this.address = "N/A";
        this.contact_number = "N/A";
    }

    public GrandParentStudent(String newStudentId, String newName, String newAge,String newAddress,
                              String newContactNumber) {
        this.student_id = newStudentId;
        this.name = newName;
        this.age = newAge;
        this.address = newAddress;
        this.address = newAddress;
        this.contact_number = newContactNumber;
      
    }

    public String getStudentId() {
        return this.student_id;
    }

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }
    public String getContactNumber() {
        return this.contact_number;
    }

}
