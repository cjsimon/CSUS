package Main;

public class QuadraticHashTable extends HashTable {
	// Constructor
	public QuadraticHashTable(int size) {
		super(size);
	}
	
	@Override
	protected int hash(short x, int i) {
		return ((x % size) + i*i) % size;
	}
}