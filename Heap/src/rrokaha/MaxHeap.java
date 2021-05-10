/**Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 4th May 2020
 * Assignment 13
 */


package rrokaha;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {


    private T[] heap; //Array of heap entries, ignore heap[0]
    private int lastIndex; //Index of last entry and number of entries
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;


    //constructor
    public  MaxHeap(){
        this(DEFAULT_CAPACITY); // Call next constructor
    }// end default constructor


    //constructor
    public  MaxHeap(int initialCapacity){
        integrityOK = false;
        checkCapacity(initialCapacity);

        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    }

    //checks if the heap is full
    private void checkCapacity(int capacity){
        if(capacity < DEFAULT_CAPACITY)
            throw new IllegalStateException();
        else if(capacity > MAX_CAPACITY)
            throw new IllegalStateException();
    }//end checkCapacity


    @Override
    public void add(T newEntry) {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;

        while( (parentIndex > 0) && (newEntry.compareTo(heap[parentIndex]) > 0) ){
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }//end while

        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }//end add


    @Override
    public T removeMax() {
        checkIntegrity();;
        T root = null;
        if(!isEmpty()){
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }//end removeMax


    @Override
    public T getMax() {
        checkIntegrity();
        T root = null;
        if(!isEmpty()){
            root = heap[1];
        }
        return root;
    }//end getMax


    @Override
    public boolean isEmpty() {

        return lastIndex < 1;
    }//end isEmpty


    @Override
    public int getSize() {

        return lastIndex;
    }//end getSize


    @Override
    public void clear() {
        checkIntegrity();
        while (lastIndex > -1){
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }//end clear


    // Transforms the semiheap rooted at rootIndex into a heap
    public void reheap(int rootIndex){
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while(!done && (leftChildIndex >= lastIndex)){
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if( (rightChildIndex <= lastIndex) && (heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)){
                largerChildIndex = rightChildIndex;
            }//end if

            if(orphan.compareTo(heap[largerChildIndex]) < 0){
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else{
                done = true;
            }//end if-else
        }//end while

        heap[rootIndex] = orphan;
    }//end method reheap


    /** Doubles the capacity of the array heap oif it is full */
    private void ensureCapacity(){
        int numberOfEntries = lastIndex;
        int capacity = heap.length - 1;
        if(numberOfEntries >= capacity){
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity + 1);
        }//end if
    }//end method ensureCapacity


    // Ensure initialization of data fields
    private void checkIntegrity(){
        if(!integrityOK)
            throw new SecurityException();
    }//end if


}//end class



