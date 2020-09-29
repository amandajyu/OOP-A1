/*
Amanda Chang
 */
import java.util.ArrayList;

public interface VotingServiceInterface {

    /*
    configure the question and answer format for multiple choice
    */
    void configure(MultipleChoice multipleChoice);

    /*
    configure the question and answer format for single choice
    */
    void configure(SingleChoice singleChoice);

    /*
    each time a student submits their final answer, call on tally
     */
    void submit(MultipleChoice multipleChoice, CreateStudent student);

    /*
    each time a student submits their final answer
    check that it's only 1 answer and call on tally
     */
    void submit(SingleChoice singleChoice, CreateStudent student);

    /*
    add student's answer to the total results
     */
    void tally(CreateStudent student);

    /*
    display the results of the vote
     */
    void display();
}
