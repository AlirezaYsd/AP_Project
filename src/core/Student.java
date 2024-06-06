package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private int student_ID;
    private String password;
    private String name;
    private int registered_courses_length;
    private int unit;
    private List<Course> courses_list;
    private int total_gp;
    private Map<Course,Integer> current_gp;
    private List<Assignment> assignments_list;

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

    public Map<Course, Integer> getCurrent_gp() {
        return current_gp;
    }

    public List<Assignment> getAssignments_list() {
        return assignments_list;
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

    public void setCurrent_gp(Map<Course, Integer> current_gp) {
        this.current_gp = current_gp;
    }

    public void setAssignments_list(List<Assignment> assignments_list) {
        this.assignments_list = assignments_list;
    }

    public Student(String name, int student_ID, String password){
        this.student_ID = student_ID;
        this.name = name;
        this.password = password;
        this.courses_list = new ArrayList<>();
        this.current_gp = new HashMap<>();
        this.assignments_list = new ArrayList<>();
    }


    public void courses(){
        if(courses_list != null){
            for(Course course : courses_list){
                System.out.println(course.getName());
            }
        }
        else{
            System.out.println("ُThe courses list is empty!");
        }

    }
    public void totalGP(){
        int sum = 0;
        if(!this.current_gp.isEmpty()){
            for(Integer i : this.current_gp.values()){
                sum += i;
            }
        }
        if(sum !=0){
            this.total_gp = sum/this.current_gp.size();
            System.out.println(this.total_gp);
        }else{
            System.out.println(0);
        }

    }
    public void units(){
        System.out.println(this.getUnit());
    }

    public void addCourse(Course course){
        unit += course.getUnit();
        this.courses_list.add(course);
    }
    public void delCourse(Course course){
        unit -= course.getUnit();
        this.courses_list.remove(course);
    }

    public void changeGp(Course course, int gp){
        this.current_gp.put(course, gp);
    }

    public void addAssignment(Assignment a){
        this.assignments_list.add(a);
    }
}
