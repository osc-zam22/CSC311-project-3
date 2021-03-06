
/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.lang.Comparable;

/** Binary Search Tree implementation for Dictionary ADT */
class BST<Key extends Comparable<? super Key>, E extends Comparable<? extends E>> implements Dictionary<Key, E> {
    private BSTNode<Key,E> root; // Root of the BST
    int nodecount;             // Number of nodes in the BST

    /** Constructor */
    BST() 
    { 
        root = null; nodecount = 0; 
    }

    /** Reinitialize tree */
    public void clear() 
    { 
        root = null; 
        nodecount = 0; 
    }

    /** Insert a record into the tree.
    @param k Key value of the record.
    @param e The record to insert. */
    public void insert(Key k, E e) 
    {
        root = inserthelp(root, k, e);
        nodecount++;
    }

    /** Remove a record from the tree.
    @param k Key value of record to remove.
    @return The record removed, null if there is none. */
    public E remove(Key k) 
    {
        E temp = findhelp(root, k);   // First find it
        if (temp != null) 
        {
            root = removehelp(root, k); // Now remove it
            nodecount--;
        }
    return temp;
    }

    /** Remove and return the root node from the dictionary.
    @return The record removed, null if tree is empty. */
    public E removeAny() 
    {
        if (root == null) 
            return null;
        E temp = root.element();
        root = removehelp(root, root.key());
        nodecount--;
        return temp;
    }

    /** @return Record with key value k, null if none exist.
    @param k The key value to find. */
    public E find(Key k) 
    { 
        return findhelp(root, k); 
    }

    /** @return The number of records in the dictionary. */
    public int size()
    { 
        return nodecount; 
    }
    private E findhelp(BSTNode<Key,E> rt, Key k) 
    {
        if (rt == null) 
            return null;
        if (rt.key().compareTo(k) > 0)
            return findhelp(rt.left(), k);
        else if (rt.key().compareTo(k) == 0)
            return rt.element();
        else 
            return findhelp(rt.right(), k);
    }
    /** @return The current subtree, modified to contain
    the new item */
    private BSTNode<Key,E> inserthelp(BSTNode<Key,E> rt, Key k, E e) 
    {
        if (rt == null) 
            return new BSTNode<Key,E>(k, e);
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(inserthelp(rt.left(), k, e));
        else
            rt.setRight(inserthelp(rt.right(), k, e));
        return rt;
    }
    /** Remove a node with key value k
    @return The tree with the node removed */
    private BSTNode<Key,E> removehelp(BSTNode<Key,E> rt,Key k) 
    {
        if (rt == null) 
            return null;
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(removehelp(rt.left(), k));
        else if (rt.key().compareTo(k) < 0)
            rt.setRight(removehelp(rt.right(), k));
        else 
        { // Found it
            if (rt.left() == null) 
                return rt.right();
            else if (rt.right() == null) 
                return rt.left();
            else 
            { // Two children
                BSTNode<Key,E> temp = getmin(rt.right());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setRight(deletemin(rt.right()));
            }
        }
    return rt;
    }

    // gets min valuw in the tree
    private BSTNode<Key,E> getmin(BSTNode<Key,E> rt) 
    {
        if (rt.left() == null) 
            return rt;
        return getmin(rt.left());
    }

    // deletes the min
    private BSTNode<Key,E> deletemin(BSTNode<Key,E> rt) 
    {
        if (rt.left() == null) 
            return rt.right();
        rt.setLeft(deletemin(rt.left()));
        return rt;
    }

    // helper print function
    private void printhelp(BSTNode<Key,E> rt) 
    {
        if (rt == null) 
            return;
        printhelp(rt.left());
        printVisit(rt);
        printhelp(rt.right());
    }

    private StringBuffer out;

    // to string function
    public String toString() 
    {
        out = new StringBuffer(100);
        printhelp(root);
        return out.toString();
    }

    // another helper function to the to string
    private void printVisit(BSTNode<Key , E> rNode) 
    {
        out.append(rNode.toString() + "\n");
    }

    // returns the max Value of the Tree 
    public BSTNode<Key , E> getMax(BSTNode<Key , E> root)
    {
        if(root.right() != null && root != null)
        {
            return getMax(root.right());
        }
        return root;
    }

    // returns the root of the BST
    public BSTNode<Key , E> getNode()
    {
        return this.root;
    }

    // prints the binary tree in pre order traversal
    public void preOrderPrint(BSTNode root)
    {
        if(root == null){
            return;
        }
        System.out.println(root.toString());
        preOrderPrint(root.left());
        preOrderPrint(root.right());
    }

    // prints the binary tree in in order traversal
    public void inOrderPrint(BSTNode root)
    {
        if (root == null){
            return;
        }
        this.inOrderPrint(root.left());
        System.out.println(root);
        this.inOrderPrint(root.right());
    }

    // prints the post order traversal of the binary tree
    public void postOrderPrint(BSTNode root){
        if (root == null){
            return;
        }
        this.postOrderPrint(root.left());
        this.postOrderPrint(root.right());
        System.out.println(root);
    }

    // returns the sum of the population
    public int sum(BSTNode<Integer,String> root){
        if (root == null)
            return 0;
        return (root.key() + sum(root.left()) + sum(root.right()));
    }

    // retturns the height of the tree
    public int treeHeight(BSTNode<Integer, String> root){
        if(root == null)
            return 0;
        return 1 + Math.max(treeHeight(root.left()), treeHeight(root.right()));
    }

    // returns the nodes that are less then the input
    public void belowThreshold(BSTNode<Integer , String> root , int numBelow)
    {
        if(root == null)
        {
            return ;
        }
        if(root.key().compareTo(numBelow) <= 0)
        {
            System.out.print(root.toString() + "\n");
        }
        belowThreshold(root.left(), numBelow);
        belowThreshold(root.right(), numBelow);
    }

    // returns the nodes between the two values
    public void betweenThreshold(BSTNode<Integer , String> root , int lowerBound, int upperBound )
    {
        {
            if(root == null)
            {
                return ;
            }
            if(root.key().compareTo(lowerBound) >= 0 && root.key().compareTo(upperBound) <= 0)
            {
                System.out.print(root.toString() + "\n");
            }
            betweenThreshold(root.left() , lowerBound, upperBound);
            betweenThreshold(root.right() , lowerBound, upperBound);
        } 
    }

    // returns the node containing the city being searched
    public BSTNode findCity(BSTNode root , String city)
    {
        if(root == null){
            return null;
        }
        if(isCity((String)root.element() , city))
        {
            return root;
        }
        BSTNode temp1 = findCity(root.left() , city);
        BSTNode temp2 = findCity(root.right() , city);
        if (temp1 != null)
        {
            return temp1;
        }
        else if(temp2 != null)
        {
            return temp2;
        }
        return null;
    }

    // helper function to check if the node contains the city
    private boolean isCity( String element , String city)
    {
        if(element.equalsIgnoreCase(city))
        {
            return true;   
        }
        return false;
    }

}