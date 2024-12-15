package LMS_Project;

import java.io.IOException;
import java.util.ArrayList;

public class Processes_to_Appintments_Schedule {

    //Class for adding course and staff to room through ID staff and ID course and ID room 
    static ArrayList<Appointments_schedule> List = new ArrayList<>();

    // To check if the course has been allocated a room and staff
    public boolean have_room_and_staff(int id_course) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_course() == id_course && List.get(i).getId_room() != 0
                    && List.get(i).getId_staff() != 0) {
                return true;
            }
        }
        return false;
    }

    //Checks the number of courses for a Staff
    public int check_number_of_course(int id_staff) {
        int number_of_course = 0;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_staff() == id_staff) {
                number_of_course++;
            }
        }
        return number_of_course;
    }

    // Allocate a course , check for empty rooms and match the capacity.
    public void Allocate_room_for_course() {
        System.out.println("Enter your id course : ");
        int id_course = LMS.input.nextInt();
        System.out.println("Enter your id room : ");
        int id_room = LMS.input.nextInt();
        if (LMS.file_rooms.cheak_Existing(id_room)
                && LMS.file_courses.cheak_Existing(id_course)
                && LMS.file_courses.get_capacity_course(id_course)
                <= LMS.file_rooms.get_capacity_room(id_room)
                && LMS.file_rooms.get_status(id_room)) {
            List.add(new Appointments_schedule(id_course, id_room));
            LMS.file_rooms.change_status_Room(id_room, false);

            System.out.println("\nExecuted successfully...\n");

        } else {
            System.out.println("\nExecution failed...\n");
        }

    }

    //return index course
    public static int get_index_codeCourse(int id_course) {
        int index = 0;
        for (int x = 0; x < List.size(); x++) {
            if (List.get(x).getId_course() == id_course) {
                index = x;
            }
        }
        return index;
    }

    // Assign a course to an instructor ,and check the schedule to avoid conflicts and staff can’t take more than 3 courses.
    public void Assign_a_course_to_an_instructor() throws IOException {
        System.out.println("Enter your id course : ");
        int id_course = LMS.input.nextInt();
        System.out.println("Enter your id staff: ");
        int id_Staff = LMS.input.nextInt();
        if (check_Staff_to_course(id_course, id_Staff)
                && check_number_of_course(id_Staff) < 3
                && LMS.file_staff.cheak_Existing(id_Staff)) {
            List.set(get_index_codeCourse(id_course),
                    new Appointments_schedule(id_course, get_room_course(id_course), id_Staff));

            System.out.println("\nExecuted successfully...\n");

        } else {
            System.out.println("\nExecution failed...\n");
        }
    }

    public void view_List() {
        for (int i = 0; i < List.size(); i++) {
            System.out.println((i + 1) + "- " + List.get(i).toString());
        }
    }

    //Verify that the staffs is not duplicated in Coruses
    public boolean check_Staff_to_course(int id_course, int id_Staff) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_staff() == id_Staff) {
                if (List.get(i).getId_course() == id_course) {
                    return false;
                }
            }
        }
        return true;
    }

    public int get_room_course(int id_course) {
        int id_room = 0;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_course() == id_course) {
                id_room = List.get(i).getId_room();
            }
        }
        return id_room;
    }

}
