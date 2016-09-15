/**
 * Finds the largest subsequent product of a set of integers
 */
public class LargestSubsequentProduct {
	private int[] a;
	private int start;
	private int end;
	private int largest;
	
	/**
	 * Constructors
	 */
	public LargestSubsequentProduct() {}
	public LargestSubsequentProduct(int[] a) {
		this.a = a;
	}
	public LargestSubsequentProduct(int[] a, int start, int end) {
		this.a     = a;
		this.start = start;
		this.end   = end;
	}
	
	/**
	 * Main method that allows for a set of integers
	 * to be passed through the command line
	 * @param args [A set of space delimited integers]
	 */
	public static void main(String[] args) {
		LargestSubsequentProduct product = new LargestSubsequentProduct();
		if(args.length > 0) {
			// Setup the LargestProduct set based on the number of arguments passed in
			product.a = new int[args.length];
			
			// Parse each argument and add it to the LargestProduct array, product.a
			for(int i = 0; i < args.length; i++) {
				try {
					product.a[i] = Integer.parseInt(args[i]);
				} catch(NumberFormatException e) {
					// Integer format error containing the badly parsed string
					System.out.printf(
						"Error parsing integer #%d: '%s'%nIt will not be included in the set%n",
						i + 1,
						args[i]
					);
				}
			}
			int t = product.largestProduct(product.a, 0, product.a.length - 1);
			System.out.println(t);
		} else {
			System.err.println("Please specify a set of integers!");
		}
	}
	
	public static int largestProduct(int[] n, int start, int end) {
		// Base case: One element set
		// If only one element exists in the set,
		// it is known to be the max product,
		// so simply return that element.
		if(start == end) return n[start];
		
		// The mid index, representing where the set is to be split.
		// If the set is an odd number, the extra element will be included on the left set.
		int mid = (start + end) / 2;
		
		// After splitting the set, make a call to each side of the problem recursively,
		// which will stop once the base case is met, allowing for the solutions of the
		// subproblems to propagate back up the stack.
		//
		// The leftSet begins at index start and ends at index mid,
		// while the rightSet begins at mid + 1 and ends at end
		//
		// Outcome 1: Largest product is composed of set completely on the left side
		int leftMaxProduct = largestProduct(n, start, mid);
		// Outcome 2: Largest product is composed of set completely on the right side
		int rightMaxProduct = largestProduct(n, mid + 1, end);
		
		// Outcome 3: The largest product contains elements from both the left and the right of the set,
		// meaning that the largest set at least passes through both middle elements, n[mid] and n[mid + 1]
		int midMaxProduct;
		
		// Initialize the left and right middleProducts at the first element of each respective set
		int leftMidProduct = n[mid];
		int rightMidProduct = n[mid + 1];
		
		// Keep track of the greatest and lowest products
		// of both the left and right side of the split sets.
		// Initialize the left and right products as the first element
		// of the respective sets, (n[mid] and n[mid + 1]).
		//
		// These values can instead be initialized to the MIN and MAX Integer values, Integer.MIN_VALUE,
		// so that the for loops below can start with the first elements of the left and right sets.
		int greatestLeftMidProduct, leastLeftMidProduct, greatestRightMidProduct, leastRightMidProduct;
		greatestLeftMidProduct = leastLeftMidProduct = leftMidProduct;
		greatestRightMidProduct = leastRightMidProduct = rightMidProduct;
		
		// Short circut zero.
		// If either of the middle elements, n[mid], n[mid + 1] are zero,
		// then the largest set cannot include elements from both the left and the right.
		// because multiplying by 0 will reduce the midMaxProduct to zero.
		// As a result, we know that the midMaxProduct is equal to zero.
		if(leftMidProduct == 0 || rightMidProduct == 0) {
			midMaxProduct = 0;
		} else {
			// Left side of middle
			// Starting from the next element after the left middle element, n[mid - 1],
			// and going to the start:
			for(int i = mid - 1; i >= start; i--) {
				// Short circut zero.
				// Since the leftMidProduct will equal zero if multiplied by 0,
				// we know that zero should never be part of the set,
				// as it will always result in a value less than the current leftMidProduct.
				// Therefore, we can safely assume that anything comming after the zero inclusive,
				// can not be included in the set, which means that we can break the loop
				// to prevent from processing these values. 
				// Zero can only explicitly be assigned through the base case,
				// which would require a set of numbers including at least one zero and
				if(n[i] == 0) break;
				
				// So long as the current number, n[i], isn't zero,
				// multiply the current number, n[i], to the leftMidProduct.
				leftMidProduct *= n[i];
				
				// Store the greatest and least leftMidProducts, so that they may be later compared
				// To get the greatest combined product from both the left and right midProducts.
				//
				// The least product, which might be negative, when multiplied with the least product
				// of the other side, which also might be negative, can produce a product that might be
				// greater than if the greatestProducts were multiplied together.
				// For this reason all four outcomes will be multipled together and compared for the greatest value.
				if(leftMidProduct > greatestLeftMidProduct) greatestLeftMidProduct = leftMidProduct;
				if(leftMidProduct < leastLeftMidProduct) leastLeftMidProduct = leftMidProduct;
			}
			// Right side of middle
			// Starting from the right middle element, n[mid + 1],
			// and going to the start:
			for(int i = mid + 2; i <= end; i++) {
				// Short circut zero
				if(n[i] == 0) break;
				
				rightMidProduct *= n[i];
				
				// Store the greatest and least rightMidProducts
				if(rightMidProduct > greatestRightMidProduct) greatestRightMidProduct = rightMidProduct;
				if(rightMidProduct < leastRightMidProduct) leastRightMidProduct = rightMidProduct;
			}
			
			// Compare the two possible combinations based on the left and right greatest and least midProducts.
			// In the event that the leastLeftMidProduct and leastLeftMidProduct are negative, this combination
			// might be greater than the product of the greatestLefttMidProduct and greatestRightMidProduct.
			int negativeProduct = leastLeftMidProduct * leastRightMidProduct;
			// These other two cases will always be between or equal to the greatest or least products,
			// so they don't need to be included.
			//int leastGreatestProduct = leastLeftMidProduct * greatestRightMidProduct;
			//int greatestLeastProduct = greatestLeftMidProduct * leastRightMidProduct;
			int posativeProduct = greatestLeftMidProduct * greatestRightMidProduct;
			// The midMaxProduct will either be the product of two negative numbers,
			// or the product of two posative numbers.
			midMaxProduct = max(negativeProduct, posativeProduct);
		}		
		// Return the max product of the three different outcomes
		return max(leftMaxProduct, rightMaxProduct, midMaxProduct);
	}
	
	/**
	 * Gets the greatest int given a set of integers
	 * @param  a 	[The set up integers]
	 * @return int  [The greatest integer]
	 */
	public static int max(int... a) throws IllegalArgumentException {
		// Empty Set Exception 
		if(a.length == 0) throw new IllegalArgumentException();
		// Shorthand 1 element
		if(a.length == 1) return a[0];
		
		// Start with the smallest integer possible
		int greatest = Integer.MIN_VALUE;
		// For each int, n, if n is greater than the greatest integer,
		// then by definition, n is now the greatest integer
		for(int n : a) if(n > greatest) greatest = n;
		return greatest;
	}
	
	/**
	 * Prints the indexes and value of the largestProduct
	 * @return String [The largestProduct, start and end indexes]
	 */
	public String toString() {
		return String.format(
			"Largest Product: %d%nStart Index: %d%nEnd Index: %d%n",
			largest,
			start,
			end
		);
	}
}