package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main program that reads in a list of student scores from a text file
 * and calculates the average, lowest and highest scores for each assignment.
 * The output is then saved to a new text file
 */
public class Main {
    // The list of students
    static List<Student> students = new ArrayList<Student>();

    /**
     * Reads in a file containing student data.
     * The data is then calculated and saved to an output file
     * @param   args    The filename to read the student data from
     * @throws          IOException
     */
    public static void main(String[] args) throws IOException {
        // The default file to read the student data from
        String loadFile = "students.txt";
        String saveFile = "output.txt";
        // Get the load and save file arg if they were specified
        if(args.length >= 1) {
            loadFile = args[0];
            if(args.length >= 2) {
                saveFile = args[1];
            }
        }

        // Read in the student data from a file
        students = Student.loadFromFile(loadFile);

        // Calculate and save the student to an output file
        saveStudentData(saveFile);

    }

    public static void saveStudentData(String saveFile) {
        // Create a file handler for the output data
        PrintWriter file = null;
        try {
            file = new PrintWriter(saveFile, "UTF-8");
            // Save the data
            file.println("STUD LAB 1 LAB 2 LAB 3 LAB 4 LAB 5");
            // Save the list of students
            for (Student s : students) {
                file.println(s);
            }
            // Save the calculated lab scores
            saveLabScores(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (UnsupportedEncodingException e) {
            System.err.println("File encoding not supported!");
        } finally {
            if(file != null){
                // Close the file if it exists
                file.close();
            }
        }
    }

    /** Calculates and prints the student labScores */
    public static void saveLabScores(PrintWriter file) {
        // Assuming that each student has the same number of scores,
        // get the totalScores of the students from the first one
        int totalScores = students.get(0).getScores().length;

        // For each score, or lab, is this case
        for(int lab = 0; lab < totalScores; lab++) {
            // The array of labScores representing each student's lab score.
            // It is assumed that each student has a score
            double[] labScores = Student.getColumnScores(students, lab);

            // Calculate the greatest, least and average of the current labScores
            Calculation.calculate(labScores);
        }
        file.write(Calculation.getString());
    }
}