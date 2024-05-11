
public class ParentStudent extends GrandParentStudent {
    public ParentStudent() {
        super();
    }

    public ParentStudent(int newStudentId, String newFullname, String newProgram,
            String newCourse) {
        super(newStudentId, newFullname, newCourse, newProgram);
    }

  /*   public void changeStudentName(String newFullname) {
        super.changeStudentName(newFullname);
    } */

    public void viewStudents() {
        System.out.println("Student Id: " + this.student_id);
        System.out.println("Student fullname: " + this.fullname);
        System.out.println("Program: " + this.program);
        System.out.println("Course: " + this.course);
       
    }
}