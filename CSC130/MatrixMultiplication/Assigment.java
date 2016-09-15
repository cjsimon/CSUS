/* Mugendi Gitonga
	Spring 2016
	CSC 130 _ AssignmentOne.java
	Due 02/26/2016
	
	******* A Program description **********
Programmming Assigment 1
Source code implementing Strassen's algorithm using divide and conquer technique
Time complexity analysis of the implementation. 
*/ 
import java.util.Scanner; // for scanner
public class Assigment {
	/*
	In the main we are going to create the array, call Strassen and output the result
	*/
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); // obtain values using scanner
		System.out.println("This program implements Strassen's Divide & Conguer algorithm.");
		/* created and initialized array 2D arrays: A and B */
 		int n = 4;
		int A[][] = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		}; 
		int B[][] = {
			{10,11,12,13},
			{14,15,16,17},
			{18,19,20,21},
			{22,23,24,25}
		};
		
		// Matrix C holds the result of the output
		int C[][] = new int[n][n];
		C = Strassen(A, B, n);
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-1;j++){
				System.out.println(C[i][j]);
			}
		}
	}
	/*
	Method that performs the recursive functions
	Input a double array each for A and B
	*/
	public static int[][] Strassen(int A[][], int B[][], int n){
		/* 
		Step 1:   
		Base case for the recursive function. Since the base case is going to be at the first then
		we can just multiply the value since it will always be so 
		Initialize a 2D array C
		*/
		int C[][] = new int[n][n];
		if (n == 1){	
			C[0][0] = A[0][0] * B[0][0];   
			return C;
		}
		/*
		Step 2:
		Created a double array with a size n/2
		*/
		int A11[][] = new int[n/2][n/2];
		int A12[][] = new int[n/2][n/2];
		int A21[][] = new int[n/2][n/2];
		int A22[][] = new int[n/2][n/2];
			
		int B11[][] = new int[n/2][n/2];
		int B12[][] = new int[n/2][n/2];
		int B21[][] = new int[n/2][n/2];
		int B22[][] = new int[n/2][n/2];
		
		int start = 0;
		int mid = n / 2;
		int end = n - 1;
		
		split(A, A11, start, mid - 1, start, mid - 1);
		split(A, A12, start, mid - 1, mid, end);
		split(A, A21, mid, end, start, mid - 1);
		split(A, A22, mid, end, mid, end);
		
		split(B, B11, start, mid - 1, start, mid - 1);
		split(B, B12, start, mid - 1, mid, end);
		split(B, B21, mid, end, start, mid - 1);
		split(B, B22, mid, end, mid, end);      
		
		/*
		Steps 3 - 10:
		Recursive calls to perform p1....p7
		method calls subtract, add used to define the input to the Strassen call
		*/
		int P1[][] = Strassen(A11, subtract(B12,B22), n/2);
		int P2[][] = Strassen(add(A11,A12),B22, n/2);
		int P3[][] = Strassen(add(A21,A22),B11, n/2);
		int P4[][] = Strassen(A22,subtract(B21,B11), n/2);
		int P5[][] = Strassen(add(A11,A22),add(B11,B22), n/2);
		int P6[][] = Strassen(subtract(A12,A22), add(B21,B22), n/2);
		int P7[][] = Strassen(subtract(A11,A21), add(B11,B12), n/2);
		////////////////////////////////////////////////////////////////
		int C11[][]  = subtract(add(P5, P4),(add(P2, P6)));
		int C12[][]  = add(P1, P2);
		int C21[][]  = add(P3, P4);
		int C22[][]  = subtract(add(P1,P5), subtract(P3, P7));
		/*
		Step 11: Resotre
		Write 4 different for loops to put c11, c12, c21, c22
		Keep in mind the four diffrent corners: c11 is the upper left c12 upper right, c21 is bottom left
		and c22 is bottom right
		*/
		for(int i = 0; i < n/2;i++){
			for(int j = 0; j < n/2;j++){
				C[i][j] = C11[i][j]; 
			}
		}
		for(int i = 0; i < n/2;i++){
			for(int j = n/2; j <= n-1;j++){
				C[i][j] = C12[i][j];
			}
		}
		for(int i = n/2; i <= n-1;i++){
			for(int j = 0; j < n/2;j++){
				C[i][j] = C21[i][j];
			}
		}
		for(int i = n/2; i <= n-1; i++){
			for(int j = n/2; j <= n-1; j++){
				C[i][j] = C22[i][j];
			}
		}
		return C; 
	}
	
	/*
	Fill in the values into the matirx
	Were are going to use the fact that we do not need to return arrays and they are updated with the changes
	that are made below.
	*/
	public static void split(int A[][], int Asub[][], int column, int columnEnd, int row, int rowEnd) {
		for (int i = column; i <= columnEnd; i++) {
			for (int j = row; j <= rowEnd; j++) {
				Asub[i - column][j - row] = A[i][j];
			}
		}
	}
	public static void restore(int A[][], int Asub[][], int column, int columnEnd, int row, int rowEnd) {
		for (int i = column; i <= columnEnd; i++) {
			for (int j = row; j <= rowEnd; j++) {
				A[i - column][j - row] = Asub[i][j];
			}
		}
	}

	/*
	The add method is used to add two matrices together. The add method take in two 2D arrays and returns
	a temp 2D array that is the result.
	The size of the result, temp[][] is determined: #of rows = A[0].length and #of columns = A.length
	*/
	public static int[][] add( int A[][], int B[][]){
		int rowA = A[0].length; // row size
		int columnA = A.length; // column size
		int rowB = B[0].length;
		int columnB = B.length;
		int temp[][] = new int[rowA][columnA];

		if (rowA == rowB && columnA == columnB) {
			//int temp[][] = new int[rowA][columnA];
			for (int i = 0; i < columnA; i++) {
				for (int j = 0; j < rowA; j++) {
					temp[i][j] = A[i][j] + B[i][j];
				}
			}
			//return temp;
		}
		return temp;
	}
	public static int[][] subtract( int A[][], int B[][]){
		int rowA = A[0].length; // row size
		int columnA = A.length; // column size
		int rowB = B[0].length;
		int columnB = B.length;
		int temp[][] = new int[rowA][columnA];

		if (rowA == rowB && columnA == columnB) {
			//int temp[][] = new int[rowA][columnA];
			for (int i = 0; i < columnA; i++) {
				for (int j = 0; j < rowA; j++) {
					temp[i][j] = A[i][j] - B[i][j];
				}
			}
			//return temp;
		}
		return temp;
	}
}
