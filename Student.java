import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student {
    private String id;
    private ArrayList<Character> studentAnswer = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Character> getStudentAnswer(){
        return studentAnswer;
    }

    public void setStudentAnswer(ArrayList<Character> studentAnswer){
        //clear the list to prevent multiple submissions, only last submission is counted
        this.studentAnswer.clear();
        this.studentAnswer.addAll(studentAnswer);
    }
} // end of Student
