/**Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 4th May 2020
 * Assignment 13
 */

package rrokaha;

public interface MaxHeapInterface<T extends Comparable<? super T>> {


    /** Adds a new entry to this heap.
     @param newEntry  an object to be added */
    public void add(T newEntry);


    /** Removes and returns the largest item in this heap.
     @return either the largest object in the heap or,
     if the heap is empty before the operation, null */
    public T removeMax();


    /** Retrieves the largest item in this heap.
     @return either the largest object in the heap or,
     if the heap is empty, null */
    public T getMax();


    /** Detects whether this heap is empty.
     @return true if the heap is empty, else returns false */
    public boolean isEmpty();


    /** Gets the size of this heap.
     @return the number of entries currently in the heap */
    public int getSize();


    /** Removes all entries from this heap. */
    public void clear();


} // end MaxHeapInterface