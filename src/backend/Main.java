package backend;

public class Main {
    public static void main(String[] args) {
        Backend b = new Backend();
        b.studentSignUp("Alireza",1,"1234");
        b.teacherSignUp("ali");
        b.teacherSignUp("mahi");
        b.studentSignIn(1,"1234");
        b.teacherSignIn("amin");
    }
}
