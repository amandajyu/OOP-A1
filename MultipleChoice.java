/*
Amanda Chang

Note: originally wanted a method here to check if the
Question's answer key was valid but ran out of time to
implement Question answer key into the program
 */

public class MultipleChoice {
    //composition?
    private Question question;

    /*
    default constructor
     */
    public MultipleChoice(){
        this.question = new Question();
    }

    /*
    constructor for creating a multiple choice question
    with a specified number of choices
     */
    public MultipleChoice(int choices){
        this.question = new Question();
        this.question.setChoicesCount(choices);
    }

    public int getChoicesCount() {
        return question.getChoicesCount();
    }
} //end of MultipleChoice
