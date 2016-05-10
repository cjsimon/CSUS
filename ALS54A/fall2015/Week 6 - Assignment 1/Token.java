class Token {
	public static void main(String[] args) {
		String s = "1 + 2;";
		System.out.println(isValidFormat(s));
	}
	
	public static boolean isValidFormat(String exp) {
		String operand1 = token(exp);
		exp = removeToken(exp);
		exp = removeToken(exp);
		String operation = token(exp);
		exp = removeToken(exp);
		exp = removeToken(exp);
		String operand2 = token(exp);
		exp = removeToken(exp);
		String semicolon = token(exp);
		
		if(validNumber(operand1) && validNumber(operand2) && validOperation(operation) && semicolon.equals(";")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validNumber(String operand) {
		boolean isValid;
		switch(operand) {
			case "0": 
				isValid = true;
				break;
			case "1": 
				isValid = true;
				break;
			case "2": 
				isValid = true;
				break;
			case "3": 
				isValid = true;
				break;
			case "4": 
				isValid = true;
				break;
			case "5": 
				isValid = true;
				break;
			case "6": 
				isValid = true;
				break;
			case "7": 
				isValid = true;
				break;
			case "8": 
				isValid = true;
				break;
			case "9": 
				isValid = true;
				break;
			default:
				isValid = false;
				break;
		}
		return isValid;
	}
	
	public static boolean validOperation(String operation) {
		// Keep the status of the validity in a variable
		boolean isValid;
		
		// Is operation one of the following symbols? (+ - * / ^ %)
		switch(operation) {
			case "+":
				isValid = true;
				break;
			case "-":
				isValid = true;
				break;
			case "*":
				isValid = true;
				break;
			case "/":
				isValid = true;
				break;
			case "^":
				isValid = true;
				break;
			case "%":
				isValid = true;
				break;
			default:
				// If the symbol is any other character than (+ - * / ^ %)
				isValid = false;
				break;
		}
		// Return the boolean, isValid, which will be true
		// if the operand is valid, and false if it isn't valid
		return isValid;
	}
	
	public static String token(String s) {
		// Get the first character from the string, s
		String firstCharacter = "" + s.charAt(0);
		// Return that first character
		return firstCharacter;
	}
	
	public static String removeToken(String s) {
		// Give us the substring of s from indexes 1 through 5.
		s = s.substring(1, s.length()); //_+_5;
		return s;
	}
}