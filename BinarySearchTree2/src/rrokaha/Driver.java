/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 2 May 2021
 * Assignment 12
 */


package rrokaha;

import java.util.Iterator;


public class Driver {


    public static void main(String[] args) {

        //Create an instance of BinarySearchTree
        BinarySearchTree<String> BST = new BinarySearchTree<>();
        System.out.println("Adding entries to Binary Tree.....");
        BST.add("NEWYORK");
        BST.add("TOKYO");
        BST.add("JAKARTA");
        BST.add("BEIJING");
        BST.add("DELHI");
        BST.add("KATHMANDU");
        BST.add("MOSCOW");
        BST.add("PARIS");
        BST.add("ROME");
        BST.add("AMSTERDAM");
        BST.add("KATHMANDU");
        BST.add("LONDON");
        BST.add("LISBON");
        BST.add("SEOUL");
        System.out.println("Entries added.");
        System.out.println();


        System.out.println("Contains MOSCOW ? : "+BST.contains("MOSCOW"));
        System.out.println();

        System.out.println("Removing \"MOSCOW\" from Binary Tree. . . .  .");
        BST.remove("MOSCOW");
        System.out.println("Removed.");
        System.out.println();

        System.out.println("Contains MOSCOW ? : "+BST.contains("MOSCOW"));
        System.out.println();

        System.out.println("InOrder Traversal");
        displayInOrder(BST);
        System.out.println();

        System.out.println("PreOrder Traversal");
        displayPreOrder(BST);
        System.out.println();

        System.out.println("PostOrder Traversal");
        displayPostOrder(BST);
        System.out.println();

        System.out.println("LevelOrder Traversal");
        displayLevelOrder(BST);
        System.out.println();



    }//end main


    /** method to display PreOrder transversal */
    public static void displayPreOrder(BinaryTreeInterface<String> food)
    {
        Iterator<String> iter = food.getPreorderIterator();

        while(iter.hasNext())
        {
            String value = iter.next();
            System.out.print(value + " ");
        }//end while
        System.out.println();
    }//end displayPredOrder method


    /** method to display PostOrder transversal */
    public static void displayPostOrder(BinaryTreeInterface<String> food)
    {
        Iterator<String> iter = food.getPostorderIterator();

        while(iter.hasNext())
        {
            String value = iter.next();
            System.out.print(value + " ");
        }//end while
        System.out.println();
    }//end displayPostOrder method


    /** method to display InOrder transversal */
    public static void displayInOrder(BinaryTreeInterface<String> food)
    {
        Iterator<String> iter = food.getInorderIterator();

        while(iter.hasNext())
        {
            String value = iter.next();
            System.out.print(value + " ");
        }//end while
        System.out.println();
    }//end displayInorder method


    /** method to display LevelOrder transversal */
    public static void displayLevelOrder(BinaryTreeInterface<String> food)
    {
        Iterator<String> iter = food.getLevelOrderIterator();

        while(iter.hasNext())
        {
            String value = iter.next();
            System.out.print(value + " ");
        }//end while
        System.out.println();
    }//end displayLevelOrder method

}//end Driver
