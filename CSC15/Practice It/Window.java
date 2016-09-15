/*
 * Title: Window
 * Description: Generate a window
 * By: Christopher Simon
 *
 * Created: 10/3/2014
 * Modified: 10/3/2014
 */
public class Window
{
   //The constant height as H
   public static final int H = 3;
   
   public static void main(String[] args) {
      window(3);
   }
   
   public static void window(int H) {
      row("+", "=");
      for(int i = 0; i < H; i++) {
         row("|", " ");
      }
      row("+", "=");
      for(int i = 0; i < H; i++) {
         row("|", " ");
      }
      row("+", "=");
   }
   
   //Generate a row
   public static void row(String corner, String space) {
      //Repeat twice
      for(int i = 0; i < 2; i++) {
         //Open the slit row with corner
         System.out.print(corner);
         //for each row placement that is not a corner 
         for(int r = 0; r < H; r++) {
            //Print space
            System.out.print(space);
         }
      }
      //Close the window slit
      System.out.println(corner);      
   }
}