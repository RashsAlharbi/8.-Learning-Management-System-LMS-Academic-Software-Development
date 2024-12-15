/*
  - Java Comparable interface is used to order the objects of the user-defined class.
  - This interface is found in java.lang package and contains only one method named compareTo(Object).
  - It provides a single sorting sequence only, i.e., you can sort the elements on the basis of single data member only.
  - For example, it may be rollno, name, age or anything else. 
  - public int compareTo(Object obj): It is used to compare the current object with the specified object.
    It returns :
                1- positive integer, if the current object is greater than the specified object.
                2- negative integer, if the current object is less than the specified object.
                3- zero, if the current object is equal to the specified object.
*/
package LMS_Project;

public class Students implements Comparable<Students> {

    private String first_name;
    private String last_name;
    private int id_student;
    private double GPA;

    public Students(String first_name, String last_name, int id_student, double GPA) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_student = id_student;
        this.GPA = GPA;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_student() {
        return this.id_student;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public int compareTo(Students student) {
        return this.id_student - student.id_student;
    }

    @Override
    public String toString() {
        return "name: " + this.first_name + " " + this.last_name
                + "\n    ID: " + this.id_student + "\n    GPA: " + this.GPA ;
    }

}
