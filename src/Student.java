import java.util.ArrayList;
import java.util.List;

public class Student {
    private int student_ID;
    private String password;
    private String name;
    private int registered_courses_length;
    private int unit;
    private List<Course> courses_list;
    private int total_gp;
    private int current_gp;

    public String getName() {
        return name;
    }

    public int getStudent_ID() {
        return student_ID;
    }
    public int getRegistered_courses_length() {
        return registered_courses_length;
    }
    public int getUnit() {
        return unit;
    }

    public List<Course> getCourses_list() {
        return courses_list;
    }

    public int getTotal_gp() {
        return total_gp;
    }

    public int getCurrent_gp() {
        return current_gp;
    }

    public void setCourses_list(List<Course> courses_list) {
        this.courses_list = courses_list;
    }

    public void setRegistered_courses_length(int registered_courses_length) {
        this.registered_courses_length = registered_courses_length;
    }

    public void setTotal_gp(int total_gp) {
        this.total_gp = total_gp;
    }

    public void setCurrent_gp(int current_gp) {
        this.current_gp = current_gp;
    }

    public Student(String name,int student_ID, String password){
        this.student_ID = student_ID;
        this.name = name;
        this.password = password;
        this.courses_list = new ArrayList<>();
    }


    public void courses(){
        for(Course course : courses_list){
            System.out.println(course.getName());
        }
    }
    public void totalGP(){
        System.out.println(this.getTotal_gp());
    }
    public void units(){
        System.out.println(this.getUnit());
    }

    public void addCourse(Course course){
        unit += course.getUnit();
        this.courses_list.add(course);
    }

}
