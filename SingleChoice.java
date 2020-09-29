/*
Amanda Chang
Note: originally made SingleChoice and MultipleChoice to check
that the Question's answer was valid but ran out of time to
implement Question answer into the program
 */
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
        //check that the answer is a valid size, if not throw exception
//        if(answer.size()==1){
//            question.setAnswerKey(answer);
//        }
    }

    public int getChoicesCount() {
        return question.getChoicesCount();
    }
}// end of SingleChoice