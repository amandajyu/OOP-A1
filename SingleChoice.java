import java.util.ArrayList;

public class SingleChoice {
    //composition
    private Question question;

    public SingleChoice(){
        this.question = new Question();
    }

//    public SingleChoice(int choices, ArrayList<String> answer){
    public SingleChoice(int choices){
    this.question = new Question();
        question.setChoicesCount(choices);
        //check that the answer is a valid size
//        if(answer.size()==1){
//            question.setAnswerKey(answer);
//        }
    }

//    public ArrayList<String> getAnswerKey() {
//        return question.getAnswerKey();
//    }

    public int getChoicesCount() {
        return question.getChoicesCount();
    }
    //TODO: throw and exception
}// end of SingleChoice