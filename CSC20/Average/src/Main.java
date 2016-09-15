import java.util.Scanner;

/**
 * The main program that calculates the class average for CSC20
 * @author Christopher Simon
 */
public class Main {
    public static void main(String[] args) {
        //Create a Scanner object for keyboard input.
        Scanner input = new Scanner(System.in);

        //Prompt for the total number of scores
        int totalScores = getTotal(input);
        //If the totalScores is less than 2 exit
        if(totalScores < 2) {
            System.out.println("Not enough scores!");
            //End the main method, thus ending the program
            return;
        }
        //Get the values of the scores
        double[] scores = getScores(input, totalScores);

        //Instantiate a grader instance
        Grader csc20 = new Grader(scores);

        //Store the lowest score
        double lowestScore = csc20.getLowestScore();
        //Get the index of the lowestScore
        int lowestScoreIndex = csc20.getIndex(lowestScore);
        //Remove the lowest score
        csc20.removeScore(lowestScoreIndex);

        //Display the adjusted average without the lowestScore
        double avg = csc20.getAverage();
        System.out.printf("The class average without the lowest test score is: %.2f%%%n", avg);
        //Display the lowest score
        System.out.printf("The lowest score in the class is: %.2f%%", lowestScore);
    }

    /**
     * Try to get the totalScores count from the scanner
     * input Scanner
     * return totalScores
     */
    public static int getTotal(Scanner input) {
        System.out.print("Enter the number of test scores: ");
        try {
            //Attempt to parse the user input as an int
            return Integer.parseInt(input.nextLine());
        } catch(java.lang.Exception e) {
            System.out.println("Please enter a whole number!");
            //Rerun the request for scores
            return getTotal(input);
        }
    }

    /**
     * Try to get the values of the scores
     * input Scanner
     * totalScores Number of scores to prompt for
     * return Array of scores
     */
    public static double[] getScores(Scanner input, int totalScores) {
        double[] scores = new double[totalScores];
        for(int i = 0; i < totalScores; i++) {
            System.out.printf("Score #%s: ", i+1);
            try {
                //The current score
                double score = Double.parseDouble(input.nextLine());
                //Store the score in the array
                scores[i] = score;
            } catch (java.lang.Exception e) {
                System.out.println("Please enter a decimal number!");
                //Rerun the last iteration
                i--;
            }
        }
        return scores;
    }
}