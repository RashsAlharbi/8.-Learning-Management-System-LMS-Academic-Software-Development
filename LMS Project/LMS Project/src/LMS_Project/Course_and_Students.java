package LMS_Project;

/*
   - Class that contains the course, and the students
 */
public class Course_and_Students {

    private int id_student;
    private int id_course;
    private int number_of_course;

    public Course_and_Students(int id_student, int id_course, int number_of_course) {
        this.id_student = id_student;
        this.id_course = id_course;
        this.number_of_course = number_of_course;
    }

    public void setId_Student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_Student() {
        return this.id_student;
    }

    public void setCourse_code(int id_course) {
        this.id_course = id_course;
    }

    public int getId_course() {
        return this.id_course;
    }

    public void setNumber_of_course(int number_of_course) {
        this.number_of_course = number_of_course;
    }

    public int getNumber_of_course() {
        return this.number_of_course;
    }

    @Override
    public String toString() {
        return "\nId_Student: " + this.id_student;
    }

}
