package core;

public class Assignment {
    private int deadline;
    private Course course;
    private String name;
    private boolean isActivated;

    public Assignment(String name, Course course, boolean isActivated, int deadline){
        this.name = name;
        this.course = course;
        this.deadline = deadline;
        this.isActivated = isActivated;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }


}
