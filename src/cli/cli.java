package cli;

import core.Assignment;
import core.Course;
import core.Student;
import core.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cli {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("alireza");
        Student s1 = new Student("amir",1,"1234");
        Course c1 = new Course("math",t1,3,true);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(t1);
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("""
                    What is your organizational level?
                    1.Admin
                    2.Teacher
                    0.exit""");
            int input = scanner.nextInt();
            switch (input){
                case(1):
                    while(true){
                        System.out.println("""
                                What do you want to do?
                                1.Create a teacher
                                2.Create a student
                                3.Create a Course
                                4.Delete a Student
                                5.Delete a Course
                                6.Delete a teacher
                                0.Exit""");
                        int input_1 = scanner.nextInt();
                        switch (input_1){
                            case(1):
                                System.out.println("What is his name?");
                                String input_2 = scanner.next();
                                Teacher teacher_1 = new Teacher(input_2);
                                teacherList.add(teacher_1);
                                break;
                            case(2):
                                System.out.println("What is his name?");
                                String student_name = scanner.next();
                                System.out.println("What is his id?");
                                int student_id = scanner.nextInt();
                                System.out.println("What is his password?");
                                String student_password = scanner.next();
                                Student student = new Student(student_name,student_id,student_password);
                                studentList.add(student);
                                break;
                            case(3):
                                System.out.println("What is its name?");
                                String course_name = scanner.next();
                                System.out.println("Who is its professor?");
                                String prof_name = scanner.next();
                                Teacher course_prof = null;
                                //assume that admin user giving a valid prof name!
                                for(Teacher t : teacherList){
                                    if(t.getName().equals(prof_name)){
                                        course_prof = t;
                                    }
                                }
                                if(course_prof == null){
                                    System.out.println("we don't have this teacher in our list!");
                                }else{
                                    System.out.println("units?");
                                    int course_units = scanner.nextInt();
                                    System.out.println("is it activated or not?");
                                    boolean course_activated = scanner.nextBoolean();
                                    Course course = new Course(course_name, course_prof, course_units, course_activated);
                                    courseList.add(course);
                                    for(Teacher t : teacherList){
                                        if(t.getName().equals(prof_name)){
                                            t.addCourse(course);
                                        }
                                    }
                                }
                                break;
                            case(4):
                                System.out.println("What is his id");
                                int student_id1 = scanner.nextInt();
                                if(!studentList.isEmpty()){
                                    for(int i = studentList.size()-1; i >= 0; i--){
                                        if(studentList.get(i).getStudent_ID() == student_id1){
                                            studentList.remove(i);
                                        }
                                    }
                                }
                                break;
                            case(5):
                                System.out.println("What is its name");
                                String course_name1 = scanner.next();
                                if(!courseList.isEmpty()){
                                    for(int i = courseList.size()-1; i >= 0; i--){
                                        if(courseList.get(i).getName().equals(course_name1)){
                                            studentList.remove(i);
                                        }
                                    }
                                }
                                break;
                            case(6):
                                System.out.println("What is his name?");
                                String input_3 = scanner.next();
                                if(!teacherList.isEmpty()){
                                    for(int i = teacherList.size()-1; i >= 0; i--){
                                        if(teacherList.get(i).getName().equals(input_3)){
                                            teacherList.remove(i);
                                        }
                                    }
                                }
                                break;
                        }
                        if(input_1 == 0){
                            break;
                        }
                    }
                    break;
                case(2):
                    System.out.println("What is your name?");
                    String teacher_name = scanner.next();
                    for(Teacher teacher : teacherList){
                        if(teacher.getName().equals(teacher_name)){
                            while(true) {
                                System.out.println("""
                                    What do you want to do?
                                    1.Add a course
                                    2.Remove a course
                                    3.Add a student
                                    4.Remove a student
                                    5.Change gp
                                    6.Add an assignment
                                    0.Exit""");
                                int input_5 = scanner.nextInt();
                                switch (input_5){
                                    case(1):
                                        System.out.println("Which course do you want to add?");
                                        String course_name = scanner.next();
                                        for(int i = courseList.size()-1; i >= 0;i--){
                                            if(courseList.get(i).getName().equals(course_name)){
                                                if(!teacher.getCourses().contains(courseList.get(i))){
                                                    teacher.addCourse(courseList.get(i));
                                                }
                                            }
                                        }
                                        break;
                                    case(2):
                                        System.out.println("Which course do you want to remove?");
                                        String course_name1 = scanner.next();
                                        for(int i = courseList.size()-1; i >= 0;i--){
                                            if(courseList.get(i).getName().equals(course_name1)){
                                                if(teacher.getCourses().contains(courseList.get(i))){
                                                    teacher.delCourse(courseList.get(i));
                                                }
                                            }
                                        }
                                        break;
                                    case(3):
                                        System.out.println("Which student do you want to add?");
                                        String student_name = scanner.next();
                                        int student_index = 0;
                                        for(int i = studentList.size()-1; i >= 0; i--){
                                            if(studentList.get(i).getName().equals(student_name)){
                                                student_index = i;
                                            }
                                        }
                                        System.out.println("Which course?");
                                        String course_name2 = scanner.next();
                                        for(int i = courseList.size()-1; i >= 0;i--){
                                            if(courseList.get(i).getName().equals(course_name2)){
                                                if(!courseList.get(i).getStudents_list().contains(studentList.get(student_index))){
                                                    courseList.get(i).addStudent(studentList.get(student_index));
                                                }

                                            }
                                        }
                                        break;
                                    case(4):
                                        System.out.println("Which student do you want to remove?");
                                        String student_name1 = scanner.next();
                                        int student_index1 = 0;
                                        for(int i = studentList.size()-1; i >= 0; i--){
                                            if(studentList.get(i).getName().equals(student_name1)){
                                                student_index1 = i;
                                            }
                                        }
                                        System.out.println("Which course?");
                                        String course_name3 = scanner.next();
                                        for(int i = courseList.size()-1; i >= 0;i--){
                                            if(courseList.get(i).getName().equals(course_name3)){
                                                if(courseList.get(i).getStudents_list().contains(studentList.get(student_index1))){
                                                    courseList.get(i).delStudent(studentList.get(student_index1));
                                                }

                                            }
                                        }
                                        break;
                                    case(5):
                                        System.out.println("For who?");
                                        String student_name2 = scanner.next();
                                        int student_index2 = 0;
                                        for(int i = studentList.size()-1; i >= 0; i--){
                                            if(studentList.get(i).getName().equals(student_name2)){
                                                student_index2 = i;
                                            }
                                        }
                                        int course_index = 0;
                                        System.out.println("Which course?");
                                        String course_name4 = scanner.next();
                                        for(int i = courseList.size()-1; i >= 0;i--){
                                            if(courseList.get(i).getName().equals(course_name4)){
                                                course_index = i;
                                            }
                                        }
                                        System.out.println("gp?");
                                        int student_gp = scanner.nextInt();
                                        teacher.changeGp(studentList.get(student_index2),courseList.get(course_index),student_gp);
                                        break;
                                    case(6):
                                        System.out.println("Assignment name?");
                                        String assignment_name = scanner.next();
                                        System.out.println("For which course?");
                                        String course_name5 = scanner.next();
                                        int course_index1 = 0;
                                        for(int i = courseList.size()-1; i >= 0;i--){
                                            if(courseList.get(i).getName().equals(course_name5)){
                                                course_index1 = i;
                                            }
                                        }
                                        System.out.println("Is it activated or not?");
                                        boolean is_act = scanner.nextBoolean();
                                        System.out.println("deadline?");
                                        int assignment_deadline = scanner.nextInt();
                                        Assignment assignment = new Assignment(assignment_name, courseList.get(course_index1), is_act, assignment_deadline);
                                        teacher.addAssignment(assignment, courseList.get(course_index1));
                                        break;
                                }
                                if (input_5 == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            if(input == 0){
                break;
            }
        }


    }
}
