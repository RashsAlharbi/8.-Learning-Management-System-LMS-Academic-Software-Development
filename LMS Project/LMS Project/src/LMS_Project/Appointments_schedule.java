package LMS_Project;

/*
   - Class that contains the course, the course teacher, and the course appointment
 */
public class Appointments_schedule {

    private int id_course;
    private int id_room;
    private int id_staff;

    public Appointments_schedule(int id_course, int id_room, int id_staff) {
        this.id_course = id_course;
        this.id_room = id_room;
        this.id_staff = id_staff;
    }

    public Appointments_schedule(int id_course, int id_room) {
        this.id_course = id_course;
        this.id_room = id_room;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public int getId_course() {
        return this.id_course;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_room() {
        return this.id_room;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public int getId_staff() {
        return this.id_staff;
    }

    @Override
    public String toString() {
        return "id_course: " + id_course + "\n   id_room: " + id_room
                + "\n   id_staff: " + id_staff;
    }

}
