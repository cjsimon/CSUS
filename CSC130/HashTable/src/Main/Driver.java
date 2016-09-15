package Main;

import java.util.Random;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Driver {
	public static void main(String... args) {
		int tableSize  = 8209 /*10*/;
		int sampleSize = 8192 /*7*/; // Largest prime number less than the tableSize
		int removeSize = 1000 /*5*/;
		
		// Generate the numbers to insert into the hash table
		Random r = new Random();
		short a[] = new short[sampleSize];
		for(int i = 0; i < a.length; i++) {
			a[i] = (short)r.nextInt(Short.MAX_VALUE + 1);
		}
		
		// Generate indexes to remove from the insert array, a
		int[] randRmv = new int[removeSize];
		for(int i = 0; i < removeSize; i++) {
			randRmv[i] = r.nextInt(sampleSize);
		}
		
		// Create and time the following hash linked lists
		LinkedHashTable		lkHash = new LinkedHashTable(tableSize);
		LinearHashTable		lnHash = new LinearHashTable(tableSize);
		QuadraticHashTable	qdHash = new QuadraticHashTable(tableSize);
		DoubleHashTable		dbHash = new DoubleHashTable(tableSize);
		
		System.out.printf(
			"Table Size:        %d%n"	+ 
			"Sample Size:       %d%n"	+
			"Elements Removed:  %s%n"	+
			"Linked Hash:       %s%n"	+
			"Linear Hash:       %s%n"	+
			"Quadratic Hash:    %s%n"	+
			"Double Hash:       %s%n",
			tableSize,
			sampleSize,
			Arrays.toString(randRmv),
			time(a, randRmv, lkHash, true),
			time(a, randRmv, lnHash, false),
			time(a, randRmv, qdHash, false),
			time(a, randRmv, dbHash, false)
		);
	}
	
	/** Calculate the time taken to run the given Hash Table */
	public static String time(short[] a, int[] randRmv, Hash hash, boolean countDuplicates) {
		double startTime = System.nanoTime();
		
		// Insert
		for(int i = 0; i < a.length; i++) {
			hash.insert(a[i]);
		}
		
		// Remove
		for(int i = 0; i < randRmv.length; i++) {
			hash.remove(a[randRmv[i]]);
		}
		
		// Find
		int count = 0;
		for(int i = a.length-1; i >= 0; i--) {
			// Count the number of elements found
			if(!hash.find(a[i])) count++;
		}
		
		double endTime = System.nanoTime();
		double duration = endTime - startTime;
		
		if(countDuplicates) {
			// Find the number of duplicate elements removed
			System.out.printf("Duplicate Removes: %d%n", randRmv.length - count);
		}
		
		// Return the total running time in seconds
		return (new DecimalFormat("#.##########").format(duration/1000000000) + " Seconds");
	}
}