package LMS_Project;

import java.util.ArrayList;

public class Processes_to_Course_and_Students {

    //ArrayList use to store Id_student and Id_course
    ArrayList<Course_and_Students> List = new ArrayList<>();

    //Check the student who is not registered for the course twice
    public boolean Checking_repeat_registration_for_course(int id_course, int id_Student) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_Student() == id_Student) {
                if (List.get(i).getId_course() == id_course) {
                    return false;
                }
            }
        }
        return true;
    }

    //return number of courses for each student
    public int return_number_of_courses(int id_Student) {
        int numberOfCourse = 0;
        for (int i = 0; i < List.size(); i++) {

            if (List.get(i).getId_Student() == id_Student) {
                ++numberOfCourse;
            }
        }
        return numberOfCourse;
    }

    //Add a course to a student 
    public void Add_course_to_student() {
        System.out.println("Enter your id student: ");
        int id_Student = LMS.input.nextInt();
        System.out.println("Enter your id course: ");
        int id_course = LMS.input.nextInt();
        if (LMS.file_studnet.cheak_Existing(id_Student)
                && LMS.file_courses.cheak_Existing(id_course)
                && return_number_of_courses(id_Student) < 3
                && LMS.Processes_to_Appintments_Schedule.have_room_and_staff(id_course)
                && LMS.file_courses.get_capacity_course(id_course) >= 1
                && Checking_repeat_registration_for_course(id_course, id_Student)) {

            List.add(new Course_and_Students(id_Student, id_course,
                    return_number_of_courses(id_Student)
            ));
            LMS.file_courses.change_capacity_coruse(id_course, LMS.file_courses.get_capacity_course(id_course));
            System.out.println("Executed successfully...");
        } else {
            System.out.println("Execution failed...");
        }
    }

    //Delete Student from a course: Make sure that students must take as minimum 2 courses.
    public void delete_student_from_course() {
        System.out.println("Enter your id student: ");
        int id_Student = LMS.input.nextInt();
        System.out.println("Enter your id course: ");
        int id_course = LMS.input.nextInt();
        if (LMS.file_studnet.cheak_Existing(id_Student)
                && LMS.file_courses.cheak_Existing(id_course)
                && return_number_of_courses(id_Student) > 2) {
            List.remove(get_index_IdStudent(id_Student));
            return_number_of_courses(id_Student);
            System.out.println("Executed successfully...");
        } else {
            System.out.println("Execution failed...");
        }
    }

    //Search and print all students that are enrolled in a specific course by reading the course number from the user, also print the room and the instructor of that course
    public void Search_by_course_number() {
        System.out.println("Enter your id course: ");
        int id_course = LMS.input.nextInt();
        for (int i = 0; i < LMS.Processes_to_Appintments_Schedule.List.size(); i++) {
            if (Processes_to_Appintments_Schedule.List.get(i).getId_course() == id_course) {
                System.out.print(Processes_to_Appintments_Schedule.List.get(i).toString());
                for (int x = 0; x < List.size(); x++) {
                    System.out.print(List.get(x).toString());
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //return index Student
    public int get_index_IdStudent(int id_Student) {
        int index = -1;
        for (int x = 0; x < List.size(); x++) {
            if (List.get(x).getId_Student() == id_Student) {
                index = x;
            }
        }
        return index;
    }
}
