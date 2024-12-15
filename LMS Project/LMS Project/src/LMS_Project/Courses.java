package LMS_Project;

public class Courses {

    private int id_course;
    private int number_of_hours;
    private int capacity;
    private int start_time;
    private String day;

    public Courses(int id_course, int number_of_hours, int capacity, int start_time, String day) {
        this.id_course = id_course;
        this.number_of_hours = number_of_hours;
        this.capacity = capacity;
        this.start_time = start_time;
        this.day = day;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public int getId_course() {
        return this.id_course;
    }

    public void setNumber_of_hours(int number_of_hours) {
        this.number_of_hours = number_of_hours;
    }

    public int getNumber_of_hours() {
        return this.number_of_hours;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getStart_time() {
        return this.start_time;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return this.day;
    }

    @Override
    public String toString() {
        return "ID: " + id_course + "\n    number_of_hours: "
                + number_of_hours + "\n    capacity: " + this.capacity
                + "\n    start_time: " + this.start_time + "\n    day: " + this.day;
    }

}
