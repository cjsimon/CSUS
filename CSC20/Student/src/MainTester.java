/**
 * Main Tester Class
 */
public class MainTester {
    public static void main(String[] args) {
        String name     = "Christopher Simon";
        int id          = 216711899;
        String address  = "Folsom";
        String phone    = "9164624693";
        String email    = "simon@csus.edu";

        Student student = new Student(
            name,
            id,
            address,
            phone,
            email
        );

        Csc20Student cscStudent = new Csc20Student(
            name,
            id,
            address,
            phone,
            email,
            true,
            45
        );

        System.out.println(student + "\n");
        System.out.println(cscStudent + "\n");
    }
}