import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class SimulationDriver {

    public static void main(String[] args){
        //if true user wants multiple choice, if false user wants single choice
        boolean multiple=false;
        //number of answer choices user wants
        int choices;
//        ArrayList<String> answer = new ArrayList<String>();
        VotingService votingService = new VotingService();
        Random random = new Random();
        //use random to decide if question is multiple or single answer, 0-1
        int questionType = random.nextInt(2);
        //string of letters for students to choose from
        String choiceLetters = "";
        //how may students there are
        int studentCount;
        CreateStudent student;
        String uniqueID;
        ArrayList<Character> tempAnswer = new ArrayList<>();
        //how many answers student will submit for multiple choice
        int answerCount;
        char possibleAnswer;


//        multiple=false;
//        choices = 2;
//        //answer is A
//        answer.add("A");
//        votingService.configure(multiple, choices, answer);
//
//        ArrayList<String> studentAnswer = new ArrayList<>();
//        studentAnswer.add("A");
//        CreateStudent student1 = new CreateStudent("student1", studentAnswer);
//        votingService.submit(student1.getStudentAnswer());
//
//        studentAnswer.clear();
//        studentAnswer.add("B");
//        CreateStudent student2 = new CreateStudent("student2", studentAnswer);
//        votingService.submit(student2.getStudentAnswer());
//
//        System.out.println(student1.getStudentAnswer());
//        System.out.println(student2.getStudentAnswer());
//        votingService.display();



//        //students will have a temp to make changes to their a
//        ArrayList<String> tempAnswer = new ArrayList<>();
//
//        Student student1 = new Student();
//        student1.setId("student1");


        //TODO: use multiple, choices, and answer to configure question object
//        System.out.println("Single choice lets students submit only one answer.\n"
//                + "Multiple choice lets students submit multiple answers.");

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




//        String tempName;

        //randomly decide how many students there are from 10 to 50
        studentCount = random.nextInt(41)+10;
        System.out.println("Number of students is: " + studentCount);

        //if it's multiple then students can submit multiple answers
        if (questionType==0){
            //for loop for generating each student and their answer
            for (int i = 0; i<studentCount; i++){
                uniqueID = UUID.randomUUID().toString();
                //CreateStudent object with unique ID
                student = new CreateStudent(uniqueID);
                //randomly decide how many answers this student will input
                answerCount = random.nextInt(choices)+1;
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
            //for loop for generating each student and their answer
            for (int i = 0; i<studentCount; i++){
//                tempName = String.format("student%d",i-9);
                uniqueID = UUID.randomUUID().toString();
                //CreateStudent object with unique ID
                student = new CreateStudent(uniqueID);
                //randomly decide student's answer
                tempAnswer.add(choiceLetters.charAt(random.nextInt(choiceLetters.length())));
                student.setStudentAnswer(tempAnswer);
                //submit the student's answer to VotingService
//                System.out.println("student answer" + student.getStudentAnswer());
                votingService.submit(student.getStudentAnswer());
                tempAnswer.clear();
            }
        }
        //display the results of the vote
        votingService.display();
    }// end of main
}// end of SimulationDriver

/*
NOTE: instead of array list what if i used a string and parsed it and only when
checking answer i make it into an array list?

instead of using tempAnswer what if I made an array of the student objects and have a loop where i got through the array
of students and submit ea of their answers
 */
