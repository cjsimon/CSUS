import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MainTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }



   /** A test that always fails. **/
   @Test public void defaultTest() {
      TTTBoard board = new TTTBoard();
	  board.set(1, 1, 'x');
	  
	  assertEquals(board.get(1, 1), 'x');
   }
}
