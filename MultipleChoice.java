import java.util.ArrayList;

public class MultipleChoice {
    //composition
    private Question question;

    public MultipleChoice(){
        this.question = new Question();
    }
//    public MultipleChoice(int choices, ArrayList<String> answer){
    public MultipleChoice(int choices){
        this.question = new Question();
        question.setChoicesCount(choices);
        //check that the answer is a valid size
//        if(answer.size()>=1 && answer.size()<=choices){
////            question.setAnswerKey(answer);
//        }
    }
//
//    public ArrayList<String> getAnswerKey() {
////        return question.getAnswerKey();
//    }

    public int getChoicesCount() {
        return question.getChoicesCount();
    }

    //TODO: throw and exception
} //end of MultipleChoice
