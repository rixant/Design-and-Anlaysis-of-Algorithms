/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 12 February 2021
 * Assignment 3
 */


package rrokaha;

public abstract class LinkedChainBase<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedChainBase(){
        initializeDataFields();
    }


    protected final void initializeDataFields(){
        firstNode = null;
        numberOfEntries = 0;
    }


    protected final void addFirstNode(Node newNode){
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;

    }

    protected final void addAfterNode(Node nodeBefore,Node newNode){
        Node nodeAfter = nodeBefore.getNext();
        nodeBefore.setNext(newNode);
        newNode.setNext(nodeAfter);
        numberOfEntries++;

    }

    protected final T removeFirstNode(){
        Node nodeToRemove = firstNode;
        Node nodeAfter = firstNode.getNext();
        firstNode = nodeAfter;
        numberOfEntries--;
        return nodeToRemove.getData();

    }

    protected final  T removeAfterNode(Node nodeBefore){
        Node nodeToRemove = nodeBefore.getNext();
        Node nodeAfter = nodeToRemove.getNext();
        nodeBefore.setNext(nodeAfter);
        numberOfEntries--;
        return nodeToRemove.getData();

    }


    protected Node getNodeAt(int givenPosition)
    {

        Node currentNode = firstNode;
        if(givenPosition==1){
            return currentNode;
        }else {
            for (int i = 2; i <= givenPosition; i++)
                currentNode = currentNode.getNext();
                return currentNode;
        }
    }


    public final void clear(){
        firstNode = null;
        numberOfEntries=0 ;

    }

    public int getLength(){
        return numberOfEntries;

    }

    public Node getFirstNode(){
        return firstNode;

    }

    public boolean isEmpty(){
        return firstNode==null;

    }

    public T[] toArray(){
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }
        return result;

    }


    protected final class Node{
        private T data;
        private Node next;

        protected Node( T dataPortion){
            data = dataPortion;
            next = null;
        }

        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;

        }


        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
