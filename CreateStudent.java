/*
Amanda Chang
 */
import java.util.ArrayList;

public class CreateStudent {
    //composition
    private Student student;
    private ArrayList<Character> studentAnswer = new ArrayList<>();

    /*
    default constructor
     */
    public CreateStudent(){
        this.student = new Student();
    }

    /*
    constructor for creating a student with a given id
     */
    public CreateStudent(String id){
        this.student = new Student();
        student.setId(id);
    }

    /*
    constructor for creating a student with a given id and student's answer
     */
    public CreateStudent(String id, ArrayList<Character> studentAnswer){
        this.student = new Student();
        student.setId(id);
        student.setStudentAnswer(studentAnswer);
    }

    public ArrayList getStudentAnswer(){
        return student.getStudentAnswer();
    }

    public void setStudentAnswer(ArrayList studentAnswer){
        student.setStudentAnswer(studentAnswer);
    }
}//end of CreateStudent