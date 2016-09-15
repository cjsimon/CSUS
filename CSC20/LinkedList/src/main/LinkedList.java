package main;

/**
 * LinkedList abstraction data type used to manipulate and change nodes in the list
 * @author  Christopher Simon
 * @version 1.0
 */
public class LinkedList {
    /**
     * Defined Node class used to store an object as
     * an element and a pointer to the next node.
     * @author  Doan Nguyen
     * @author  Christopher Simon
     * @version 1.1
     */
    private class Node {
        // The data element of the node
        private Object data = null;
        // The next node linked to this node
        private Node link = null;

        /** Constructors */
        // No Params
        public Node() {
            // The data and link are
            // initialized as null
            data = link = null;
        }
        // Node data
        public Node(Object e) {
            data = e;
        }
        // Node data and link to next node
        public Node(Object e, Node n) {
            data = e;
            link = n;
        }

        //
        // Getters
        //

        /** Get the node linked to this one */
        public Node getLink() {
            return link;
        }

        /** Get the object element of the node */
        public Object getElement() {
            return data;
        }

        //
        // Mutators
        //

        /** Link this node to the next one */
        public void setLink(Node n) {
            link = n;
        }

        /** Set the object element of the node */
        public void setElement(Object element) {
            data = element;
        }
    }

    // The first and current nodes of the LinkedList
    private Node head = null, current = null;
    private int length = 0;

    /** Constructor */
    // No Params
    public LinkedList() {
        // Create an empty LinkedList
        head = current = null;
    }
    // Array of elements
    public LinkedList(Object[] list) {
        // Call the default constructor
        this();
        // Return if an empty list is passed
        if(list.length == 0) return;

        // Create the last node first
        // This node's link is null
        Node n = new Node(list[list.length], null);
        // Populate the LinkedList backwards, starting with the
        // node before the last.
        // Population is done backwards so that links can be made
        for(int i = list.length-1; i > 0; i--) {
            // Get the current object element
            Object e = list[list.length - i];
            // Create a new node to hold the object element
            // The link of node n will be the previously added node
            n = new Node(e, n.getLink());
        }
        // Set the first node as the head
        head = n;
    }

    /** Add a node with an object element to the first position of the list */
    public boolean addFirst(Object e) {
        // Reassign the head by creating a new node that
        // points to the current head. This will make the
        // new node first while still linking to the old head
        head = new Node(e, head);
        // Increase the length of the list
        length++;
        return true;
    }

    /** Add a node with an object element to the last position of the list */
    public boolean addLast(Object e) {
        // Move current to the end of the list
        moveLast();
        // Create a new node after the last node
        // Link the last node to the new node,
        // thus making the new node last
        current.setLink(new Node(e));
        length++;
        return true;
    }


    /** Add an object element after the current position */
    public boolean insertAfter(Object e) {
        if(length < 1 || isEmpty()) return false;
        // Create a new node that links to the next node
        Node n = new Node(e, current.getLink());
        // Alter current link to the new node
        current.setLink(n);
        length++;
        return true;
    }

    /** Add an object element before the current position */
    public boolean insertBefore(Object e) {
        // The list must have at least one element
        if(length < 1 || isEmpty()) return false;
        if(current == head) return addFirst(e);
        // Move current backwards
        moveBackward();
        // insertAfter the node that comes
        // before the one specified
        return insertAfter(e);
    }

    //
    // Getters
    //

    /** Get the object element from the current node */
    public Object getCurrentElement() {
        if(current == null) return null;
        // Return the current node's object element
        return current.getElement();
    }

    /** Get the object element from the first node */
    public Object getFirstElement() {
        // Return the object element of the head
        // as the head is always the first node
        return head.getElement();
    }

    /** Get the object element from the last node */
    public Object getLastElement() {
        moveFirst();
        if(current == null) return null;
        // Traverse to the last element
        // Do so as long as the next node isn't null
        while(current.getLink() != null) {
            moveForward();
        }
        // The current node is now the last node
        return getCurrentElement();
    }

    /** Returns the number of elements in the list */
    public int length() {
        return length;
    }

    //
    // Traversal
    //

    public boolean moveLast() {
        // Reset the current to the beginning
        moveFirst();
        if(current == null) return false;

        while(current.getLink() != null) {
            // Traverse forward
            moveForward();
        }
        // The current should be the last node before null
        // If current is null for some reason, return false
        return current != null;
    }

    /** Move current forward one node */
    public boolean moveForward() {
        if(current == null) return false;
        current = current.getLink();
        return true;
    }

    /** Move the current position backward one position */
    public boolean moveBackward() {
        if(current == head) return true;
        // Set the current node as the tmp placeholder.
        // Current will traverse until it is behind this node
        Node tmp = current;
        // Start from the head
        moveFirst();
        // Look at the linked element to see if it is either
        // the current or the last element of the list.
        // current will traverse until the next element is tmp or null
        while(current.getLink() != tmp && current.getLink() != null) {
            // Move current forward
            moveForward();
        }

        // If the end was found before reaching the current element
        // of the list, indicate that current was not found
        return current != null;
    }

    /** Reset current to the first node */
    public void moveFirst() {
        current = head;
    }

    //
    // Removal
    //

    /** Remove the first node */
    public boolean removeFirst() {
        moveFirst();
        if(isEmpty()) return false;
        // Set the existing head to the next node in the list
        // This will remove the existing reference of the node
        // from the old head but a new reference is established
        // in the head object variable
        head = head.getLink();
        return true;
    }

    /** Remove the last node */
    public boolean removeLast() {
        moveFirst();
        if(isEmpty()) return false;
        if(current == head) return removeFirst();
        // Move current to the last node
        moveLast();
        // Move current one back before the last node
        moveBackward();
        // Set the link of the node before to null, so that
        // the last node isn't a part of the LinkedList anymore.
        // The Garbage Collector will remove the object so long
        // as no references to the object exist
        current.setLink(null);
        return true;
    }

    /** Remove the current node from the list */
    public boolean remove() {
        if(isEmpty()) return false;
        if(current == head) return removeFirst();
        // Unlink the current node from the chain
        // by setting the link from the node before
        // to the node after the one to remove.
        // The node after to link to
        Node n = current.getLink();
        // Current is now the node before the one
        // to be removed
        moveBackward();
        // Set the link of the node before to the
        // one after the node being removed. Then
        // Null the node to remove so that the GC
        // collects it when necessary
        current.setLink(n);
        return true;
    }

    //
    // Default
    //

    /** Display the contents of the list */
    public String toString() {
        moveFirst();
        if(isEmpty()) return "";
        // The return string starting with the head
        String s = "FIRST ";
        // The starting node
        Node current = head;

        // For all nodes in the LinkedList
        while(current != null) {
            // Append the current node object
            // element to the output string
            s += "NODE: [\n" + current.getElement() + "\n]\n\n";
            // Get the next node
            current = current.getLink();
        }
        return s;
    }

    /** Check if the list is empty */
    public boolean isEmpty() {
        // Current is equal to null if the list is empty
        return current == null;
    }
}