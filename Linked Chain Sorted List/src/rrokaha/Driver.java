/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 12 February 2021
 * Assignment 3
 */

package rrokaha;

public class Driver {

    public static void main(String[] args) {
         LinkedChainList<Integer> Numbers= new LinkedChainList();


        System.out.println("Is list Empty? : "+  Numbers.isEmpty());

        System.out.println("Adding Numbers ........");

        Numbers.add(12);
        Numbers.add(34);
        Numbers.add(8);
        Numbers.add(73);
        Numbers.add(46);
        Numbers.add(95);
        Numbers.add(2,58);
        Numbers.add(4,86);
        Numbers.add(27);
        Numbers.add(60);


        System.out.println("Total numbers in list : "+ Numbers.getLength());

        System.out.println("Displaying List .........");
        displayList(Numbers);


        System.out.println("Number removed at position 4 ....... ");
        Numbers.remove(4);

        System.out.println("Number at position 7 replaced with 69");
        Numbers.replace(7,69);

        System.out.println("Displaying List .............");
        displayList(Numbers);

        System.out.println("Contains 27 ? : "+ Numbers.contains(27));

        System.out.println("NUmber at position 3 :"+ Numbers.getEntry(3));


        System.out.println("Clearing List ............");
        Numbers.clear();
        System.out.println("Is list Empty? : "+  Numbers.isEmpty());


    }


    public static <T>  void displayList(LinkedChainList<T> e){
        T[] myList = e.toArray();
        for(int i=0;i<myList.length;i++){
            System.out.println(myList[i] + " ");
        }
        System.out.println();
    }

}
