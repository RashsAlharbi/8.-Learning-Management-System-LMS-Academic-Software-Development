package LMS_Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class File_Student implements Functions {

    ArrayList<Students> List = new ArrayList<>();

    @Override
    public void read_file() throws IOException {
        //connect the program with the text file for reading.
        Scanner readFile = new Scanner(new File("Students.txt"));

        //initialize the variables that you will need to instantiate the object (Students)
        String first_name;
        String last_name;
        int id_student;
        double GPA;

        while (readFile.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(readFile.nextLine(), "/");

            //use the information from one line to initialize the variables needed to instatiate the object
            first_name = token.nextToken();
            last_name = token.nextToken();
            id_student = Integer.parseInt(token.nextToken());
            GPA = Double.parseDouble(token.nextToken());

            //add data into arrayList (Students)
            List.add(new Students(first_name, last_name, id_student, GPA));
        }
    }

    //view all data from Array List  
    @Override
    public void view_List() {
        System.out.println();
        for (int i = 0; i < List.size(); i++) {
            System.out.println(i + 1 + "- " + List.get(i).toString());
        }
        System.out.println();
    }

    //Check if the Id_student is Existing in the array
    @Override
    public boolean cheak_Existing(int id_student) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_student() == id_student) {
                return true;
            }
        }
        return false;
    }

    //Sort students in ascending order according to ID student
    public void sort_list_ascending_order() {

        Collections.sort(List);

        // print List Student ascending order  
        for (int i = 0; i < List.size(); i++) {
            System.out.println((i + 1) + "- " + List.get(i).toString());
        }
    }

    //Sort students in descending order according to GPA.
    public void sort_list_descending_order() {

        Comparator comparator = (Comparator<Students>) (Students s2, Students s1) -> Double.valueOf(s2.getGPA()).compareTo(s1.getGPA());
        Collections.sort(List, comparator);

        // print List Student descending order  
        for (int i = 0; i < List.size(); i++) {
            System.out.println((i + 1) + "- " + List.get(i).toString());
        }
    }

    //Search by ID number and print that student data if found.    
    public void Search_by_Id_Student() {
        System.out.print("Enter your id student: ");
        int id_student = LMS.input.nextInt();
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_student() == id_student) {
                System.out.println(List.get(i).toString());
                return;
            }
        }
        System.out.println("The student not found...");
    }

    //Search and print all students that their GPA is greater than a specific number (read from the user).
    public void Search_by_GPA() {
        System.out.print("Enter your GPA : ");
        double GPA = LMS.input.nextDouble();
        boolean status = false;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getGPA() >= GPA) {
                System.out.println(List.get(i).toString());
                status = true;
            }
        }
        if (status == false) {
            System.out.println("The student not found...");
        }
    }

}
