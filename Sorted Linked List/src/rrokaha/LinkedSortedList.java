/**
 * Rishant Rokaha
 *Professor Vohra
 * Design and Analysis Of Algorithms
 * 6 February 2021
 * Assignment 2
 */

package rrokaha;

public class LinkedSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedSortedList(){
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        Node nodeBefore = getNodeBefore(newEntry);

        if(isEmpty()||nodeBefore==null){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
        else{
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);

        }
        numberOfEntries++;

    }


    private Node getNodeBefore(T anEntry){
        Node currentNode = firstNode;
        Node nodeBefore = null;

        while((currentNode != null) && (anEntry.compareTo(currentNode.getData())>0)){
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();

        }
        return nodeBefore;
    }

    @Override
    public boolean remove(T newEntry) {
        boolean result = false;
        int position = getPosition(newEntry);
        if ((position >= 1) && (position <= numberOfEntries))
        {
            if (position == 1)
            {
                firstNode = firstNode.getNextNode();
            }
            else
            {
                Node nodeBefore =  getNodeAt(position - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = true;
            }
            numberOfEntries--;
            return result;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    private Node getNodeAt(int givenPosition)
    {

        Node currentNode = firstNode;


        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
        return currentNode;
    }




    @Override
    public int getPosition(T anEntry) {
       Node currentNode = firstNode;
       int result = 0;
       for(int i=1; i<=numberOfEntries; i++){
           if(currentNode.getData()== anEntry ){
               result = i;
               break;

           }else{
               currentNode =currentNode.getNextNode();

           }
       }
       return result;

    }

    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            return getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        Node currentNode = firstNode;
        while (currentNode != null){
            if(currentNode.getData() == anEntry) {
                result = true;
                break;
            }
            else{

                currentNode = currentNode.getNextNode();

            }
        }
        return result;
    }

    @Override
    public void clear() {
        firstNode=null;
        numberOfEntries=0;

    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return firstNode==null && numberOfEntries==0;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Comparable[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }



    private class Node{
        private T data;
        private Node nextNode;

        private Node(T dataPortion){
            data = dataPortion;
            nextNode = null;
        }


        private Node (T dataPortion, Node next){
            data = dataPortion;
            nextNode = next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public T getData() {
            return data;
        }

        public Node getNextNode() {
            return nextNode;
        }
    }



}