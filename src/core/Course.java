package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String name;
    private Teacher professor;
    private int unit;
    private List<Student> students_list;
    private boolean is_activated;
    private List<Assignment> assignments_list;
    private int assignments_number;
    private int exam_date;
    private int students_number;
    private List<Assignment> activated_projects;
    private List<Assignment> unactivated_projects;
    private Map<Student, Integer> gp_list;

    public Course(String name, Teacher professor, int unit, boolean is_activated){
        this.name = name;
        this.professor = professor;
        this.unit = unit;
        this.is_activated = is_activated;
        this.students_list = new ArrayList<>();
        this.assignments_list = new ArrayList<>();
        this.activated_projects = new ArrayList<>();
        this.unactivated_projects = new ArrayList<>();
        this.gp_list = new HashMap<>();

    }


    public Map<Student, Integer> getGp_list() {
        return gp_list;
    }

    public String getName() {
        return name;
    }

    public int getUnit() {
        return unit;
    }

    public String getProfessor() {
        return professor.getName();
    }

    public List<Student> getStudents_list() {
        return students_list;
    }

    public List<Assignment> getAssignments_list() {
        return assignments_list;
    }

    public List<Assignment> getActivated_projects() {
        return activated_projects;
    }

    public List<Assignment> getUnactivated_projects() {
        return unactivated_projects;
    }

    public int getAssignments_number() {
        return assignments_number;
    }

    public int getExam_date() {
        return exam_date;
    }

    public int getStudents_number() {
        return students_number;
    }
    public boolean isIs_activated(){
        return is_activated;
    }

    public void setGp_list(Map<Student, Integer> gp_list) {
        this.gp_list = gp_list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setActivated_projects(List<Assignment> activated_projects) {
        this.activated_projects = activated_projects;
    }

    public void setAssignments_list(List<Assignment> assignments_list) {
        this.assignments_list = assignments_list;
    }

    public void setAssignments_number(int assignments_number) {
        this.assignments_number = assignments_number;
    }

    public void setExam_date(int exam_date) {
        this.exam_date = exam_date;
    }

    public void setIs_activated(boolean is_activated) {
        this.is_activated = is_activated;
    }

    public void setProfessor(Teacher professor) {
        this.professor = professor;
    }

    public void setStudents_list(List<Student> students_list) {
        this.students_list = students_list;
    }

    public void setStudents_number(int students_number) {
        this.students_number = students_number;
    }

    public void setUnactivated_projects(List<Assignment> unactivated_projects) {
        this.unactivated_projects = unactivated_projects;
    }


    public void students(){
        for(Student student : students_list){
            System.out.println(student.getName());
        }
    }
    public boolean addStudent(Student student){
        this.gp_list.put(student,null);
        student.addCourse(this);
        return this.students_list.add(student);
    }
    public boolean delStudent(Student student){
        this.gp_list.remove(student);
        student.delCourse(this);
        return this.students_list.remove(student);
    }
    public Integer highestGrade(){
        if(this.gp_list != null){
            int max = 0;
            for(Integer i : this.gp_list.values()){
                if(i > max){
                    max = i;
                }
            }
            return max;
        }
        else{
            System.out.println("ُThe gp list is empty!");
            return 0;
        }
    }
    public void addAssignment(Assignment a){
        this.assignments_list.add(a);
        for(int i = this.students_list.size()-1; i >= 0; i--){
            this.students_list.get(i).addAssignment(a);
        }
    }
    public void changeGp(Student s, Integer gp){
        this.gp_list.put(s,gp);
        s.changeGp(this,gp);
    }

}
