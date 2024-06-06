package backend;

import core.Student;
import core.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Backend {
    private String studentFilePath = "./src/db/studentInfo.txt";
    private String teacherFilePath = "./src/db/teacherInfo.txt";
    public Student studentSignUp(String name, int id, String password){
        Student s = new Student(name, id, password);
        try{
            FileWriter fileWriter = new FileWriter(studentFilePath,true);
            fileWriter.write(name+","+id+","+password+"\n");
            fileWriter.close();
            System.out.println("Data Added.");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return s;
    }
    public Teacher teacherSignUp(String name){
        Teacher t = new Teacher("name");
        try{
            FileWriter fileWriter = new FileWriter(teacherFilePath,true);
            fileWriter.write(name+"\n");
            fileWriter.close();
            System.out.println("Data Added.");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return t;
    }
    public boolean studentSignIn(int id, String pass){
        try(BufferedReader reader = new BufferedReader(new FileReader(studentFilePath))){
            String line;
            String[] info;
            boolean cor_pass = false;
            boolean incorr_pass = false;
            int c = 0;
            while((line = reader.readLine()) != null){
                info = line.split(",");
                if(Integer.parseInt(info[1]) == id){
                    c += 1;
                    if(info[2].equals(pass)){
                        System.out.println("signed in.");
                        cor_pass = true;
                    }else{
                        System.out.println("incorrect password.");
                    }
                }
            }
            if(c == 0){
                System.out.println("incorrect id.");
                return false;
            }
            if(cor_pass){
                return true;
            }else{
                return false;
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean teacherSignIn(String name) {
        boolean signedin = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(teacherFilePath))) {
            String line;
            String[] info;
            int c = 0;
            while ((line = reader.readLine()) != null) {
                if (line.equals(name)) {
                    System.out.println("signed in.");
                    signedin = true;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (signedin) {
            return true;
        }else{
            System.out.println("incorrect name.");
            return false;
        }
    }
}
