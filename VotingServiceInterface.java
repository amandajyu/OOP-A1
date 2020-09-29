/*
Amanda Chang
 */
import java.util.ArrayList;

public interface VotingServiceInterface {
    /*
    arguments: Boolean multiple determines if it's multiple or single choice
    choices is the number of answer choices to show
    answer is what the answer to the question is
    */
    void configure(boolean multiple, int choices);

    /*
    once students submit their final answer no more changes can be made.
    The service then tallies the students' answers
     */
    void submit(ArrayList<Character> studentAnswer);

    /*
    method for displaying the result of the voting
     */
    void display();
}
