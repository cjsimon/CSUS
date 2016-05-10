public class Card {
	// Attributes: These represent the different states of the card.
	// Think of these as the nouns that make up the card.
	int value;
	boolean faceUp;
	
	// Constructor: The constructor helps us to create a new card.
	// This is method that is called when we use the following in the main method:
	// Card c = new Card(3, true);
	// Where c is the name of the card
	public Card(int v, boolean f) {
		// Assign each of the parameters to the attributes.
		// Using the example above this will set the attributes to the following:
		// value = 3;
		// faceUp = true;
		value = v;
		faceUp = f;
	}
	
	// Action: Flip the card
	public void flip() {
		// Flip the card
		// The following next line is the same as the lines below.
		//faceUp = !faceUp;
		if(faceUp) {
			faceUp = false;
		} else {
			faceUp = true;
		}
	}
	
	// Action: Does this card match anotherCard?
	// If the cards match: return true
	// If the cards don't match: return false
	public boolean equals(Card anotherCard) {
		// What attribute determines if a card is equal to anotherCard?
		// How do we compare that attribute?
		if(value == anotherCard.value) {
			return true;
		} else {
			return false;
		}
	}
	
	// toString: System.out.println(Card) - What are we showing to the screen?
	public String toString() {
		// If the card is faceUp
		if(faceUp) {
			// Show the value
			return value + "";
		} else {
			// Otherwise, the card must be face down (faceUp is false)
			// Show the backside of the card
			return "*";
		}
	}
}