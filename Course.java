package coursemanage;

public class Course {
    private int id;
    private String name;
    private String instructor;
    private String duration;

    public Course(int id, String name, String instructor, String duration) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
    }

    public Course(String name, String instructor, String duration) {
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }
}
