/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 25 April 2021
 * Assignment 11
 */


package rrokaha;

import java.util.Iterator;


public class Driver {


    public static void main(String[] args) {

        /** Tree with 6 nodes */

        /**
         *           A
         *      B         E
         *   C     D   F
         */

        BinaryTree<String> C = new BinaryTree<>("C");
        BinaryTree<String> D = new BinaryTree<>("D");
        BinaryTree<String> F = new BinaryTree<>("F");
        BinaryTree<String> B = new BinaryTree<>("B", C, D);
        BinaryTree<String> E = new BinaryTree<>("E", F, null);
        BinaryTreeInterface<String> A = new BinaryTree<>("A", B, E);

        System.out.println("------- Tree with 6 Nodes ------- ");
        System.out.println("Height of tree: "+A.getHeight());
        System.out.println("Number of Nodes: "+A.getNumberOfNodes());
        System.out.println("Root: "+A.getRootData());
        System.out.println("PreOrder Transversal");
        displayPreOrder(A);
        System.out.println("PostOrder Transversal");
        displayPostOrder(A);
        System.out.println("InOrder Transversal");
        displayInOrder(A);
        System.out.println("LevelOrder Transversal");
        displayLevelOrder(A);

        System.out.println("*****************************************************");

        /** Tree with 7 nodes */

        /**
         *                3
         *         7             2
         *     4      1      6       5
         */

        BinaryTree<String> n4 = new BinaryTree<>("4");
        BinaryTree<String> n1 = new BinaryTree<>("1");
        BinaryTree<String> n6 = new BinaryTree<>("6");
        BinaryTree<String> n5 = new BinaryTree<>("5");
        BinaryTree<String> n7 = new BinaryTree<>("7", n4, n1);
        BinaryTree<String> n2 = new BinaryTree<>("2", n6, n5);
        BinaryTreeInterface<String> n3 = new BinaryTree<>("3", n7, n2);

        System.out.println("------- Tree with 7 Nodes ------- ");
        System.out.println("Height of tree: "+n3.getHeight());
        System.out.println("Number of Nodes: "+n3.getNumberOfNodes());
        System.out.println("Root: "+n3.getRootData());
        System.out.println("PreOrder Transversal");
        displayPreOrder(n3);
        System.out.println("PostOrder Transversal");
        displayPostOrder(n3);
        System.out.println("InOrder Transversal");
        displayInOrder(n3);
        System.out.println("LevelOrder Transversal");
        displayLevelOrder(n3);

        System.out.println("*****************************************************");


        /** Tree with 8 nodes */

        /**
         *                  TSLA
         *       NKLA                  NFLX
         *    FB     AMZN         SNAP       DOGE
         *                     BTC
         */

        BinaryTree<String> Facebook = new BinaryTree<>("FB");
        BinaryTree<String> Amazaon = new BinaryTree<>("AMZN");
        BinaryTree<String> Bitcoin = new BinaryTree<>("BTC");
        BinaryTree<String> Dogecoin = new BinaryTree<>("DOGE");
        BinaryTree<String> Snapchat = new BinaryTree<>("SNAP", Bitcoin, null);
        BinaryTree<String> Netflix = new BinaryTree<>("NFLX", Snapchat, Dogecoin);
        BinaryTree<String> Nikola = new BinaryTree<>("NKLA", Facebook, Amazaon);
        BinaryTree<String> Tesla = new BinaryTree<>("TSLA", Nikola, Netflix);

        System.out.println("------- Tree with 8 Nodes ------- ");
        System.out.println("Height of tree: "+Tesla.getHeight());
        System.out.println("Number of Nodes: "+Tesla.getNumberOfNodes());
        System.out.println("Root: "+Tesla.getRootData());
        System.out.println("PreOrder Transversal");
        displayPreOrder(Tesla);
        System.out.println("PostOrder Transversal");
        displayPostOrder(Tesla);
        System.out.println("InOrder Transversal");
        displayInOrder(Tesla);
        System.out.println("LevelOrder Transversal");
        displayLevelOrder(Tesla);

        System.out.println("*****************************************************");


        /** Tree with 9 nodes */

        /**
         *                      Rixant
         *             Doug                 Whitney
         *     Britanny    Jared       Megan       Kane
         * Brett                Jim
         */

        BinaryTree<String> Brett = new BinaryTree<>("Brett");
        BinaryTree<String> Tim = new BinaryTree<>("Tim");
        BinaryTree<String> Megan = new BinaryTree<>("Megan");
        BinaryTree<String> Kane = new BinaryTree<>("Kane");
        BinaryTree<String> Whitney = new BinaryTree<>("Whitney", Megan, Kane);
        BinaryTree<String> Britanny = new BinaryTree<>("Britanny", Brett, null);
        BinaryTree<String> Jared = new BinaryTree<>("Jared", null, Tim);
        BinaryTree<String> Doug = new BinaryTree<>("Doug", Britanny, Jared);
        BinaryTree<String> Rixant = new BinaryTree<>("Rixant", Doug, Whitney);

        System.out.println("------- Tree with 9 Nodes ------- ");
        System.out.println("Height of tree: "+Rixant.getHeight());
        System.out.println("Number of Nodes: "+Rixant.getNumberOfNodes());
        System.out.println("Root: "+Rixant.getRootData());
        System.out.println("PreOrder Transversal");
        displayPreOrder(Rixant);
        System.out.println("Postrder Transversal");
        displayPostOrder(Rixant);
        System.out.println("InOrder Transversal");
        displayInOrder(Rixant);
        System.out.println("LevelOrder Transversal");
        displayLevelOrder(Rixant);


    }


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
