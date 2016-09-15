import java.util.Scanner;

public class CollegeAdmit
{
    public static void main(String[] args) {
        //Run the admission program with an input scanner System.in
        admit(new Scanner(System.in));
    }
    
    public static void admit(Scanner input) {
        //The minimum GPA and SAT scores
        double minGPA = 1.8;
        double minSAT = 900;
        //The output message
        String output = "";
        //Create an input stdio
        System.out.println("University admission program");
        System.out.print("What is your GPA? ");
        double gpa = input.nextDouble();
        System.out.print("What is your SAT score? ");
        int sat = input.nextInt();
        if(gpa < minGPA) {
            output = "Your GPA is too low.";
        } else if(sat < minSAT) {
            output = "Your SAT score is too low.";
        } else {
            output = "You were accepted!";
        }
        System.out.print(output);
    }
}