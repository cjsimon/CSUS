/** Binary Tree composed up of binary nodes */
public class BinaryTree {
	/** Binary Node class containing a value and two child binary nodes */
	protected class Node {
		// Node Color Definitions
		public static final boolean BLACK = true;
		public static final boolean RED = false;
		// The left and right child nodes of the current node
		Node left, right;
		// The int value associated with the current node
		int val;
		// The height of the node
		int height;
		boolean color;
		
		// Constructors
		public Node(Node left, Node right, int val, boolean color) {
			this.left  = left;
			this.right = right;
			this.val   = val;
			this.color = color;
		}
		// No color
		public Node(Node left, Node right, int val) {
			this(left, right, val, false);
		}
		// Val and Color
		public Node(int val, boolean color) {
			this(null, null, val, color);
		}
		// Children
		public Node(Node left, Node right) {
			this(left, right, 0, false);
		}
		// Val
		public Node(int val) {
			this(null, null, val, false);
		}
		// Color
		public Node(boolean color) {
			this(null, null, 0, color);
		}
		// Null
		public Node() {
			this(null, null, 0, false);
		}
	}
	
	// The encapsulated tree and root node of the BinaryTree.
	// If a subtree, t, isn't specified in a method call, this
	// base tree is used instead.
	protected Node root;
	
	/**
	 * Returns a node containing the lowest val x in a given tree, t
	 * @param  t [The input subtree]
	 * @return   [Node containing val x]
	 */
	public final Node findMin() { return findMin(this.root); }
	public final Node findMin(Node t) {
		// Corner Case: null subtree
		if(t == null) return null;
		// Traverse to the left child node of t,
		// so long as it isn't null
		if(t.left != null) return findMin(t.left);
		// Otherwise, if the left child node of t is null,
		// do not traverse but instead return t, which will
		// be the leftmost leaf-node of the original input tree
		return t;
	}
	
	/**
	 * Returns a node containing the greatest val x in a given tree, t
	 * @param  t [The input subtree]
	 * @return   [Node containing val x]
	 */
	public final Node findMax() { return findMax(this.root); }
	public final Node findMax(Node t) {
		// Corner Case: null subtree
		if(t == null) return null;
		if(t.right != null) return findMax(t.right);
		return t;
	}
	
	/**
	 * Finds a node containing val x in a given tree, t
	 * @param  t [The input tree]
	 * @param  x [The desired val to search for]
	 * @return   [Node containing val x]
	 */
	public Node find(int x) { return find(this.root, x); }
	public Node find(Node t, int x) {
		// TODO: BinaryTree logic for find. This wasn't implemented
		// because a method needs to be created for Node traversal
		// utilizing in-order, post-order, and pre-order methods.
		// It has yet to be implemented and returns null for now.
		//
		// This method is to be overridden by subclass trees which
		// require different methods of node node traversal for optimization.
		// These optimization conditions differ from tree to tree
		return null;
	}
	
	/**
	 * Inserts a new node containing val x to a given tree, t.
	 * If the node is successfully inserted, the new node is returned,
	 * otherwise null is returned.
	 * 
	 * Multiple insertions can be done if an int[] is specified.
	 * In this process, each element is inserted one at a time
	 * and the return is a status boolean of successful execution
	 * @param  t [The input subtree]
	 * @param  x [The desired val to insert]
	 * @return   [The new Node]
	 */
	// Single Insertion
	public Node insert(int x) { return insert(this.root, x); }
	public Node insert(Node t, int x) {
		// TODO: BinaryTree logic for insertion. This wasn't implemented
		// because a method needs to be created that can allow for both
		// left and right child insertion without altering the original
		// method parameters. It has yet to be implemented and returns
		// the root for now.
		//
		// This method is to be overridden by subclass trees which
		// require different methods of node insertion to keep balance.
		// These balance conditions differ from tree to tree
		return this.root;
	}
	// Multiple Insertions. These are processed one insert at a time
	public boolean insert(int[] x) { return insert(this.root, x); }
	public boolean insert(Node t, int[] x) {
		// Insert each Node, one at a time
		for(int i : x) {
			insert(t, i);
		}
		return true;
	}
	
	/**
	 * Removes a node containing val x in a given tree, t
	 * If the node is successfully removed, the new node is
	 * returned. Otherwise null is returned.
	 * 
	 * Multiple removes can be done if an int[] is specified.
	 * In this process, each element is removed one at a time
	 * and the return is a status boolean of successful execution
	 * @param  t [The input subtree]
	 * @param  x [The desired val to remove]
	 * @return   [The node removed]
	 */
	// Single Removal
	public Node remove(int x) { return remove(this.root, x); }
	public Node remove(Node t, int x) {
		// TODO: BinaryTree logic for remove. This wasn't implemented
		// because a traversal method needs to be created for linear
		// search against the unordered BinaryTree.
		// It has yet to be implemented and returns null for now.
		//
		// This method is to be overridden by subclass trees which
		// require different methods of node removal to keep balance.
		// These balance conditions differ from tree to tree
		return null;
	}
	// Multiple Removals. These are processed one remove at a time
	public boolean remove(int[] x) { return remove(this.root, x); }
	public boolean remove(Node t, int[] x) {
		// Remove each Node, one at a time
		for(int i : x) {
			remove(t, i);
		}
		return true;
	}
}