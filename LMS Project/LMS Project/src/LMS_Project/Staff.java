package LMS_Project;

public class Staff {

    private String first_name;
    private String last_name;
    private int id_staff;
    private int office;

    public Staff(String first_name, String last_name, int id_staff, int office) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_staff = id_staff;
        this.office = office;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public int getId_staff() {
        return this.id_staff;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public int getOffice() {
        return this.office;
    }

    @Override
    public String toString() {
        return "name: " + this.first_name + " " + this.last_name
                + "\n   Id: " + this.id_staff + "\n   office: " + this.office;
    }

}
