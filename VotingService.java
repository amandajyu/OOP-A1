import java.util.ArrayList;

public class VotingService implements VotingServiceInterface{
//    private ArrayList<String> answerKeyCopy = new ArrayList<>();
    private int countCopy;
    private int MAX_CHOICES=5;
    private int[] tally = {0,0,0,0,0};

    public void askChoice(){
        System.out.println("Input 1 for True or False Choices\n" +
                "Input 2 for \"A\",\"B\" Choices\n" +
                "Input 3 for \"A\",\"B\",\"C\" Choices\n" +
                "Input 4 for \"A\",\"B\",\"C\",\"D\" Choices\n" +
                "Input 5 for \"A\",\"B\",\"C\",\"D\",\"E\" Choices\n");
    }

//    public void askAnswerTF(){
//        System.out.println("What is the answer to the question?\n" +
//                "Input T if the answer is True" +
//                "Input F is the answer is False");
//    }

    public void askAnswer(){
        System.out.println("Input the answer letter in caps");
    }

//    public void configure(boolean multiple, int choices, ArrayList<String> answer){
        public void configure(boolean multiple, int choices){
        if (multiple){
            MultipleChoice multipleChoice = new MultipleChoice(choices);
//            MultipleChoice multipleChoice = new MultipleChoice(choices, answer);
//            answerKeyCopy = multipleChoice.getAnswerKey();
            countCopy = multipleChoice.getChoicesCount();
        }
        else{
//            SingleChoice singleChoice = new SingleChoice(choices, answer);
            SingleChoice singleChoice = new SingleChoice(choices);
//            answerKeyCopy = singleChoice.getAnswerKey();
            countCopy = singleChoice.getChoicesCount();
        }

    }// end of configure()

    public void submit(ArrayList<Character> studentAnswer){
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
    public void display(){
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
