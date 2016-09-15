package main;

/**
 * Main LinkedList class used to test the functionality of our class
 * @author  Christopher Simon
 * @version 1.0
 */
public class Main {
    public static void main(String args[]) {
        LinkedList1 lst = new LinkedList1();
        // create instances for testing
        Student instance1 = new Student("John Doe 1", 1, "1 Somewhere", "916-555-1211", "johndoe1@somewhere.com");
        Student instance2 = new Student("John Doe 2", 2, "2 Somewhere", "916-555-1212", "johndoe2@somewhere.com");
        Student instance3 = new Student("John Doe 3", 3, "3 Somewhere", "916-555-1213", "johndoe3@somewhere.com");
        Student instance4 = new Student("John Doe 4", 4, "4 Somewhere", "916-555-1214", "johndoe4@somewhere.com");
        Student instance5 = new Student("John Doe 5", 5, "5 Somewhere", "916-555-1215", "johndoe5@somewhere.com");
        Student instance6 = new Student("John Doe 6", 6, "6 Somewhere", "916-555-1216", "johndoe6@somewhere.com");

        // begin adding entries to the list
        lst.addFirst(instance1);

        // test forward and backward for single entry
        lst.moveForward();
        lst.moveBackward();

        // now add more
        lst.addFirst(instance2);
        lst.addFirst(instance3);

        lst.addLast(instance4);
        lst.addLast(instance5);
        lst.addLast(instance6);

        // move current forward a few times
        lst.moveForward();
        lst.moveForward();

        // print out first and last entries
        System.out.println("Show the first entry:");
        System.out.println(lst.getFirstElement());
        System.out.println("\nShow the last entry:");
        System.out.println(lst.getLastElement());

        // print out the whole list
        System.out.println("\nShow the whole list:");
        System.out.println(lst);

        // remove entries starting from the last entry
        System.out.println("Begin emptying the list:");
        while(!lst.isEmpty()) {
            lst.removeLast();
            System.out.println(lst);
        }
    }
}