package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines the data and properties held in a student.
 * Also contains utilities for Student list manipulation
 * @author  Christopher Simon
 * @version 1.0
 */
public class Student {
    // The unique student id
    private String id;
    // The student scores
    private double[] scores;

    // Use a decimal formatter to round and pad to two decimal places
    private static DecimalFormat df = new DecimalFormat("00.00");

    /** Constructor */
    public Student(String id, double[] scores) {
        this.id     = id;
        this.scores = scores;
    }

    //
    // Getters
    //
    public String getId() {
        return id;
    }
    public double[] getScores() {
        return scores;
    }

    //
    // Setters
    //
    public boolean setId(String id) {
        this.id = id;
        return true;
    }
    public boolean setScores(double[] scores) {
        this.scores = scores;
        return true;
    }

    /**
     * Populates a List of students from a file
     * @param   fileName    The filename to read from
     * @return              List<Student>
     * @throws java.io.IOException
     */
    public static List<Student> loadFromFile(String fileName) throws IOException {
        // The student list used to hold students
        List<Student> students = new ArrayList<Student>();

        // Populate the students list from a file
        BufferedReader b = null;
        try {
            // Create a file handler and a buffer to read that file
            FileReader file = new FileReader(fileName);
            b = new BufferedReader(file);

            // Swallow the first line, as it is a header line
            b.readLine();
            // The current line
            String currentLine = b.readLine();
            // Read the file until no more lines exist
            while(currentLine != null) {
                // Tokenize the currentLine
                // Parse/Tokenize the currentLine using regEx to separate by spaces
                String[] lineData = currentLine.split("\\s");
                // The first entry is the student id
                // The rest of the entries are scores
                String currentStudentId = lineData[0];
                // Store the rest of the entries as an int array of scores for the currentStudent
                int totalScores = lineData.length;
                double[] currentStudentScores = new double[totalScores-1];
                // For each score, in lineData.
                // Scores start on an index value of 1
                for(int i = 1; i < totalScores; i++) {
                    // The current score
                    double currentScore = Double.parseDouble(lineData[i]);
                    // Store the score in a new array of studentScores
                    // We use an offset of -1, as the array is 0 based
                    // while the score index is starting on 1
                    int indexOffset = i-1;
                    currentStudentScores[indexOffset] = currentScore;
                }
                // Instantiate a new student to hold the current lineData
                Student s = new Student(currentStudentId, currentStudentScores);
                students.add(s);

                // Read the next line
                currentLine = b.readLine();
            }
        } catch(FileNotFoundException e) {
            // Indicate that the file was not found
            System.err.println("File not found!");
            System.err.printf("File Location: %s%n", fileName);
        } catch(IOException e) {
            // Indicate that an IO error has occurred
            System.err.println("Error!");
            e.printStackTrace();
        } finally {
            // Close the buffer reader if it has not been closed already
            if(b != null) {
                b.close();
            }
        }
        return students;
    }

    /**
     * Gets the array of scores for a list of students for a specified column.
     * This method assumes that each student has a score for the specified column
     * @param   students    The list of students to get the scores from
     * @param   column      The column to retrieve the scores from
     * @return              double[]
     */
    public static double[] getColumnScores(List<Student> students, int column) {
        // The column of scores
        double[] scores = new double[students.size()];

        // The loop index
        int i = 0;
        for(Student s : students) {
            // The current student scores
            double[] studentScores = s.getScores();
            // Get the score from the specified column
            scores[i] = studentScores[column];
            // Increment the index
            i++;
        }
        return scores;
    }

    public String toString() {
        // Set the rounding properties of the df to round up on a value of 5 or greater
        df.setRoundingMode(RoundingMode.HALF_UP);

        // Store the list of scores in a formatted string
        String scoresString = "";
        for(double score : this.scores) {
            scoresString += df.format(score) + " ";
        }
        // Return the formatted string, including the id and scores
        return String.format("%s %s", id, scoresString);
    }
}