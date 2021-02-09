/**
 * Rishant Rokaha
 *Professor Vohra
 * Design and Analysis Of Algorithms
 * 6 February 2021
 * Assignment 2
 */


package rrokaha;

public class Driver {

    public static void main(String[] args) {



        LinkedSortedList<String> Courses = new LinkedSortedList<>();

        System.out.println("Is list Empty? : "+  Courses.isEmpty());

        System.out.println("Adding Courses ........");

        Courses.add("Software Engineering");
        Courses.add("Communication Skills");
        Courses.add("Data Structures");
        Courses.add("Machine Learning");
        Courses.add("History");
        Courses.add("History");
        Courses.add("History");
        Courses.add("History");
        Courses.add("Calculus");
        Courses.add("Sociology");
        Courses.add("Modern Geometry");
        Courses.add("Linear Algebra");
        Courses.add("Abstract Algebra");

        System.out.println("Number of Courses Added : "+ Courses.getLength());

        System.out.println("Displaying List .........");
        displayList(Courses);


        System.out.println("History removed ..........");
        Courses.remove("History");

        System.out.println("Displaying List .............");
        displayList(Courses);

        System.out.println("Contains Calculus ? : "+ Courses.contains("Calculus"));
        System.out.println("Position of Machine Learning : "+ Courses.getPosition("Machine Learning"));

        System.out.println("Courses at position 3 :"+ Courses.getEntry(3));


        System.out.println("Clearing Courses ............");
        Courses.clear();
        System.out.println("Is list Empty? : "+  Courses.isEmpty());


    }
    

    public static <T extends Comparable<? super T>>  void displayList(LinkedSortedList<T> e){
        T[] myList = e.toArray();
        for(int i=0;i<myList.length;i++){
            System.out.println(myList[i] + " ");
        }
        System.out.println();
    }




}
