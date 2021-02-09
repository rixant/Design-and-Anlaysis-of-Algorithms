/**
 * Rishant Rokaha
 *Professor Vohra
 * Design and Analysis Of Algorithms
 * 6 February 2021
 * Assignment 2
 */


package rrokaha;

public interface SortedListInterface<T extends Comparable<? super T>> {


    public void add(T newEntry);

    public boolean remove(T newEntry);

    public int getPosition(T anEntry);

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public void clear();

    public int getLength();

    public boolean isEmpty();

    public T[] toArray();

}

