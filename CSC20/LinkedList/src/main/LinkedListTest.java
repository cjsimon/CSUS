package main;

// Description: Test module to test single linear linkedlist with
// Student objects
// Doan Nguyen - 3/1/15
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    /** Fixture initialization (common initialization
     *  for all tests). **/
    Student instance1, instance2, instance3, instance4, instance5, instance6, instance7, instance8;
    @Before public void setUp() {
        instance1 = new Student("John Doe 1", 1, "1 Somewhere", "916-555-1211", "johndoe1@somewhere.com");
        instance2 = new Student("John Doe 2", 2, "2 Somewhere", "916-555-1212", "johndoe2@somewhere.com");
        instance3 = new Student("John Doe 3", 3, "3 Somewhere", "916-555-1213", "johndoe3@somewhere.com");
        instance4 = new Student("John Doe 4", 4, "4 Somewhere", "916-555-1214", "johndoe4@somewhere.com");
        instance5 = new Student("John Doe 5", 5, "5 Somewhere", "916-555-1215", "johndoe5@somewhere.com");
        instance6 = new Student("John Doe 6", 6, "6 Somewhere", "916-555-1216", "johndoe6@somewhere.com");
        instance7 = new Student("John Doe 7", 7, "7 Somewhere", "916-555-1217", "johndoe7@somewhere.com");
        instance8 = new Student("John Doe 8", 8, "8 Somewhere", "916-555-1218", "johndoe8@somewhere.com");
    }

    // test addFirst and getFirst
    @Test public void testaddGetFirst() {
        LinkedList1 lst = new LinkedList1();
        lst.addFirst(instance1);
        int expResult = 1;
        assertEquals(expResult, lst.length());
        Student instance = (Student) lst.getFirstElement();
        assertEquals("John Doe 1", instance.getName());
    }

    // test list traversal 1 with forward, getFirst, and getLast
    @Test public void testTraversal1() {
        LinkedList1 lst = new LinkedList1();
        lst.addFirst(instance1);
        lst.addFirst(instance2);
        lst.addFirst(instance3);
        lst.addLast(instance4);
        lst.addLast(instance5);
        lst.addLast(instance6);
        // 321456
        lst.moveForward();
        lst.moveForward();
        lst.insertAfter(instance7);
        Student stf = (Student)lst.getFirstElement();
        Student stl = (Student)lst.getLastElement();
        assertEquals("John Doe 3", stf.getName());
        assertEquals("John Doe 6", stl.getName());
    }

    // test list traversal 2 with backward, getFirst, getLast, and size
    @Test public void testTraversal2() {
        LinkedList1 lst = new LinkedList1();
        lst.addFirst(instance1);
        lst.addFirst(instance2);
        lst.addFirst(instance3);
        lst.addLast(instance4);
        lst.addLast(instance5);
        lst.addLast(instance6); // Current is moved to end
        // 321456
        //      C
        lst.moveBackward();
        lst.moveBackward();
        lst.moveBackward();
        lst.moveBackward();
        lst.moveBackward();
        lst.moveBackward();
        System.out.print(lst.getCurrentElement());
        lst.insertBefore(instance7); // 7321456

        Student stf = (Student)lst.getFirstElement(); // 7
        Student stl = (Student)lst.getLastElement(); // 6
        //System.out.print(lst);
        assertEquals("John Doe 7", stf.getName());
        assertEquals("John Doe 6", stl.getName());
        assertEquals(7, lst.length());
    }
}