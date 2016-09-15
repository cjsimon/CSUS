/**
 * Grader class that calculates grades using an internal
 * list of grades that can be populated and deleted from
 * @author Christopher Simon
 * @version 1.0
 */
public class Grader {
    //Instance Vars
    private double[] scores;

    /**
     * Constructor
     * scores An array of test scores.
     */
    public Grader(double[] scores) {
        //Assign the array argument to
        //the scores field
        this.scores = scores;
    }

    //
    // Getters
    //

    /**
     * Get the score of an element in scores
     * index The index of the score to return
     * return The score from scores
     */
    public double getScore(int index) {
        //Return the score if it's index exists in scores
        /* No need to check for and catch and error that is already going to happen
        if(index <= scores.length) {
            return scores[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        */
        return scores[index];
    }

    /**
     * Get the index of an element
     *
     * element The element to return the index for
     * return Index of specified element
     */
    public int getIndex(double element) {
        //Search through the elements.
        //Find an element that matches the one specified
        for(int i = 0; i < scores.length; i++) {
            //Does the current element match the one specified?
            if(scores[i] == element) {
                return i;
            }
        }
        //Return -1 as an error status
        return -1;
    }

    /**
     * Iterate through the whole array and get the lowest score
     * return The lowest test score.
     */
    public double getLowestScore() {
        //Being the only evaluated score at this point of execution,
        //the first score will be the lowest
        double least = scores[0];
        //For each of the remaining scores
        for(int i = 1; i < scores.length; i++) {
            //The current score
            double currentScore = scores[i];
            //If the the currentScore is lower than the least
            if(currentScore < least) {
                //By definition, the lest is now the currentScore
                least = currentScore;
            }
        }
        return least;
    }

    /**
     * Compute the average of the array of scores
     *
     * If the array contains less than two test scores,
     * display an error message and set average to 0.
     *
     * return Sum of all scores in scores array
     */
    public double getAverage() {
        int sum = 0;
        //For each score in scores
        for(double score : scores) {
            //Add the current score to the sum
            sum += score;
        }
        //Get the scores length as a double
        //to ensure that a double is returned
        return sum/((double)scores.length);
    }

    //
    // Mutators
    //

    /**
     * Remove a score from the scores array
     * index The index of the score to remove
     * return Status of the request
     */
    public boolean removeScore(int index) {
        //If the index specified does not exist in scores
        //Return false
        if(index < 0 || index > scores.length-1) return false;
        //Create a tmp array to store the new scores array in
        double[] tmp = new double[scores.length-1];
        //For all elements before the element to delete
        for(int i = 0; i < index; i++) {
            tmp[i] = scores[i];
        }
        //For all elements after the element to delete
        for(int i = index; i < scores.length-1; i++) {
            //Write the next score from the scores array.
            //This will skip score[index]
            tmp[i] = scores[i+1];
        }
        //Rewrite the scores array
        scores = tmp;
        return true;
    }
}