import java.util.Random;

/** 
 * Min Heap Driver used to test and compare heaps
 */
public class HeapDriver {
	public static void main(String... args) {
		Random r = new Random();
		
		// Heap 1
		BinaryHeap h1 = new BinaryHeap(100);
		System.out.println("H1 Unsorted:");
		for(int id = 1; id <= 100; id++) {
			// Generate and insert the nice value of the id into the heap
			int n = r.nextInt(40);
			h1.insert(n);
			System.out.print(n + " ");
		}
		System.out.println();
		// Sorted
		h1.buildHeap();
		System.out.printf("H1 Sorted:%n%s%n%n", h1);
		
		// Heap 2
		BinaryHeap h2 = new BinaryHeap(100);
		// Insert all elements from h1 to h2
		while(h1.getSize() > 0) h2.insert(h1.removeMin());
		System.out.printf("H1: %s%n", h1); 
		System.out.printf("H2:%n%s%n", h2); 
	}
}