class MatrixMultiplacation {
	
	public static void main(String[] args) {
		// Hardcoded matrices A and B with the corresponding size, n
		int n = 2;
		int[][] A = {
			{2, 4},
			{7, 5}
		};
		int[][] B = {
			{1, 4},
			{3, 9}
		};
		
		// The resulting matrices
		int[][] C = strassen(A, B, n);
	}
	
	public static int[][] strassen(int[][] A, int[][] B, int n) {
		int[][] C = new int[n][n];
		
		// Base Case: Matrices of size 1
		if(n == 1) {
			// C = A * B
			// The base case ensures that
			// A, B and C only contain one number each 
			C[0][0] = A[0][0] * B[0][0];
			return C;
		}
		
		// Split the each matrices into 4 equal parts, n/2, for both A and B
		int[][] A11 = new int[n/2][n/2];
		int[][] A12 = new int[n/2][n/2];
		int[][] A21 = new int[n/2][n/2];
		int[][] A22 = new int[n/2][n/2];
		
		int[][] B11 = new int[n/2][n/2];
		int[][] B12 = new int[n/2][n/2];
		int[][] B21 = new int[n/2][n/2];
		int[][] B22 = new int[n/2][n/2];
		
		// Populate each sub matrices with a section of the original matrices, A and B
		// The 0 based indexes determine what part of the original matrices we want to access
		int start = 0;
		int mid = n/2;
		int end = n-1;
		
		copyMatrix(A, A11, start, mid-1, start, mid-1);
		copyMatrix(A, A12, start, mid-1, mid, end);
		copyMatrix(A, A21, mid, 3, start, mid-1);
		copyMatrix(A, A22, mid, 3, mid, 3);
		
		copyMatrix(B, B11, start, mid-1, start, mid-1);
		copyMatrix(B, B12, start, mid-1, mid, end);
		copyMatrix(B, B21, mid, end, start, mid-1);
		copyMatrix(B, B22, mid, end, mid, end);
		
		// Sub matrices, p1 to p7
		int P1[][] = strassen(A11, subtract(B12, B22));
		int P2[][] = strassen(add(A11, A12), B22);
		int P3[][] = strassen(add(A21, A22), B11);
		int P4[][] = strassen(A22, subtract(B21, B11));
		int P5[][] = strassen(add(A11, A22), add(B11, B22));
		int P6[][] = strassen(subtract(A12, A22), add(B21, B22));
		int P7[][] = strassen(subtract(A11, A21), subtract(B11, B12));
		
		// According to Strassen's equations for p,
		// place the results of the p sub matrices into the resulting matrix, C
		int[][] C11 = subtract(add(P5, P4), add(P2, P6));
		int[][] C12 = add(P1 + P2);
		int[][] C21 = add(P3, P4);
		int[][] C22 = subtract(add(P1, P5), subtract(P3, P7));
		
		// Stitch the resulting sub matrices together to form one resulting matrix, C
		stitch(C11, C12, C21, C22);
		return C;
	}
	
	/**
	 * Create a matrix, M, from a given matrix, N.
	 * 
	 * Nsub columns and rows will be populated with values in N from the respective
	 * indices, columnStart to columnEnd for columns, and rowStart to rowEnd for rows.
	 * 
	 * @param N[][]     The original matrix to get values from to store into M
	 * @param colStartN The starting column index to copy values from N
	 * @param colEndN   The ending column index to copy values from N
	 * @param rowStartN The starting row index to copy values from N
	 * @param rowEndN   The ending row index to copy values from N
	 * @param M[][]     The matrix used to store the values from N
	 * @param colStartM The starting column index to store values into M
	 * @param rowStartM The starting row index to store values into M
	 */
	public static void copyMatrix(int N[][], int colStartN, int colEndN, int rowStartN, int rowEndN,
									int M[][], int colStartM, int rowStartM) {
		// Refine the start and end bounds from N to fit into the array size of M.
		// This will truncate any values from N that are out of bounds in M.
		// If the range of M is greater than the range of N, then
		/*
		int rowRangeN = rowEndN - rowStartN;
		int colRangeN = colEndN - colStartN;
		int rowRangeM = M[0].length - rowStartM;
		int colRangeM = M.length - colStartM;
		rowEndN -= rowRangeN - rowRangeM;
		colEndN -= colRangeN - colRangeM;
		*/
		// Traverse through the elements in N, [starting and ending] at both
		// [colStartN to colEndN] and [rowStartN to rowEndN] for the column and row respectively.
		// Populate each of those values in N into M[cN][rN], where indecies cN and rN start at
		// colStartM and rowStartM and continue incrementing upwards in the array M[][].
		for(int cN = colStartN, cM = colStartM; cN <= colEndN; cN++, cM++) {
			for(int rN = rowStartN, rM = rowStartM; rN <= rowEndN; rN++, rM++) {
				// Populate the current element in M, at indices [rM][cM],
				// with the value from the original array, N, at indices [rN][cN].
				M[cM][rM] = N[cN][rN];
			}
		}
	}
}