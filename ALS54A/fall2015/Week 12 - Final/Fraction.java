public class Fraction {
	// Instance Variables (Attributes)
	int numerator;
	int denominator;
	
	// Constructor
	public Fraction(int n, int d) {
		numerator = n;
		denominator = d;
	}
	
	// ToString
	public String toString() {
		String result = numerator + "/" + denominator;
		return result;
	}
	
	// Accessors (Getters)
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	
	// Mutators (Setters)
	public void setNumerator(int n) {
		numerator = n;
	}
	public void setDenominator(int d) {
		denominator = d;
	}
	
	// Equals
	public boolean equals(Fraction anotherFraction) {
		if(numerator == anotherFraction.numerator && denominator == anotherFraction.denominator) {
			return true;
		} else {
			return false;
		}
	}
}