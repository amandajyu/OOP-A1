/*
Amanda Chang
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
            //could make it throw an exception but simulator won't run into this error
        }
    }
}// end of SingleChoice