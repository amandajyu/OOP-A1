import java.util.ArrayList;

public class CreateStudent {
    private Student student;
    private ArrayList<Character> studentAnswer = new ArrayList<>();

    public CreateStudent(){
        this.student = new Student();
    }

    public CreateStudent(String id){
        this.student = new Student();
        student.setId(id);
    }

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
}
