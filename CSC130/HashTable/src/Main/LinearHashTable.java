package Main;
public class LinearHashTable extends HashTable {
	// Constructor
	public LinearHashTable(int size) {
		super(size);
	}
	
	@Override
	protected int hash(short x, int i) {
		return ((x % size) + i) % size;
	}
}