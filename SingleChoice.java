/*
Amanda Chang

Note: originally wanted a method here to check if the
Question's answer key was valid but ran out of time to
implement Question answer key into the program
 */

import java.util.ArrayList;

public class SingleChoice {
    //composition?
    private Question question;

    /*
    default constructor
     */
    public SingleChoice(){
        this.question = new Question();
    }

    /*
    constructor for creating a single choice question
    with a specified number of choices
     */
    public SingleChoice(int choices){
    this.question = new Question();
        question.setChoicesCount(choices);
    }

    public int getChoicesCount() {
        return question.getChoicesCount();
    }

    public void studentCheck(ArrayList<Character> studentSubmission){
        if(studentSubmission.size()!=1){
            System.out.println("You can only submit 1 answer!");
            //should throw an exception but simulator won't run into this error
        }
    }
}// end of SingleChoice