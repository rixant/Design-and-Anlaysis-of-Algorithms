/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 2 May 2021
 * Assignment 12
 */


package rrokaha;

/** An interface for the ADT tree. */
public interface TreeInterface<T>{

    public T getRootData();

    public int getHeight();

    public int getNumberOfNodes();

    public boolean isEmpty();

    public void clear();

}
