/***
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * March 12
 * Assignment 16
 */

package rrokaha;

import java.util.Iterator;
public class Driver {

    public static void main(String[] args) {

        //Creating name instances
        Name Rishant = new Name("Rishant","Rokaha");
        Name Manish = new Name("Manish", "Malakar");
        Name Barsha = new Name("Barsha", "Khatiwada");
        Name Bimal = new Name("Bimal", "Manandhar");
        Name Bijen = new Name("Bijen", "Mananndhar");
        Name Shreesha = new Name("Shreesha", "Chaguthi");
        Name Nirajan = new Name("Nirajan", "KC");
        Name Jhoana = new Name("Jhoana", "Flores");
        Name Briam = new Name("Briam", "Lee");
        Name Watsessing = new Name("Watsessing", "Avenue");

        //Create DictionaryInterface Instance
        DictionaryInterface<Name, String> myDictionary = new OurDictionary<>();

        // Check if empty
        System.out.println("Is Empty? : "+myDictionary.isEmpty());
        System.out.println();

        //add Keys and Values in dictionary
        myDictionary.add(Rishant,"985-654-7812");
        myDictionary.add(Manish,"873-495-3409");
        myDictionary.add(Barsha,"734-958-3409");
        myDictionary.add(Bimal,"898-237-9039");
        myDictionary.add(Bijen,"873-495=3409");
        myDictionary.add(Shreesha,"923-747-2390");
        myDictionary.add(Nirajan,"982-367-9734");
        myDictionary.add(Jhoana,"982-348-9009");
        myDictionary.add(Briam,"873-499-3775");
        myDictionary.add(Watsessing,"985-546-0677");

        //check size of dictionary
        System.out.println("Size of Dictionary : "+myDictionary.getSize());

        //displaying dictionary contents
        System.out.println("Printing Dictionary ............");
        System.out.println("----------------------------------------------------");
        display(myDictionary);
        System.out.println();

        //Removing Briam Key
        System.out.println("Key Briam removed........");
        myDictionary.remove(Briam);

        //Retrieve value of key
        System.out.println();
        System.out.println("Value of Key Barsha : "+myDictionary.getValue(Barsha));

        //check if key exists in dictionary
        System.out.println("Contains Key Jhoana? : "+myDictionary.contains(Jhoana));
        System.out.println();

        //displaying dictionary contents
        System.out.println("Printing Dictionary ............");
        System.out.println("----------------------------------------------------");
        display(myDictionary);
        System.out.println();

        //clearing dictionary
        System.out.println("Dictionary cleared.......");
        myDictionary.clear();

        System.out.println("Is Empty? : "+myDictionary.isEmpty());



    }

    //displays the contents of dictionary by iterating over each key and values
    public static void display(DictionaryInterface dict){
        Iterator<Name> keyIterator = dict.getKeyIterator();
        Iterator<String> valueIterator = dict.getValueIterator();

        while (keyIterator.hasNext()) {
            System.out.println("Key: "+keyIterator.next() + ", " +
                    "Value: "+valueIterator.next());
        } // end while

    } // end display


}






