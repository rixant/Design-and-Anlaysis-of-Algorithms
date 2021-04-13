/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 10 April 2021
 * Assignment 10
 */

package rrokaha;

public class BinarySearchTree {
    public Node root;

    //constructor
    public BinarySearchTree() {
        this.root = null;
    }

    //method to find the Node in the tree
    public boolean find(String id) {
        Node current = root;
        while (current != null) {
            if (current.data.compareTo(id) == 0) {
                return true;
            } else if (current.data.compareTo(id) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }//end while
        return false;
    }

    //method to delete the Node
    public boolean delete(String id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data.equals(id) == false) {
            parent = current;
            if (current.data.compareTo(id) > 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }//end while
        // Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }//end ifelse
        // Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            // now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }//end ifelse
            successor.left = current.left;
        }//end elseif
        return true;
    }


    //method to find the SuccessorNode
    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }//end while
        // check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }//end if
        return successsor;
    }//end getSuccessor method


    //method to insert ned Node
    public void insert(String id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }//end if
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            //go to left of the tree
            if (id.compareTo(current.data) < 0) {
                current = current.left;
                //insert to the left
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            }
            //go to right of the tree
            else {
                current = current.right;
                //insert to the right
                if (current == null) {
                    parent.right = newNode;
                    return;
                }//end if
            }//end else
        }//end while
    }//end insert method


    //method to display the tree
    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }//endif
    }//end display method

}//end BinarySearchTree

//class Node
class Node {
    String data;
    Node left;
    Node right;

    //Node constructor
    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }

}//end Node class
