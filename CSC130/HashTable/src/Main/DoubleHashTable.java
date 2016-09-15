package Main;

public class DoubleHashTable extends HashTable {
	// Constructor
	public DoubleHashTable(int size) {
		super(size);
	}
	
	@Override
	protected int hash(short x, int i) {
		// Calculate the r hash function, h2
		int r = /*8191*/ 7; // Largest Prime Number Less than the table size
		int h2 = (r - (x % r));
		return ((x % size) + (i * h2)) % size;
	}
}