/**Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 4th May 2020
 * Assignment 13
 */

package rrokaha;

public class Driver {

    public static void main(String[] args) {

        MaxHeapInterface<Integer> Heap = new MaxHeap();

        System.out.println("Is Heap Empty? : "+Heap.isEmpty());

        Heap.add(1);
        Heap.add(4);
        Heap.add(47);
        Heap.add(12);
        Heap.add(87);
        Heap.add(15);
        Heap.add(29);
        Heap.add(76);
        Heap.add(44);
        Heap.add(23);
        Heap.add(38);
        System.out.println("Heaps added.....");

        System.out.println("Is Heap Empty? : "+Heap.isEmpty());

        System.out.println("Heap Size : "+Heap.getSize());

        System.out.println("Max Heap : "+Heap.getMax());

        System.out.println("Removed MaxHeap : "+Heap.removeMax());

        System.out.println("Heap cleared .......");
        Heap.clear();

        System.out.println("Is Heap Empty? : "+Heap.isEmpty());
    }
}
