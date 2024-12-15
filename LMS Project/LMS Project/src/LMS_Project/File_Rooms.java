package LMS_Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class File_Rooms implements Functions {

    ArrayList<Rooms> List = new ArrayList<>();

    @Override
    public void read_file() throws IOException {
        //connect the program with the text file for reading.
        Scanner readFile = new Scanner(new File("Rooms.txt"));

        //initialize the variables that you will need to instantiate the object (Students)
        int id_room;
        int capacity;
        boolean empty;
        while (readFile.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(readFile.nextLine(), "/");

            //use the information from one line to initialize the variables needed to instatiate the object
            id_room = Integer.parseInt(token.nextToken());
            capacity = Integer.parseInt(token.nextToken());
            empty = Boolean.parseBoolean(token.nextToken());
            //add data into arrayList (Students)
            List.add(new Rooms(id_room, capacity, empty));
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

    //Check if the id_room is Existing in the array
    @Override
    public boolean cheak_Existing(int id_room) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_room() == id_room) {
                return true;
            }
        }
        return false;
    }

    //Returns the specified room capacity
    public int get_capacity_room(int id_room) {
        int capacity = 0;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_room() == id_room) {
                capacity = List.get(i).getCapacity();
            }
        }
        return capacity;
    }

    //Changing the room from available to unavailable when booking the course
    public void change_status_Room(int id_room, boolean empty) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_room() == id_room) {
                List.get(i).setIs_empty(empty);
            }

        }
    }

    public boolean get_status(int id_room) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId_room() == id_room) {
                if (List.get(i).getIs_empty() == false) {
                    return false;
                }
            }

        }
        return true;
    }
}
