/*
Amanda Chang
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class SimulationDriver {

    public static void main(String[] args){
        //if true user wants multiple choice, if false user wants single choice
        boolean multiple=false;
        //number of answer choices user wants
        int choices;
        Random random = new Random();
        //use random to decide if question is multiple or single answer, 0-1
        int questionType = random.nextInt(2);
        //string of letters for students to choose from
        String choiceLetters = "";
        //how may students there are
        int studentCount;
        //how many answers the student will submit for multiple choice
        int answerCount;
        //initialize unique id for student
        String uniqueID;
        //possibleAnswer used to prevent repeats by the random generator
        char possibleAnswer;
        VotingService votingService = new VotingService();
        CreateStudent student;
        //temporary array where student can select answers
        //before submitting their final answer
        ArrayList<Character> tempAnswer = new ArrayList<>();

        SingleChoice singleChoice;
        MultipleChoice multipleChoice;

        System.out.println("\nVoting Simulator!\n\n"
            + "The question type, answer configuration (number of answer choices),\n" +
                "number of students, and student answers will all be randomly generated.\n");

        if (questionType==0) {
            multiple = true;
            System.out.println("Type: Multiple Choice");
        }
        else{
            multiple = false;
            System.out.println("Type: Single Choice");
        }

        //randomly choose max number of answer choices from 2-5
        choices = random.nextInt(4)+2;
        System.out.println("The number of available choices is: " + choices);

        //configure the question and answer
        votingService.configure(multiple, choices);

        //generate string of letters for students to select from
        if (choices==2){
            choiceLetters = "AB";
        }
        if (choices==3){
            choiceLetters = "ABC";
        }
        if (choices==4){
            choiceLetters = "ABCD";
        }
        if (choices==5){
            choiceLetters = "ABCDE";
        }

        //randomly decide how many students there are from 10 to 50
        studentCount = random.nextInt(41)+10;
        System.out.println("Number of students is: " + studentCount);

        //if it's multiple then students can submit multiple answers
        if (questionType==0){
            multipleChoice = new MultipleChoice(choices);
            //for loop for generating each student and their answer
            for (int i = 0; i<studentCount; i++){
                uniqueID = UUID.randomUUID().toString();
                //CreateStudent object with unique ID
                student = new CreateStudent(uniqueID);
                //randomly decide how many answers this student will input
                answerCount = random.nextInt(multipleChoice.getChoicesCount())+1;
                for (int j = 0; j < answerCount; j++){
                    //add the random letter if the answer has not chosen it yet
                    possibleAnswer = choiceLetters.charAt(random.nextInt(choiceLetters.length()));
                    if (tempAnswer.contains(possibleAnswer)==false){
                        tempAnswer.add(possibleAnswer);
                    }
                }
                student.setStudentAnswer(tempAnswer);
                //submit the student's answer to VotingService
                votingService.submit(student.getStudentAnswer());
                tempAnswer.clear();
            }
        }
        //if it's single then students can submit only one answer
        else if (questionType==1){
            singleChoice = new SingleChoice(choices);
            //for loop for generating each student and their answer
            for (int i = 0; i<studentCount; i++){
                uniqueID = UUID.randomUUID().toString();
                //CreateStudent object with unique ID
                student = new CreateStudent(uniqueID);
                //randomly decide student's answer
                tempAnswer.add(choiceLetters.charAt(random.nextInt(choiceLetters.length())));
                student.setStudentAnswer(tempAnswer);
                //check that the student selected only 1 answer
                singleChoice.studentCheck(tempAnswer);
                //submit the student's answer to VotingService
                votingService.submit(student.getStudentAnswer());
                tempAnswer.clear();
            }
        }
        //display the results of the vote
        votingService.display();
    }// end of main
}// end of SimulationDriver