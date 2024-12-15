package LMS_Project;

public class Rooms {

    private int id_room;
    private int capacity;
    private boolean is_empty;

    public Rooms(int id_room, int capacity, boolean is_empty) {
        this.id_room = id_room;
        this.capacity = capacity;
        this.is_empty = is_empty;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_room() {
        return this.id_room;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setIs_empty(boolean is_empty) {
        this.is_empty = is_empty;
    }

    public boolean getIs_empty() {
        return this.is_empty;
    }

    @Override
    public String toString() {
        return "Rooms{ " + "id_room: " + this.id_room + " , capacity: "
                + capacity + " , is_empty: " + is_empty + " }";
    }

}
