/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 2 May 2021
 * Assignment 12
 */


package rrokaha;

/** A class that implements ADT binary search tree by extending BinaryTree. */
public class BinarySearchTree<T extends Comparable<? super T>>
        extends BinaryTree<T> implements SearchTreeInterface<T> {
    public BinarySearchTree()
    {
        super();
    } // end default constructor


    public BinarySearchTree(T rootEntry)
    {
        super();
        setRootNode(new BinaryNode<T>(rootEntry));
    } // end constructor


    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree)
    {
        throw new UnsupportedOperationException();
    } // end setTree


    protected void setRootNode(BinaryNode<T> rootNode){
        root=rootNode;
    }


    public BinaryNode<T> getRootNode(){
        return root;
    }


    public T getEntry(T anEntry)
    {
        return findEntry(getRootNode(), anEntry);
    } // end getEntry


    private T findEntry(BinaryNode<T> rootNode, T anEntry)
    {
        T result = null;
        if (rootNode != null)
        {
            T rootEntry = rootNode.getData();
            if (anEntry.equals(rootEntry))
                result = rootEntry;
            else if (anEntry.compareTo(rootEntry) < 0)
                result = findEntry(rootNode.getLeftChild(), anEntry);
            else
                result = findEntry(rootNode.getRightChild(), anEntry);
        } // end if
        return result;
    } // end findEntry'


    public boolean contains(T anEntry)
    {
        return getEntry(anEntry) != null;
    } // end contains


    public T add(T anEntry)
    {
        T result = null;
        if (isEmpty())
            setRootNode(new BinaryNode<>(anEntry));
        else
            result = addEntry(getRootNode(), anEntry);
        return result;
    } // end add


    // Adds anEntry to the nonempty subtree rooted at rootNode.
    private T addEntry(BinaryNode<T> rootNode, T anEntry)
    {
// Assertion: rootNode != null
        T result = null;
        int comparison = anEntry.compareTo(rootNode.getData());
        if (comparison == 0)
        {
            result = rootNode.getData();
            rootNode.setData(anEntry);
        }
        else if (comparison < 0)
        {
            if (rootNode.hasLeftChild())
                result = addEntry(rootNode.getLeftChild(), anEntry);
            else
                rootNode.setLeftChild(new BinaryNode<>(anEntry));
        }
        else
        {
            if (rootNode.hasRightChild())
                result = addEntry(rootNode.getRightChild(), anEntry);
            else
                rootNode.setRightChild(new BinaryNode<>(anEntry));
        } // end if
        return result;
    } // end addEntry


    public T remove(T anEntry)
    {
        ReturnObject oldEntry = new ReturnObject(null);
        BinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
        setRootNode(newRoot);
        return oldEntry.getItem();
    } // end remove


    // Removes an entry from the tree rooted at a given node.
    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T anEntry,
                                      ReturnObject oldEntry)
    {
        if (rootNode != null)
        {
            T rootData = rootNode.getData();
            int comparison = anEntry.compareTo(rootData);
            if (comparison == 0) // anEntry == root entry
            {
                oldEntry.setItem(rootData);
                rootNode = removeFromRoot(rootNode);
            }
            else if (comparison < 0) // anEntry < root entry
            {
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                BinaryNode<T> subtreeRoot = removeEntry(leftChild, anEntry, oldEntry);
                rootNode.setLeftChild(subtreeRoot);
            }
            else // anEntry > root entry
            {
                BinaryNode<T> rightChild = rootNode.getRightChild();
// A different way of coding than for left child:
                rootNode.setRightChild(removeEntry(rightChild, anEntry, oldEntry));
            } // end if
        } // end if
        return rootNode;
    } // end removeEntry


    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
    {
// Case 1: rootNode has two children
        if (rootNode.hasLeftChild() && rootNode.hasRightChild())
        {
// Find node with largest entry in left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
// Replace entry in root
            rootNode.setData(largestNode.getData());
// Remove node with largest entry in left subtree
            rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
        } // end if
// Case 2: rootNode has at most one child
        else if (rootNode.hasRightChild())
            rootNode = rootNode.getRightChild();
        else
            rootNode = rootNode.getLeftChild();
// Assertion: If rootNode was a leaf, it is now null
        return rootNode;
    } // end removeEntry


    // Finds the node containing the largest entry in a given tree.
// rootNode is the root node of the tree.
// Returns the node containing the largest entry in the tree.
    private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild())
            rootNode = findLargest(rootNode.getRightChild());
        return rootNode;
    } // end findLargest


    // Removes the node containing the largest entry in a given tree.
// rootNode is the root node of the tree.
// Returns the root node of the revised tree.
    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild())
        {
            BinaryNode<T> rightChild = rootNode.getRightChild();
            rightChild = removeLargest(rightChild);
            rootNode.setRightChild(rightChild);
        }
        else
            rootNode = rootNode.getLeftChild();
        return rootNode;
    } // end removeLargest


    private class ReturnObject {
        private T item;

        private ReturnObject(T entry) {
            item = entry;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }


    /** The class NodePair */
    private class NodePair{
        private BinaryNode<T> first,second;

        public NodePair() {
            first=null;
            second=null;
        }

        public NodePair(BinaryNode<T> first, BinaryNode<T> second) {
            this.first = first;
            this.second = second;
        }

        public BinaryNode<T> getFirst() {
            return first;
        }

        public BinaryNode<T> getSecond() {
            return second;
        }
    }
}