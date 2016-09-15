import java.util.Scanner;
import java.util.Random;

public class DriverClass
{
   public static void main(String[] args)
   {    
		//arrays for testing
      int[] array_smalltobig = new int[100];
      for (int i = 0; i < array_smalltobig.length; i++)
      {
         array_smalltobig[i] = i + 1;
      }   
      
      int[] array_bigtosmall = new int[100];
      for (int i = 99; i >= 0; i--)
      {
         array_bigtosmall[i] = i + 1;
      }
      
      int[] array_randomorder = new int[100];
      Random rand = new Random();

      for (int i = 0; i < array_randomorder.length; i++)
      {
         array_randomorder[i] = rand.nextInt(100);
      }
 
      int[] array_temp;
      final double startTime;
		    
      Scanner in = new Scanner(System.in);//make Scanner object
 
      System.out.println("Select:");
      System.out.println("1.AVL Tree \n2.Red Black Tree");
      
      int input_one = in.nextInt();  
      
      if (input_one == 1)
      {
         System.out.println("Select:");
         System.out.println("1.Small to Big Array \n2.Big to Small Array Array \n3.Random Order Array");
         int input_two = in.nextInt();

         if (input_two == 1)
         {
        	array_temp = array_smalltobig;
         }	

         else if (input_two == 2)
         {
        	array_temp = array_bigtosmall;
         }	
         
         else
         {
        	array_temp = array_randomorder;
         }	

         startTime = System.nanoTime();
         AVLTree avlt = new AVLTree(); //make AVL tree object
		   
         //inserts the 
         for(int i = 0; i < array_temp.length; i++)
		   {
			   avlt.insert(array_temp[i]); 
		   }
      }
      
      else
      {
         System.out.println("Select:");
         System.out.println("1.Small to Big Array \n2.Big to Small Array \n3.Random Order Array");
         int input_two = in.nextInt();

         if (input_two == 1)
         {
        	array_temp = array_smalltobig;
         }	

         else if (input_two == 2)
         {
        	array_temp = array_bigtosmall;
         }	
         
         else
         {
        	array_temp = array_randomorder;
         }
         
         startTime = System.nanoTime();
         RBTree rbt = new RBTree(Integer.MIN_VALUE); //make AVL tree object    
		   for(int i = 0; i < array_temp.length; i++)
         {
            rbt.insert(array_temp[i]);                     
         }
         
      }   
               
      final double duration = System.nanoTime() - startTime;
      System.out.println(duration/1000000000 + " seconds");
   }
}      
    
      
