/*
Amanda Chang
 */
import java.util.ArrayList;

public class VotingService implements VotingServiceInterface{
    //number of answer choices
    private int countCopy;
    private boolean multiple;
    //each index of tally array corresponds to the total
    //number of votes for that choice
    private int[] tally = {0,0,0,0,0};
        /*
        configure the question and answer format
         */
        public void configure(boolean multiple, int choices){
        this.multiple = multiple;
        countCopy = choices;
    }// end of configure()

    /*
    each time a student submits their final answer, add their answers
    to the total results in the tally array
     */
    public void submit(ArrayList<Character> studentAnswer){
        //check that the student only submits 1 answer for single choice questions
        if (!multiple && studentAnswer.size()>1){
            System.out.println("Invalid Answer! Only submit 1 answer");
        }
        else {
            if(studentAnswer.contains('A')) {
                tally[0] = tally[0] + 1;
            }
            if (studentAnswer.contains('B')){
                tally[1] = tally[1] + 1;
            }
            if (studentAnswer.contains('C')){
                tally[2] = tally[2] + 1;
            }
            if (studentAnswer.contains('D')){
                tally[3] = tally[3] + 1;
            }
            if (studentAnswer.contains('E')){
                tally[4] = tally[4] + 1;
            }
        }
    }//end of submit

    /*
    display the results of the vote
     */
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
