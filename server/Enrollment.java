
public class Enrollment implements EnrollmentInterface {

    private String addedStudent1;
    private String addedStudent2;

    public Enrollment() {
        this.addedStudent1 = "none";
        this.addedStudent2 = "none";
    }

    public void addStudent(String student) {
        if (addedStudent1.equals("none")) {
            System.out.println("adding student 1.");
            addedStudent1 = student;
        } else if (addedStudent2.equals("none")) {
            System.out.println("adding student 2.");
            addedStudent2 = student;
        } else {
            System.out.println("Queue of Enrollment is full. Cannot add more Student.");
        }
    }

    public String viewAllStudentsinQueue() {
        StringBuilder students = new StringBuilder("\nAll Students in Queue: ");
        if (!addedStudent1.equals("none")) {
            students.append(addedStudent1).append(", ");
        }
        if (!addedStudent2.equals("none")) {
            students.append(addedStudent2).append(", ");
        }
        return students.length() > 0 ? students.substring(0, students.length() - 2) : "No Students in Queue.";
    }
}
