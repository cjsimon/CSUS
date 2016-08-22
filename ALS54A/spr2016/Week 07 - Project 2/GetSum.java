import java.util.Scanner;

public class GetSum {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		double score = getScores(kb);
		
		// Using println
		System.out.println("Your score is: " + score);
		
		// Using printf - Prints to 2 decimal places
		System.out.printf("Your score is: %.2f", score);
	}

	public static double getScores(Scanner kb) {
		int sum = 0;
		
		System.out.print("How many integers? ");
		int times = kb.nextInt();
		kb.nextLine();
		
		System.out.print("Your name? ");
		String name = kb.nextLine();
		
		for(int i = 1; i <= times; i++) {
			System.out.print("Next Integer? ");
			int num = kb.nextInt();
			
			if(num % 2 == 0)
			{
				sum = sum + num;
			}
		}
		return sum;
	}
}