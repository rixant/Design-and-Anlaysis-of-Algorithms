/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 25 April 2021
 * Assignment 11
 */

package rrokaha;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
    //Creating instance of BinaryNode
    private BinaryNode<T> root;

    //default constructor
    public BinaryTree()
    {
        root = null;
    }//end constructor

    //1-argument constructor
    public BinaryTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    }//end constructor

    //3-argument constructor
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        initializeTree(rootData, leftTree, rightTree);
    }//end 3-argument constructor

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        initializeTree(rootData, (BinaryTree<T>) leftTree,
                (BinaryTree<T>) rightTree);
    }//end setTree

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        root = new BinaryNode<>(rootData);
        if ((leftTree != null) && !leftTree.isEmpty())
        {
            root.setLeftChild(leftTree.root);
        }//end if
        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
            {
                root.setRightChild(rightTree.root);
            }
            else
            {
                root.setRightChild(rightTree.root.copy());
            }//end if
        } // end if
        if ((leftTree != null) && (leftTree != this))
        {
            leftTree.clear();
        }//end if
        if ((rightTree != null) && (rightTree != this))
        {
            rightTree.clear();
        }//end if
    } // end initializeTree

    @Override
    public void setRootData(T rootData)
    {
        root.setData(rootData);
    }//end setRootData

    @Override
    public T getRootData()
    {
        if(isEmpty())
        {
            throw new RuntimeException();
        }
        else
        {
            return root.getData();
        }//end if
    }//end getRootData

    //method to return the height of the tree
    @Override
    public int getHeight()
    {
        int height = 0;
        if(root != null)
        {
            height = root.getHeight();
        }//end if
        return height;
    }//end getHeight

    //method to return the number of nodes in the tree
    @Override
    public int getNumberOfNodes()
    {
        int numberOfNodes = 0;
        if(root != null)
        {
            numberOfNodes = root.getNumberOfNodes();
        }//end if
        return numberOfNodes;
    }//end getNumberOfNodes

    //method to return whether the tree is empty or not
    @Override
    public boolean isEmpty()
    {
        return root == null;
    }//end isEmpty

    //method to clear the tree
    @Override
    public void clear()
    {
        root = null;
    }//end clear

    @Override
    public Iterator<T> getPreorderIterator()
    {
        return new PreorderIterator();
    }//end getPreorderIterator

    private class PreorderIterator implements Iterator<T>
    {
        private Stack<BinaryNode<T>> nodeStack;

        public PreorderIterator()
        {
            nodeStack = new Stack<>();
            if(root != null)
            {
                nodeStack.push(root);
            }
        }//end PreorderIterator

        //Returns true if the iteration has more elements.
        @Override
        public boolean hasNext()
        {
            return nodeStack.isEmpty() == false;
        }//end hasNext

        //Returns the next element in the iteration.
        @Override
        public T next()
        {
            BinaryNode<T> nextNode;
            if(hasNext())
            {
                nextNode = nodeStack.pop();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();

                //push into stack in reverse order of recursive calls
                if(rightChild != null)
                {
                    nodeStack.push(rightChild);
                }//end if
                if(leftChild != null)
                {
                    nodeStack.push(leftChild);
                }//end if
            }
            else
            {
                throw new NoSuchElementException();
            }//end if
            return nextNode.getData();
        }//end next
    }

    @Override
    public Iterator<T> getPostorderIterator()
    {
        return new PostorderIterator();
    }

    private class PostorderIterator implements Iterator<T>
    {
        private Stack<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public PostorderIterator()
        {
            nodeStack = new Stack<>();
            currentNode = root;
        }

        //Returns true if the iteration has more elements.
        @Override
        public boolean hasNext()
        {
            return (nodeStack.isEmpty() == false) || (currentNode != null);
        }

        //Returns the next element in the iteration.
        @Override
        public T next()
        {
            BinaryNode<T> leftChild, nextNode = null;

            //find leftmost leaf
            while(currentNode != null)
            {
                nodeStack.push(currentNode);
                leftChild = currentNode.getLeftChild();

                if(leftChild == null)
                {
                    currentNode = currentNode.getRightChild();
                }
                else
                    currentNode = leftChild;
            }

            if(nodeStack.isEmpty() == false)
            {
                nextNode = nodeStack.pop();
                BinaryNode<T> parent = null;

                if(nodeStack.isEmpty() == false)
                {
                    parent = nodeStack.peek();

                    if(nextNode == parent.getLeftChild())
                    {
                        currentNode = parent.getRightChild();
                    }
                    else
                    {
                        currentNode = null;
                    }
                }
                else
                {
                    currentNode = null;
                }
            }
            else
            {
                throw new NoSuchElementException();
            }
            return nextNode.getData();
        }
    }

    @Override
    public Iterator<T> getInorderIterator()
    {
        return new InorderIterator();
    } // end InorderIterator

    private class InorderIterator implements Iterator<T>
    {
        private Stack<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public InorderIterator()
        {
            nodeStack = new Stack<>();
            currentNode = root;
        } // end default constructor

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove

        //Returns true if the iteration has more elements.
        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext

        //Returns the next element in the iteration.
        public T next()
        {
            BinaryNode<T> nextNode = null;

            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while

            // Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                // Assertion: nextNode != null, since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild();
            }
            else
                throw new NoSuchElementException();
            return nextNode.getData();
        } // end next
    } // end InorderIterator

    @Override
    public Iterator<T> getLevelOrderIterator()
    {
        return new LevelOrderIterator();
    }//end getLevelOrderIterator

    private class LevelOrderIterator implements Iterator<T>
    {
        private Queue<BinaryNode<T>> nodeQueue;

        public LevelOrderIterator()
        {
            nodeQueue = new LinkedList<>();

            if(root != null)
            {
                nodeQueue.add(root);
            }//end if
        }//end constructor

        //Returns true if the iteration has more elements.
        @Override
        public boolean hasNext()
        {
            return (nodeQueue.isEmpty() == false);
        }//end hasNext

        //Returns the next element in the iteration.
        @Override
        public T next()
        {
            BinaryNode<T> nextNode;

            if(hasNext())
            {
                nextNode = nodeQueue.poll();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();

                if(leftChild != null)
                {
                    nodeQueue.add(leftChild);
                }//end if

                if(rightChild != null)
                {
                    nodeQueue.add(rightChild);
                }//end if
            }
            else
            {
                throw new NoSuchElementException();
            }//end if
            return nextNode.getData();
        }//end next
    }//end LevelOrderIterator
}//end BinaryTree
