/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 10 April 2021
 * Assignment 10
 */

package rrokaha;

public class Driver {

    public static void main(String[] args) {

        //create an instance of BinarySearchtree
        BinarySearchTree myTree = new BinarySearchTree();

        //insert Nodes
        System.out.println("Adding ........");
        myTree.insert("Root");
        myTree.insert("Stokes");
        myTree.insert("Moeen");
        myTree.insert("Morgan");
        myTree.insert("Bairstow");
        myTree.insert("Butler");
        myTree.insert("Roy");
        myTree.insert("Archer");
        myTree.insert("Wood");
        myTree.insert("Woakes");
        myTree.insert("Curran");
        myTree.insert("Vince");
        myTree.insert("Plunket");
        myTree.insert("Billings");
        myTree.insert("Livingstone");

        System.out.println("Printing Tree ......");
        myTree.display(myTree.root);
        System.out.println();

        System.out.println("Does tree contain Billings? : "+ myTree.find("Billings"));
        System.out.println();

        System.out.println("Morgan deleted from tree ......");
        myTree.delete("Morgan");
        System.out.println();

        System.out.println("Printing Tree ......");
        myTree.display(myTree.root);


    }//end main

}//end Driver class
