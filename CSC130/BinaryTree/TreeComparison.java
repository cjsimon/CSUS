import java.util.Random;

/** Tree Comparison class used to compare execution time between the AVL and RB Trees */
public class TreeComparison {
	public static void main(String... args) {
		// The sample array with the sample size
		int size = 1000000;
		int[] n = new int[size];
		
		// Compare an AVLTree to a RBTree using an array with subsequent
		// integers from ascending, descending and shuffled order
		System.out.println("Ascending");
		ascending(n);
		compare(n);
		
		System.out.println("Descending");
		descending(n);
		compare(n);
		
		System.out.println("Shuffled");
		shuffle(n);
		compare(n);
	}
	
	/**
	 * Compares the execution time between an AVL and RB Tree
	 * given a sample set, n
	 */
	public static void compare(int[] n) {
		AVLTree avlTree = new AVLTree();
		RBTree rbTree = new RBTree();
		
		long startTime = System.currentTimeMillis();
		avlTree.insert(avlTree.root, n);
		long endTime = System.currentTimeMillis();
		float seconds = (endTime - startTime) / 1000;
		System.out.printf("AVLTree: %f%n", seconds);
		
		startTime = System.currentTimeMillis();
		rbTree.insert(rbTree.root, n);
		endTime = System.currentTimeMillis();
		seconds = (endTime - startTime) / 1000;
		System.out.printf("RBTree:  %f%n%n", seconds);
	}
	
	/**
	 * Modifies a given array to contain integers
	 * starting from 0 and ending at the array size
	 * in ascending order
	 * @param n [The input int array]
	 */
	public static void ascending(int[] n) {
		for(int i = 0; i < n.length; i++) {
			n[i] = i;
		}
	}
	
	/**
	 * Modifies a given array to contain integers
	 * starting from the array size and ending at 0
	 * in descending order
	 * @param n [The input int array]
	 */
	public static void descending(int[] n) {
		for(int i = n.length - 1; i > 0; i--) {
			n[i] = i;
		}
	}
	
	/**
	 * Modifies a given array to contain integers
	 * within 0 and the array size in a random order.
	 * This shuffle is implemented using Fisher–Yates shuffle:
	 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
	 * @param n [The input int array]
	 */
	public static void shuffle(int[] n) {
		Random r = new Random();
		for(int i = n.length - 1; i > 0; i--) {
			// Pick a random index from the range of i, and swap it
			// with the current index i, starting with the last element.
			// This allows for the current ending element to be swapped
			// with another element that hasn't been swapped yet.
			int swapIndex = r.nextInt(i + 1);
			// Store and replace the value being swapped
			int temp = n[swapIndex];
			n[swapIndex] = n[i];
			// Replace the current i value with the original
			// value of the swapIndex before it was replaced
			n[i] = temp;
		}
	}
}