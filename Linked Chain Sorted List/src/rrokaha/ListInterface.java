/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 12 February 2021
 * Assignment 3
 */


package rrokaha;

public interface ListInterface<T>
{

    public void add(T newEntry);


    public void add(int newPosition, T newEntry);


    public T remove(int givenPosition);


    public void clear();


    public T replace(int givenPosition, T newEntry);


    public T getEntry(int givenPosition);


    public T[] toArray();


    public boolean contains(T anEntry);


    public int getLength();


    public boolean isEmpty();
}