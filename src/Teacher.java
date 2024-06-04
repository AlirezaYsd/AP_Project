import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private List<Course> courses;


    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Teacher(String name){
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void delStudent(Student s, Course c){
        c.delStudent(s);
    }
    public void addStudent(Student s, Course c){
        c.addStudent(s);
    }
    public void changeGp(Student s, Course c, Integer gp){
        c.changeGp(s,gp);
    }
    public void addAssignment(Assignment a, Course c){
        c.addAssignment(a);
    }

}
