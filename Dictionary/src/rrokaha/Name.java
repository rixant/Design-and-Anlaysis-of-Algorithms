/***
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * March 12
 * Assignment 16
 */

package rrokaha;

import java.util.Comparator;

public class Name implements Comparable<Name>{

    //define global variables
    private String firstName, lastName;


    //Constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }//end Constructor


    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //getters
    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    //compares two different objects
    @Override
    public int compareTo(Name o) {
        return Comparator.comparing(Name::getFirstName)
                .thenComparing(Name::getLastName)
                .compare(this, o);
    }//end compareTo Method


    //toString Method
    @Override
    public String toString() {
        return firstName+" "+lastName;
    }//end toString


}//end Class
