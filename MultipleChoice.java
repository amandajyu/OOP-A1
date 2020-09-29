/*
Amanda Chang
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
