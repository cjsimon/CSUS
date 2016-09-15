//t is the AVL node that will have the node properties from node method

import java.util.Scanner; 

class AVLTree
{
	private AVLNode rootnode;
	
   //insert content into avl one by one from loop     	
	public void insert(int content) 
	{
		rootnode = insert(content, rootnode);
	}
	
   //gets height of tree   
	private int height(AVLNode t)
	{
		if(t==null)
		{
			return -1;
		}
		else
		{
			return t.height;
		}
	}
	
	private int max(int leftside, int rightside)
	{
		if(leftside > rightside)
		{
			return leftside;
		}   
		else
		{
			return rightside;
		}
	}
	
	private AVLNode insert(int x, AVLNode t)
	{
		if (t == null)
		{
			t = new AVLNode(x);
		}	 
		
		else if (x < t.content)
		{
			t.left = insert(x, t.left);
			
			//if bad balance
			if(height(t.left) - height(t.right) == 2)
			{
				if(x < t.left.content)
				{
					t = leftrotate(t);
				}          
				
				else
				{
					t = doubleleft(t);
				}	
			}	
		}
		
		else if(x > t.content)
		{
			t.right = insert(x, t.right);
			
			//if bad balance
			if(height(t.right) - height(t.left) == 2)
			{
				if(x > t.right.content)
				{
					t = rightrotate(t);
				}	
				else
				{
					t = doubleright(t);
				}
			}		
		}
		
		else
		{
			//you are inputing a value that already is in the tree
			//nothing is done
		}	
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}
	
	private AVLNode leftrotate(AVLNode k2)
	{
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
		k1.height = max( height( k1.left ), k2.height ) + 1;
		return k1;
	}
	
	private AVLNode rightrotate(AVLNode k1)
	{
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
		k2.height = max( height( k2.right ), k1.height ) + 1;
		return k2;
	}
	
	private AVLNode doubleleft(AVLNode k3)
	{
		k3.left = rightrotate( k3.left );
		return leftrotate( k3 );
	}
	
	private AVLNode doubleright(AVLNode k1)
	{
		k1.right = leftrotate( k1.right );
		return rightrotate( k1 );
	} 
}

class AVLNode
{    
	AVLNode left; 
	AVLNode right;
	int content;
	int height;
	
	public AVLNode(int n)
	{
		left = null;
		right = null;
		content = n;
		height = 0;
	}     
}

