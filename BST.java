
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

    private BSTNode<Key,E> getmin(BSTNode<Key,E> rt) 
    {
        if (rt.left() == null) 
            return rt;
        return getmin(rt.left());
    }

    private BSTNode<Key,E> deletemin(BSTNode<Key,E> rt) 
    {
        if (rt.left() == null) 
            return rt.right();
        rt.setLeft(deletemin(rt.left()));
        return rt;
    }

    private void printhelp(BSTNode<Key,E> rt) 
    {
        if (rt == null) 
            return;
        printhelp(rt.left());
        printVisit(rt);
        printhelp(rt.right());
    }

    private StringBuffer out;

    public String toString() 
    {
        out = new StringBuffer(100);
        printhelp(root);
        return out.toString();
    }

    private void printVisit(BSTNode<Key , E> rNode) 
    {
        out.append(rNode.toString() + "\n");
    }

    public BSTNode<Key , E> getMax(BSTNode<Key , E> root)
    {
        BSTNode<Key , E> temp = new BSTNode(root.key(), root.element(), root.left(), root.right());
        while (temp.right() != null && temp != null)
            temp = temp.right();
        return temp;
    }

    public BSTNode<Key , E> getNode()
    {
        return this.root;
    }

    static public void preOrderPrint(BSTNode root)
    {
        if(root == null){
            return;
        }
        System.out.println(root.toString());
        preOrderPrint(root.left());
        preOrderPrint(root.right());
    }
    public static void inOrderPrint(BSTNode root)
    {
        if (root == null){
            return;
        }
        inOrderPrint(root.left());
        System.out.println(root);
        inOrderPrint(root.right());
    }

    public static void postOrderPrint(BSTNode root){
        if (root == null){
            return;
        }
        postOrderPrint(root.left());
        postOrderPrint(root.right());
        System.out.println(root);
    }

    public static int sum(BSTNode<Integer , String> root){
        int totalSum = 0;
        helper(root, totalSum);
        return totalSum;
    }

    private static void helper(BSTNode<Integer,String> root, int count){
        if(root == null)
        return;
        count += root.key();
        helper(root.left(), count);
        helper(root.right(), count);
    }

    public static int treeHeight(BSTNode<Integer, String> root){
        if(root == null)
            return 0;
        return 1 + Math.max(treeHeight(root.left()), treeHeight(root.right()));
    }

    public static void binarySearchBelowThreshold(BSTNode<Integer , String> root , int numBelow)
    {
        if(root == null)
        {
            return ;
        }
        if(root.key().compareTo(numBelow) <= 0)
        {
            System.out.print(root.toString() + "\n");
        }
        binarySearchBelowThreshold(root.left(), numBelow);
        binarySearchBelowThreshold(root.right(), numBelow);
    }

    public static void betweenThreshold(BSTNode<Integer , String> root , int lowerBound, int upperBound )
    {
        {
            if(root == null)
            {
                return ;
            }
            if(root.key() )
            {
                System.out.print(root.toString() + "\n");
            }
            binarySearchBelowThreshold(root.left(), numBelow);
            binarySearchBelowThreshold(root.right(), numBelow);
        } 
    }


    // public static BSTNode findCity(String city , BSTNode<Integer , String> root)
    // {
    //     if (root == null)
    //     {
    //         return null;
    //     }
    //     else if(isCity(city, root)){
    //         return root;
    //     }
    //     BSTNode tempLeftNode = findCity(city, root.left());
    //     BSTNode tempRightNode = findCity(city, root.right());
    //     if(findCity(city, root.left()) == null)
    //     {

    //     }
    // }

    private static boolean isCity(String city , BSTNode<Integer , String> root)
    {
        if(root.element().equals(city))
        {
            return true;   
        }
        return false;
    }

}