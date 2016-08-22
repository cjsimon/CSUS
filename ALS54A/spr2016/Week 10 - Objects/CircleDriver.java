import java.util.*;
public class CircleDriver
{
   public static void main(String[] args)
   {
      /*Circle c1 = new Circle();
      Circle c2 = new Circle(7,5,4);
      double area = c2.area();
      //outputs the information about the object 
      System.out.println(c2);
      System.out.println(c2.toString());
      
      c1.setRadius(4);
      
      System.out.println(c2.toString());
      double sum = c1.getRadius() + c2.getRadius();
      System.out.println(sum);*/
      //array of circle
      Scanner kb = new Scanner(System.in);
      Circle[] circles = new Circle[2];
      System.out.println(Arrays.toString(circles));
      for(int i =0; i < 2; i++)
      {
          System.out.println("Enter the value for radius, x and y:");
          double r  = kb.nextDouble();
          double x = kb.nextDouble();
          double y = kb.nextDouble();
          Circle c = new Circle(r,x,y);
          circles[i] = c;
      } 
      System.out.println(Arrays.toString(circles));   
      
      
   }
 }  
   