import java.util.Scanner;

class RBTree
{
   private RBNode current;
   private RBNode parent;
   private RBNode grand;
   private RBNode great;
   private RBNode header;    
   private static RBNode nullNode;
   static 
   {
      nullNode = new RBNode(0);
      nullNode.left = nullNode;
      nullNode.right = nullNode;
   }
   
   static final int BLACK = 1;    
   static final int RED   = 0;
 
   public RBTree(int negInf)
   {
   	header = new RBNode(negInf);
      header.left = nullNode;
      header.right = nullNode;
   }
     
   public void insert(int item )
   {
      current = parent = grand = header;
      nullNode.content = item;
      
      while (current.content != item)
      {            
      	great = grand; 
         grand = parent; 
         parent = current;
         
         if (item < current.content)
         {
            current = current.left;
         }
         else
         {
            current = current.right;
         }
                     
         if (current.left.color == RED && current.right.color == RED)
         {
            handleReorient( item );
         }
         }
         if (current != nullNode)
         {
             return;
         }    
         current = new RBNode(item, nullNode, nullNode);
         if (item < parent.content)
         {
             parent.left = current;
         }    
         else
             parent.right = current;        
         handleReorient( item );
     }
     private void handleReorient(int item)
     {
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
 
         if (parent.color == RED)   
         {
             grand.color = RED;
             if (item < grand.content != item < parent.content)
                 parent = rotate( item, grand ); 
             current = rotate(item, great );
             current.color = BLACK;
         }
         header.right.color = BLACK; 
     }      
     private RBNode rotate(int item, RBNode parent)
     {        
         if(item < parent.content)
         {
            if (item < parent.left.content)
            {
               return parent.left = rotateWithLeftChild(parent.left);
            }
            else
            {
               return parent.left = rotateWithRightChild(parent.left);
            }
         }   
         else
         {
            if (item < parent.right.content)
            {
               return parent.right = rotateWithLeftChild(parent.right);
            }
            else
            {
               return parent.right = rotateWithRightChild(parent.right);
            }
         }   
     }

     private RBNode rotateWithLeftChild(RBNode k2)
     {
         RBNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }

     private RBNode rotateWithRightChild(RBNode k1)
     {
         RBNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }    
 }
 
 class RBNode
 {    
     RBNode left; 
     RBNode right;
     int content;
     int color;
 
     public RBNode(int thiscontent)
     {
         this(thiscontent, null, null);
     } 
     
     public RBNode(int thiscontent, RBNode lt, RBNode rt)
     {
         left = lt;
         right = rt;
         content = thiscontent;
         color = 1;
     }    
 }
 
    
