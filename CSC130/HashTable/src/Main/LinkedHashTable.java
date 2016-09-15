package Main;

public class LinkedHashTable implements Hash {
	// Node storing data in the hash table
	public class Node {
		short data;
		Node nextNode;
		
		public Node(short data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	}
	
	// The size of the table
	int size;
	// HashTable
	Node[] hashTable;
	
	// Constructor
	public LinkedHashTable(int size) {
		this.size = size;
		hashTable = new Node[size];
		// Create the blank nodes as pointers
		for(int i = 0; i < size; i++) {
			hashTable[i] = new Node((short)0, null);
		}
	}
	
	// Hash Function
	private int hash(short x) {
		return x % size;
	}
	
	// Insert
	public void insert(short x) {
		int index = hash(x);
		Node n = hashTable[index];
		
		// Traverse through the existing nodes, unitl we find the null node.
		// Create a new Node(x, null) in the null node.
		while(n.nextNode != null) {
			n = n.nextNode;
		}
		n.nextNode = new Node(x, null);
	}
	
	// Remove
	public boolean remove(short x) {
		int index = hash(x);
		Node n = hashTable[index];
		
		// So long as there is a next node that exists
		while(n.nextNode != null) {
			// If the current node contains that data that we are looking for
			if(n.nextNode.data == x) {
				// Remove that node.
				// Reassign the next node, or pointer, of the current node
				// to the node after the one that is being removed
				n.nextNode = n.nextNode.nextNode;
				return true;
			}
			// Traverse to the next node
			n = n.nextNode;
		}
		return false;
	}
	
	// Find
	public boolean find(short x) {
		int index = hash(x);
		Node n = hashTable[index];
		
		while(n.nextNode != null) {
			if(n.nextNode.data == x) {
				// We found it!
				//return n.nextNode; // Object vs Boolean return type
				return true;
			}
			// Traverse to the next node
			n = n.nextNode;
		}
		// Node not found. Return null/false
		return false;
	}
}