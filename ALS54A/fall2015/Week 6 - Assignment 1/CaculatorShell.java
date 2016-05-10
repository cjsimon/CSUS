import java.util.Scanner;
public class CaculatorShell
{
	 // the code for the main method is complete. once you implement all other methdos you can the program
	public static void main(String[] args)
	{
		
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Welcome to my calculator website");
		
		description();
		for(int count =1; count <= 10; count++)
		{
			System.out.print("Enter your expression:");
			String exp = kb.nextLine();
			char semi = exp.charAt(exp.length() -1);
			if(validFormat(exp) && semi != -1)
			{
				String op1 = token(exp);
				
				exp = removeToken(exp);
				
				String operation = token(exp);
				exp = removeToken(exp);
				
				String op2 = token(exp).substring(0,exp.length() -1);
							 //first we need to check if it is a valid character 0-9
				if (validCharacter(op1) && validCharacter(op2))
				{
					int operand1 = Integer.parseInt(op1);
					int operand2 = Integer.parseInt(op2);
								//checking to see if it is a single digit number
					if (validOp(operand1) && validOp(operand2) && validOperation(operation))
					{
						int result = calculate(operand1, operand2, operation);
						output(operand1, operand2, operation, result);	 		             
					}	
					else
					{
						System.out.println("please check your expression"); 
						description();  
					}
				}
				else
				{
					System.out.println("please check your expression"); 
					description();
				}     
				
			}
			else
			{
				System.out.println("please check your expression."); 
				description(); 
			}		  
		}      
		
	}   
	
	 //****************************
	public static boolean validCharacter(String operand)
	{
			//your code
		return false;
	}  
	 //***************************** 
	public static void description()
	{
	}	
	
	 //******************************** 
	public static boolean validFormat(String expression)
	{
		boolean valid = false;
		
			 //your code
		return valid;  
		
	} 
	 //**********************************
	public static String token(String s)
	{
		//your code
		return "";
	}
	 //**************************************** 
	public static String removeToken(String s)
	{
		 //your code
		return "";
	} 
	 //***************************************
	public static boolean validOp(int num)
	{
			//your code
		return false;
	}
		//**************************************
	public static boolean validOperation(String operation)
	{
		boolean result = false;
				//your code
		return result  ;
	} 
		//************************************
	public static int calculate(int a, int b, String operation)
	{
		int result =0;
			 //your code
		return result;
	}
	//*************************************
	public static String operandDescription(int op)
	{
		 //your code
		return "";
	}				 			 			 			 			 			 			 			 			 			  	 							  
	
	//****************************************
	public static String operationDescription(String operator)
	{
		 //your code
		return "";
	}
	 //**********************************************
	public static void output(int op1, int op2, String operation, int result)
	{
			//your code
		
	}		      
}   
