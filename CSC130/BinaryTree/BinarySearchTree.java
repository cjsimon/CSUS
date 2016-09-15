/** Binary Search Tree serving as a sorted binary tree */
public class BinarySearchTree extends BinaryTree {
	/**
	 * Gets the height of a specified subtree, t
	 * If a null subtree has a height of -1
	 * @param  t [The specified subtree]
	 * @return   [The height of the given subtree, t]
	 */
	protected int height(Node t) {
		if(t == null) return -1;
		return max(height(t.left), height(t.right)) + 1;
	}
	
	/**
	 * Gets the max value given two integers
	 * @param  a
	 * @param  b
	 * @return int
	 */
	protected int max(int a, int b) {
		if(b > a) return b;
		return a;
	}
	
	/**
	 * Binary Search Tree Find Implementation.
	 * See BinaryTree for documentation on insertion
	 * @param  t [The input tree]
	 * @param  x [The desired val to search for]
	 * @return   [Node containing val x]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node find(Node t, int x) {
		// Recursively traverse to either the to next left or right child node,
		// depending on whether the value being searched for is respectively
		// less than or greater than the current child node.
		// If the node containing the desired x value does not exist,
		// a null node will be returned due to the structure of the code.
		if(x < t.val) return find(t.left, x);
		if(x > t.val) return find(t.right, x);
		// Return the node containing the val that is being searched for
		return t;
	}
	
	/**
	 * Binary Search Insertion Implementation.
	 * See BinaryTree for documentation on insertion
	 * @param  t [The input subtree]
	 * @param  x [The desired val to insert]
	 * @return   [The new node]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node insert(Node t, int x) {
		// Create a new node upon reaching a null child in the traversal,
		// allowing for the previous recursive calls to be propagated back
		// up the stack, so that they may be assigned to their respective
		// left and right parent callers. This is the corner case.
		// This statement also serves as the base case for an empty tree,
		// as it will create a new node for insertion upon the null tree
		if(t == null) return t = new Node(null, null, x);
		//if(t == null) return new Node(null, null, x);
		// Recursively traverse through the tree, assigning the left or
		// right child with the result of the recursive call
		if(x < t.val) t.left = insert(t.left, x);
		else if(x > t.val) t.right = insert(t.right, x);
		// If the x val already exists, return that node containing that value
		else return t;
		// Failsafe return
		return t;
	}
	
	/**
	 * Binary Search Tree Removal Implementation.
	 * See BinaryTree for documentation on removal
	 * @param  t [The input subtree]
	 * @param  x [The desired val to remove]
	 * @return   [The node removed]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node remove(Node t, int x) {
		// Base Case
		if(t == null) return null;
		// Recursively traverse through the tree, assigning the left or
		// right child with the result of the recursive call
		if(x < t.val) t.left = remove(t.left, x);
		else if(x > t.val) t.right = remove(t.right, x);
		// Otherwise, if the current node contains the val being removed
		else {
			// If that node, t, containing val x, has two children
			if(t.left != null && t.right != null) {
				// Find the lowest val in the right child subtree
				t.val = findMin(t.right).val;
				t.right = remove(t.right, t.val);
			// If that node t containing x does not have two children,
			// return the single left or right child element
			// accordingly, or null if no children exist
			} else return t.left != null ? t.left : t.right;
		}
		// Failsafe return
		return null;
	}
	
	/**
	 * Rotates a given subtree, k2 to the left,
	 * making k2 the new root with k1 and k3 as it's
	 * respective left and right children
	 * @param  k2 [The input subtree]
	 * @return    [The rotated subtree]
	 */
	protected Node rotateToLeft(Node k2) {
		Node k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		// Recalculate the heights of k2 and k1, which are both dependant
		// upon the greater of their respective left and right children hieghts 
		k2.height = height(k2); //max(height(k2.left), height(k2.right));
		k1.height = height(k1); //max(height(k1.left), height(k1.right));
		return k1;
	}
	
	/**
	 * Rotates a given subtree, k2 to the right,
	 * making k2 the new root with k1 and k3 as it's
	 * respective left and right children
	 * @param  k2 [The input subtree]
	 * @return    [The rotated subtree]
	 */
	protected Node rotateToRight(Node k2) {
		Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		// Recalculate the heights of k2 and k1, which are both dependant
		// upon the greater of their respective left and right children hieghts 
		k2.height = height(k2); //max(height(k2.left), height(k2.right));
		k1.height = height(k1); //max(height(k1.left), height(k1.right));
		return k1;
	}
	
	/**
	 * Rotates a given subtree, k3, to the left twice
	 * @param  k3 [The input subtree]
	 * @return    [The doubly rotated subtree]
	 */
	protected Node doubleRotateLeft(Node k3) {
		k3.right = rotateToRight(k3.right);
		return rotateToLeft(k3);
	}
	
	/**
	 * Rotates a given subtree, k3, to the right twice
	 * @param  k3 [The input subtree]
	 * @return    [The doubly rotated subtree]
	 */
	protected Node doubleRotateRight(Node k3) {
		k3.left = rotateToLeft(k3.left);
		return rotateToRight(k3);
	}
}