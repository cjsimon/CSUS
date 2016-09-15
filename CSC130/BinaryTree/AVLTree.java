/** AVL Tree serving as a balanced, Binary Search Tree */
public class AVLTree extends BinarySearchTree {
	/**
	 * AVL Tree Insertion Implementation.
	 * See BinaryTree for documentation on insertion
	 * @param  t [The input subtree]
	 * @param  x [The desired val to insert]
	 * @return   [The new node]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node insert(Node t, int x) {
		if(t == null) return t = new Node(x);
		if(x < t.val) {
			t.left = insert(t.left, x);
			if(height(t.left) - height(t.right) == 2) {
				if(x < t.left.val) { //x < k1
					t = rotateToRight(t);
				} else { // x >= t.left.val
					t = doubleRotateRight(t);
				}
			}
		} else if(x > t.val) { // Mirror case right
			t.right = insert(t.right, x);
			if(height(t.right) - height(t.left) == 2) {
				if(x > t.right.val) { //x > k1
					t = rotateToLeft(t);
				} else { // x <= t.right.val
					t = doubleRotateLeft(t);
				}
			}
		}
		// Failsafe return
		return null;
	}
	
	/**
	 * AVL Tree Removal Implementation.
	 * See BinaryTree for documentation on removal
	 * @param  t [The input subtree]
	 * @param  x [The desired val to remove]
	 * @return   [The node removed]
	 * @see      [BinaryTree]
	 */
	@Override
	public Node remove(Node t, int x) {
		if(x < t.val) {
			t.left = remove(t.left, x);
			if(height(t.right) - height(t.left) == 2) {
				if(height(t.right.right) >= height(t.left.left)) {
					t = rotateToLeft(t);
				} else {
					t = doubleRotateLeft(t);
				}
			}
		} else { // Mirror Case Right
			t.right = remove(t.right, x);
			if(height(t.right) - height(t.left) == 2) {
				if(height(t.right.right) < height(t.left.left)) {
					t = rotateToRight(t);
				} else {
					t = doubleRotateRight(t);
				}
			} 
		}
		// Failsafe return
		return null;
	}
}