package LMS_Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class File_Staff implements Functions {

    ArrayList<Staff> List = new ArrayList<>();

    @Override
    public void read_file() throws IOException {
        //connect the program with the text file for reading.
        Scanner readFile = new Scanner(new File("Staff.txt"));

        //initialize the variables that you will need to instantiate the object (Students)
        String first_name;
        String last_name;
        int id_staff;
        int office;

        while (readFile.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(readFile.nextLine(), "/");

            //use the information from one line to initialize the variables needed to instatiate the object
            first_name = token.nextToken();
            last_name = token.nextToken();
            id_staff = Integer.parseInt(token.nextToken());
            office = Integer.parseInt(token.nextToken());

            //add data into arrayList (Students)
            List.add(new Staff(first_name, last_name, id_staff, office));
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

    //Check if the Id_staff is Existing in the array
    @Override
    public boolean cheak_Existing(int id_staff) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_staff() == id_staff) {
                return true;
            }
        }
        return false;
    }

}
