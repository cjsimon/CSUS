class TTTBoard {
	private static final int DEFAULT_SIZE = 3;
	private int size;
	private char[][] board;
	
	public TTTBoard() {
		this(DEFAULT_SIZE);
	}
	public TTTBoard(int size) {
		// Exceptions
		if(size < 1) throw new IllegalArgumentException();
		
		// Assignments
		this.size = size;
		board = new char[size][size];
		
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	/**
	 * Gets a char in the specified x, y location on the board
	 * @param  x The x location of the char to get
	 * @param  y The y location of the char to get
	 * @return   The char at (x, y)
	 */
	public char get(int x, int y) {
		return board[y][x];
	}
	public void set(int x, int y, char c) {
		board[y][x] = c;
	}
	
	private char checkVertical() {
		// For each row
		for(int x = 0; x < size; x++) {
			// Get the firstSlot of the current column
			char firstSlot = board[x][0];
			// For each column at the current row
			for(int y = 1, count = 1; y < size; y++, count++) {
				char currentSlot = board[x][y];
				// If the currentSlot is empty or it doesn't match the firstSlot,
				// then the whole column doesn't have a match. Skip to the next row.
				if(currentSlot == ' ' || currentSlot != firstSlot) break;
			}
			// If each of the currentSlots match for the current row,
			// then each slot has the same char, firstSlot
			return firstSlot;
		}
		// Failsafe
		return ' ';
	}
	
	/**
	 * Prints the board with all characters currently on the board
	 * @return  The formatted string object
	 */
	public String toString() {
		String s = "";
		if(size == 1) {
			s += (
				"+-+\n"
				+ "|" + board[0][0] + "|\n"
				+ "+-+"
			);
			return s;
		}
		
		// Fence Post bars | |
		s += bar(size, 0);
		for(int i = 1; i <= size-1; i++) {
			s += "\n";
			s += plusMinus(size);
			s += "\n";
			s += bar(size, i);
		}
		return s;
	}
	
	private String plusMinus(int size) {
		String s = "";
		// Fencepost -
		s += "-";
		// +-
		for(int i = 1; i <= size-1; i++) {
			s += "+-";
		}
		return s;
	}
	
	private String bar(int size, int column) {
		String s = "";
		// | |
		for(int i = 1; i <= size-1; i++) {
			s += board[column][i-1] + "|";
		}
		// Post char
		s += board[column][size-1];
		return s;
	}
}