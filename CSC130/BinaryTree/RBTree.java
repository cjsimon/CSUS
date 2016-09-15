/** RB Tree serving as a colored, Binary Search Tree */
public class RBTree extends BinarySearchTree {
	/**
	 * RB Tree Insertion Implementation.
	 * See BinaryTree for documentation on insertion
	 * @param  t [The input subtree]
	 * @param  x [The desired val to insert]
	 * @return   [The new node]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node insert(Node t, int x) {
		if(t == null) return t = new Node(x, Node.BLACK);
		//if(t == null) return new Node(x, Node.BLACK);
		if(x < t.val) t.left = insert(t.left, x);
		else if(x > t.val) t.right = insert(t.right, x);
		// Violation 3
		if(isRed(t.left) && !isRed(t.left)) t = rotateToLeft(t);
		// Violation 2
		if(isRed(t.left) && isRed(t.left.left)) t = rotateToRight(t);
		// Violation 1
		// If t is root, make it black
		if(isRed(t.left) && isRed(t.right)) t = flipColor(t);
		t.height = 1 + height(t.left) + height(t.right);
		return t;
	}
	
	/**
	 * RB Tree Removal Implementation.
	 * See BinaryTree for documentation on removal
	 * @param  t [The input subtree]
	 * @param  x [The desired val to remove]
	 * @return   [The node removed]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node remove(Node t, int x) {
		//TODO: Implement remove for RBTree
		return null;
	}
	
	/**
	 * RBTree Left Rotation.
	 * See BinarySearchTree for documentation
	 * @param  h [The input subtree]
	 * @return    [The rotated subtree]
	 * @see       [BinarySearchTree]
	 */
	protected Node rotateToLeft(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = Node.RED;
		x.height = h.height;
		h.height = height(h.left) + height(h.right) + 1;
		return x;
	}
	
	/**
	 * RBTree Right Rotation.
	 * See BinarySearchTree for documentation
	 * @param  h [The input subtree]
	 * @return    [The rotated subtree]
	 * @see       [BinarySearchTree]
	 */
	protected Node rotateToRight(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = Node.RED;
		x.height = h.height;
		h.height = height(h.left) + height(h.right) + 1;
		return x;
	}
	
	/**
	 * Change the color of a given Node, h
	 * @param  h [The node to change colors]
	 */
	protected Node flipColor(Node h) {
		h.left.color = Node.BLACK;
		h.color = Node.RED;
		return h;
	}
	
	/**
	 * Check whether the given node, h, is red or black
	 * @param   h [Node]
	 * @return  [boolean]
	 */
	protected boolean isRed(Node h) {
		return !h.color;
	}
}