
public class GrandParentStudent {
    protected int student_id;
    protected String fullname;
    protected String program;
    protected String course;
   

    public GrandParentStudent() {
        this.student_id = -1; // Default student code
        this.fullname = "N/A";
        this.program = "N/A";
        this.course = "N/A";
    }

    public GrandParentStudent(int newStudentId, String newFullname, String newProgram,
                              String newCourse) {
        this.student_id = newStudentId;
        this.fullname = newFullname;
        this.program = newProgram;
        this.course = newCourse;
      
    }

    public int getStudentId() {
        return this.student_id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getProgram() {
        return this.program;
    }

    public String getCourse() {
        return this.course;
    }

}
