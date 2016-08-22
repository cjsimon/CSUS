public class Circle
{
   //instatnce varaibles
   private double radius;
   private double x;
   private double y;
   
   //constructor
   public Circle()
   {
      radius = 1;
      x = 0;
      y =0;
   }   
   public Circle(double r, double xCor, double yCor)
   {
      //radius = r;
      setRadius(r);
      x = xCor;
      y = yCor;
   }
   //*******************************
   //mutator, seeter methods , modify the state of the object
   public void setRadius(double r)
   {
      if( r > 0)
         radius = r;
   } 
   public void setX(double newX)
   {
      x = newX;
   }
   public void setY(double newY)
   {
      y = newY;
   }        
   //****************************************************
   //getter methods, return the value for the instatnce varaibles
   public double getRadius()
   {
      return radius;
   }
   public double getX()
   {
      return x;
   }
   public double getY()
   {
      return y;
   }         
   //*****************************************************
   public double area()
   {
      return Math.PI * this.radius * this.radius;
   } 
   
   public String toString()
   {
     String s = "";
     s = s + "Radius = " + radius +"\n";
     s = s + "X = " + x + "\n";
     s = s + "y = " + y;
     return s;
   }  


}