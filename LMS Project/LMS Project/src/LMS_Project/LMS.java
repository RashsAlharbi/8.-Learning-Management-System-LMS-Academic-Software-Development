package LMS_Project;

import java.io.IOException;
import java.util.Scanner;

public class LMS {

    static Scanner input = new Scanner(System.in);
    static File_Student file_studnet = new File_Student();
    static File_Staff file_staff = new File_Staff();
    static File_Rooms file_rooms = new File_Rooms();
    static File_Courses file_courses = new File_Courses();
    static Processes_to_Appintments_Schedule Processes_to_Appintments_Schedule = new Processes_to_Appintments_Schedule();
    static Processes_to_Course_and_Students processes_to_course_and_students = new Processes_to_Course_and_Students();

    public static void main(String[] args) throws IOException {
        file_rooms.read_file();
        file_studnet.read_file();
        file_staff.read_file();
        file_courses.read_file();

        while (true) {
            System.out.println("Menu Choices:-");
            System.out.println("1. Add");
            System.out.println("2. Delete Student from a course");
            System.out.println("3. Search");
            System.out.println("4. Sort");
            System.out.println("5. Print Schedule");
            System.out.println("6. Exit");
            System.out.print("Enter your Choice:");
            int Choice = input.nextInt();
            if (Choice <= 0 || Choice >= 7) {
                System.out.println("Input error...\n");
            }
            switch (Choice) {
                case 1:
                    Add();
                    break;
                case 2:
                    Delete();
                    break;
                case 3:
                    Search();
                    break;
                case 4:
                    Sort();
                    break;
                case 5:
                    Print_Schedule();
                    break;
                case 6:
                    Exit();
            }
        }

    }

    public static void Add() throws IOException {
        System.out.println("\na. Allocate a course");
        System.out.println("b. Assign a course to an instructor");
        System.out.println("c. Add a course to a student\n");
        System.out.print("Enter your Choice:");
        char Choice = input.next().charAt(0);
        if (Choice == 'a' || Choice == 'b' || Choice == 'c') {
            switch (Choice) {
                case 'a':
                    Processes_to_Appintments_Schedule.Allocate_room_for_course();
                    break;
                case 'b':
                    Processes_to_Appintments_Schedule.Assign_a_course_to_an_instructor();
                    break;
                case 'c':
                    processes_to_course_and_students.Add_course_to_student();
                    break;
            }
        } else {
            System.out.println("Input error...\n");
        }
    }

    public static void Delete() {
        processes_to_course_and_students.delete_student_from_course();
    }

    public static void Search() {
        System.out.println("\na. Search by Id Student");
        System.out.println("b. Search by GPA");
        System.out.println("c. Search by code course\n");
        System.out.print("Enter your Choice:");
        char Choice = input.next().charAt(0);
        if (Choice == 'a' || Choice == 'b' || Choice == 'c') {
            switch (Choice) {
                case 'a':
                    file_studnet.Search_by_Id_Student();
                    break;
                case 'b':
                    file_studnet.Search_by_GPA();
                    break;
                case 'c':
                    processes_to_course_and_students.Search_by_course_number();
                    break;
            }
        } else {
            System.out.println("Input error...\n");
        }
    }

    public static void Print_Schedule() throws IOException {
        System.out.println("\na. Print Student schedule");
        System.out.println("b. Print Room schedule");
        System.out.println("c. Print Instructor schedule");
        System.out.println("d. Print Course schedule");
        System.out.println("e. Print the room and instructor for each course\n");

        System.out.print("Enter your Choice:");
        char Choice = input.next().charAt(0);
        if (Choice == 'a' || Choice == 'b' || Choice == 'c' || Choice == 'd' || Choice == 'e') {
            switch (Choice) {
                case 'a':
                    file_studnet.view_List();
                    break;
                case 'b':
                    file_rooms.view_List();
                    break;
                case 'c':
                    file_staff.view_List();
                    break;
                case 'd':
                    file_courses.view_List();
                    break;
                case 'e':
                    Processes_to_Appintments_Schedule.view_List();
                    break;
            }
        } else {
            System.out.println("Input error...\n");
        }
    }

    public static void Sort() {
        System.out.println("\na. Sort students by Id Student");
        System.out.println("b. Sort students by GPA\n");
        System.out.print("Enter your Choice:");
        char Choice = input.next().charAt(0);
        if (Choice == 'a' || Choice == 'b') {
            switch (Choice) {
                case 'a':
                    file_studnet.sort_list_ascending_order();
                    break;
                case 'b':
                    file_studnet.sort_list_descending_order();
                    break;
            }
        } else {
            System.out.println("Input error...\n");
        }
    }

    //Exit to programm
    public static void Exit() {
        System.exit(0);

    }
}
