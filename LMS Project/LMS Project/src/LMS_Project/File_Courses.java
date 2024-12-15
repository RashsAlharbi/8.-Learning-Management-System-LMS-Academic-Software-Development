package LMS_Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class File_Courses implements Functions {

    ArrayList<Courses> List = new ArrayList<>();

    @Override
    public void read_file() throws IOException {
        //connect the program with the text file for reading.
        Scanner readFile = new Scanner(new File("Courses.txt"));

        //initialize the variables that you will need to instantiate the object (Students)
        int start_time;
        String day;
        int id_course;
        int number_of_hours;
        int capacity;

        while (readFile.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(readFile.nextLine(), "/");

            //use the information from one line to initialize the variables needed to instatiate the object
            id_course = Integer.parseInt(token.nextToken());
            day = token.nextToken();
            start_time = Integer.parseInt(token.nextToken());
            number_of_hours = Integer.parseInt(token.nextToken());
            capacity = Integer.parseInt(token.nextToken());

            //add data into arrayList (Students)
            List.add(new Courses(id_course, number_of_hours, capacity, start_time, day));
        }

    }

    @Override
    //view all data from Array List  
    public void view_List() {
        System.out.println();
        for (int i = 0; i < List.size(); i++) {
            System.out.println(i + 1 + "- " + List.get(i).toString());
        }
        System.out.println();
    }

    //Check if the Id_course is Existing in the array
    @Override
    public boolean cheak_Existing(int id_course) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_course() == id_course) {
                return true;
            }
        }
        return false;
    }

    //Returns the specified course capacity
    public int get_capacity_course(int id_course) {
        int capacity = 0;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_course() == id_course) {
                capacity = List.get(i).getCapacity();
            }
        }
        return capacity;
    }

    //Reducing the capacity allowed in the course when adding any student
    public void change_capacity_coruse(int id_course, int capacity) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_course() == id_course) {
                List.get(i).setCapacity(--capacity);
            }
        }
    }
}
