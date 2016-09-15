public class PrintTriangle
{
   public static void main(String[] args) {
      printTriangleType(5, 7, 7);
      printTriangleType(6, 6, 6);
      printTriangleType(5, 7, 8);
      printTriangleType(12, 18, 12);
   }
   
   public static void printTriangleType(int a, int b, int c) {
       //The triangle type as a string
       String t = "";
       //The side equality count
       int s = 0;
       
       //Check for the type of triangle
       if(a == b) {
           s++;
       }
       
       if(a == c) {
           s++;
       }
       
       if(b == c) {
           s++;
       }
       
       //What triangle do we have?
       //According to the transative property, if a = b, and b = c then a = c
       //This is why we cannot have s = 2
       switch(s) {
           case 0: t = "scalene"; break;
           case 1: t = "isosceles"; break;
           case 3: t = "equilateral"; break;
       }
       //Return the triangle
       System.out.println(t);
   }
}