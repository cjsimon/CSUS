/** BinaryHeap class used to store and sort integer elements */
class BinaryHeap {
	// The number of children a parent can have
	protected static final int children = 2;
	// The current size of the heap, representing how much of the array is filled
	private int size;
	// The heap array containing the elements
	private int[] heap;
	
	/**
	 * Construct a BinaryHeap given a maximum size, s.
	 * Since arrays are of fixed size, the size must be set in advance.
	 * The size must be manually calculated, based upon how much of
	 * the heap array is currently filled with values.
	 * @param  s [The maximum size of the BinaryHeap]
	 */
	public BinaryHeap(int s){
		// Currently, the heap size is 0
		size = 0;
		// The max size that the heap can be
		heap = new int[s];
		// Fill the array with -1's, representing null values
		for(int i : heap) i = -1;
	}

	/**
	 * Gets the current size of the BinaryHeap
	 * @return [int]
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Gets a specific child, n, from a parent with index, i
	 * @param  i [The parent index containing the child being retrieved]
	 * @param  n [The child to get from the parent]
	 * @return   [The child index]
	 */
	private int getChild(int i, int n) {
		return (children * i) + n;
	}
	
	/**
	 * Gets the parent of a child with index, i
	 * @param  i [The index of the child whose parent is being retrieved]
	 * @return   [The parent index]
	 */
	private int getParent(int i) {
		// Depending on the number of children,
		// to get the parent index of a child, i
		// the following equation must be used.
		return (i - 1) / children;
	}
	
	/**
	 * Gets the element with the lowest value
	 * @return [The element with the lowest value]
	 */
	public int getMin() {
		return (size < 1) ? -1 : heap[0];
	}
	
	/**
	 * Sorts the heap using the heap order property.
	 * Each parent element is perculated down.
	 */
	public void buildHeap() {
		for (int i = size/2; i > 0; i--) {
			perculateDown(i);
		}
	}
	
	/**
	 * Inserts a new element, x, into the heap
	 * @param x [The value to insert]
	 */
	public boolean insert(int x){
		int originalSize = size;
		// Increase the heap size
		// while adding the new value to the array
		heap[size++] = x;
		// Fix the element order to ensure that the heap order property remains
		perculateUp(originalSize);
		return true;
	}
	
	/**
	 * Removes an element at the given index, i
	 * @param  i [The index of the element to remove]
	 * @return   [The element that was removed]
	 */
	public int remove(int i){
		int x = heap[i];
		// Replace the element at i with the last element
		heap[i] = heap[size - 1];
		size--;
		// Fix the element order to ensure that the heap order property remains
		perculateDown(i);
		return x;
	}
	public int removeMin() {
		return remove(0);
	}
	
	/**
	 * Given a child with index, i, move the element up if it's value is greater than it's parent.
	 * Recursivly repeat the process, moving that parent up to it's parent
	 * @param i [The starting child index]
	 */
	private boolean perculateUp(int i) {
		// Store the element being moved
		int tmp = heap[i];
		// So long as the beggining of the array hasn't been reached and
		// the parent value is less than it's child value at index i
		while(i > 0 && tmp < heap[getParent(i)]) {
			// Move the child to it's parent's position, at index getParent(i)
			heap[i] = heap[getParent(i)];
			// Get the index of the child's parent. Then repeat the process for the parent.
			i = getParent(i);
		}
		// Restore the element
		heap[i] = tmp;
		return true;
	}
	
	
	/**
	 * Given a parent with index, i, move the element down if it's value is lower than it's lowest child.
	 * Recursivly repeat the process, moving that child down to it's lowest child index
	 * @param i [The starting parent index]
	 */
	private boolean perculateDown(int i) {
		// Store the element being moved
		int tmp = heap[i];
		// So long as the children are located within the bounds of the heap
		while(getChild(i, 1) < size){
			// Get the smallest child
			int child = minChild(i);
			// If the parent value is smaller than that of the smallest child 
			if(heap[child] < tmp){ 
				// Replace the child with the parent value
				heap[i] = heap[child];
			// Otherwise, everything is sorted according to the heap order property
			} else break;
			// Repeat the processfor that parent's child,
			// so that it's children are compared to the property as well.
			// This is done until the children trying to be accessed are out of bounds of the heap
			i = child;
		}
		// Restore the element
		heap[i] = tmp;
		return true;
	}
	
	/**
	 * Sorts the heap by applying the heap order property
	 */
	public boolean sort() {
		return perculateDown(0);
	}
	
	/**
	 * Gets the smallest child of a parent element at index i
	 * @param  i	[The index of the parent of the children to check]
	 * @return int	[The smallest element of the parent with index, i]
	 */
	private int minChild(int i){
		// Starting with the first child, n,
		// go through each child, storing
		// one with the smallest value
		int n = 1;
		int minChild = getChild(i, n++);
		// Get the next child to compare with the current minChild
		int nextChild = getChild(i, n);
		// So long as the last child has not been reached and
		// the next child exists by still being in the bounds
		while((n <= children) && (nextChild < size)) {
			// Update the minChild if the newChild is lower than the current minChild
			if(heap[nextChild] < heap[minChild]) {
				minChild = nextChild;
			}
			// Get the value of the nextChild
			nextChild = getChild(i, n++);
		}
		return minChild;
	}
	
	/**
	 * Prints the contents of the heap
	 * @return [String]
	 */
	public String toString() {
		if(size < 1) return "Empty Heap";
		String s = "";
		s += "[";
		s += heap[0];
		for(int i = 1; i < size; i++){    
			s += ", " + heap[i];
		}
		return s + "]";
	}
}