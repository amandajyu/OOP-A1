/*
Amanda Chang
 */
import java.util.ArrayList;
public class VotingService implements VotingServiceInterface{
    //number of answer choices
    private int countCopy;
    //each index of tally array corresponds to the total
    //number of votes for that choice
    private int[] tally = {0,0,0,0,0};

    public void configure(MultipleChoice multipleChoice) {
            countCopy = multipleChoice.getChoicesCount();
    }// end of configure for multiple choice

    public void configure(SingleChoice singleChoice) {
        countCopy = singleChoice.getChoicesCount();
    }

    public void submit(SingleChoice singleChoice, CreateStudent student){
        //check that the student only submits 1 answer for single choice questions
        singleChoice.studentCheck(student.getStudentAnswer());
        tally(student);
    }//end of submit for singleChoice

    public void submit(MultipleChoice multipleChoice, CreateStudent student) {
        tally(student);
    }

    public void tally(CreateStudent student) {
        if(student.getStudentAnswer().contains('A')) {
            tally[0] = tally[0] + 1;
        }
        if (student.getStudentAnswer().contains('B')){
            tally[1] = tally[1] + 1;
        }
        if (student.getStudentAnswer().contains('C')){
            tally[2] = tally[2] + 1;
        }
        if (student.getStudentAnswer().contains('D')){
            tally[3] = tally[3] + 1;
        }
        if (student.getStudentAnswer().contains('E')){
            tally[4] = tally[4] + 1;
        }
    }

    public void display(){
        System.out.println("Results:");
        if (countCopy==2){
            System.out.println("A: " + tally[0] + "\nB: "+tally[1]);
        }
        else if (countCopy==3){
            System.out.println("A: " + tally[0] + "\nB: "+ tally[1] + "\nC: " + tally[2]);
        }
        else if (countCopy==4){
            System.out.println("A: " + tally[0] + "\nB: "+ tally[1] + "\nC: " + tally[2]
                    + "\nD: " + tally[3]);
        }
        else if (countCopy==5){
            System.out.println("A: " + tally[0] + "\nB: "+ tally[1] + "\nC: " + tally[2]
                    + "\nD: " + tally[3] + "\nE: " + tally[4]);
        }
    }// end of display()
}//end of VotingService
