/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 25 April 2021
 * Assignment 11
 */

package rrokaha;

import java.util.Iterator;

//An interface of iterators for the ADT tree.
public interface TreeIteratorInterface<T>
{
    public Iterator<T> getPreorderIterator();
    public Iterator<T> getPostorderIterator();
    public Iterator<T> getInorderIterator();
    public Iterator<T> getLevelOrderIterator();
} // end TreeIteratorInterface
