package Main;
public class HashTable implements Hash {
	// The size of the table
	int size;
	// Hash Table
	int[] hashTable;
	// Hash Count
	int[] c;
	// Hash Value
	int[] h;
	
	// Keep track of the number of elements currently in the hashtable
	int elementCount = 0;
	
	// Constructor
	public HashTable(int size) {
		this.size = size;
		hashTable = new int[size];
		// The number of hashTable elements with a hash value of the matching index
		c = new int[size];
		// The hash value of the hashTable element
		h = new int[size];
		
		// Fill the array with null values, represented as -1
		for(int i = 0; i < size; i++) {
			hashTable[i] = -1;
		}
	}
	
	// Hash Function to be ovverridden
	protected int hash(short x, int i) {
		return 0;
	}
	
	// Insert
	public void insert(short x) /*throws SizeLimitExceededException*/ {
		// Base Case: elementCount cannot exceed the size of the hashtable
		//if(elementCount >= size) throw SizeLimitExceededException();
		
		// The offset count, starting from 0
		int i = 0;
		
		// Keep searching for an available index until one is found
		int index;
		// Check if the firstIndex has been reached before,
		// which signifies a repeating pattern.
		// Keep a running count of how many times it has been reached
		int firstIndex = hash(x, i);
		int firstIndexCount = 0;
		do {
			index = hash(x, i++);
			// For some hash tables that utilize a probe offset
			// of greater complexity than linear probing, it is
			// possible that, in certain cases, a value will not
			// be able to be inserted, even though there is an
			// open space availabe, simply because the offset skips
			// this open spot in such a pattern that it never reaches
			// that position in the table. If this happens, in order
			// to prevent an overflow, simply prevent the element from
			// being inserted by returing. This is done by checking
			// if a looping offset pattern has formed, by checking if
			// the offset reaches an index for the second time, which
			// signifies that there is no possible open space for x
			if(index == firstIndex && firstIndexCount++ > 1) return;
		} while(hashTable[index] != -1);
		// This index is open. Add x to it.
		hashTable[index] = x;
		
		// Calculate the original hash value for x
		int originalHash = (x % size);
		// Increase the number of x hash values, located at c[originalHash] 
		c[originalHash]++;
		// Store the originalHash of x
		h[index] = originalHash;
		// Add the element to the count
		elementCount++;
	}
	
	// Remove
	public boolean remove(short x) {
		// The offset count, starting from 0
		int i = 0;
		
		// Get the hash and c value of the number we are trying to find, x
		// This also serves as the original index location of x, without any collisions
		int findHash = x % size;
		// C represents the max number of times we will search for x,
		// only counting values with the same hash, h
		int findC = c[findHash];
		
		// The hCount represents the number of h values that we have checked
		int hCount = 0;
		while(hCount <= findC) {
			// Calculate the current index using the hash function
			int index = hash(x, i++);
			if(h[index] == findHash) {
				// Are these the droids we're looking for?
				if(hashTable[index] == x) {
					// Yes, yes they are...
					// Take them off the premises.
					// Remove the element
					hashTable[index] = -1;
					return true;
				}
				// Increment the hCount, representing that we have checked
				// another value whose origianl hash value matches that of x
				hCount++;
			}
		}
		return false;
	}
	
	// Find
	public boolean find(short x) {
		// The offset count, starting from 0
		int i = 0;
		
		// Get the hash and c value of the number we are trying to find, x
		// This also serves as the original index location of x, without any collisions
		int findHash = x % size;
		// C represents the max number of times we will search for x,
		// only counting values with the same hash, h
		int findC = c[findHash];
		
		// The hCount represents the number of h values that we have checked
		int hCount = 0;
		while(hCount <= findC) {
			// Calculate the current index using the hash function
			int index = hash(x, i++);
			if(h[index] == findHash) {
				// Are these the droids that we are looking for?
				if(hashTable[index] == x) {
					// We found it!
					return true;
				}
				// Increment the hCount, representing that we have checked
				// another value whose origianl hash value matches that of x
				hCount++;
			}
		}
		// We have exceeded the total number of c values,
		// meaning that we have checked all values who's
		// original hash value matches that of x
		// Therefore, x is not located in the hashTable
		return false;
	}
}