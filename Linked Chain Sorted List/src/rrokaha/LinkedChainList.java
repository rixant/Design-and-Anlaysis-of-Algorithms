/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 12 February 2021
 * Assignment 3
 */

package rrokaha;

public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        Node nodeBefore = getNodeBefore(newEntry);
        if (nodeBefore == null)
            addFirstNode(newNode);
        else
        addAfterNode(nodeBefore, newNode);

    }

    @Override
    public void add(int newPosition, T newEntry) {
        if((newPosition <= getLength()) && (newPosition >= 1)) {
            Node newNode = new Node(newEntry);
            Node desiredNode = getNodeAt(newPosition-1);
            if (newPosition == 1) {
                addFirstNode(newNode);
            } else {
                addAfterNode(desiredNode, newNode);
            }
        }
        else{
            throw new IndexOutOfBoundsException("position given to remove operation ");
        }

    }

    private Node getNodeBefore(T anEntry) {
        Node currentNode = getFirstNode();
        Node nodeBefore = null;
        while (currentNode != null)
        {
            nodeBefore = currentNode;
            currentNode = currentNode.getNext();
        }
        return nodeBefore;
    }

    @Override
    public T remove(int givenPosition) {
        if((givenPosition <= getLength()) && (givenPosition >= 1)){
        Node nodeToRemove = getNodeAt(givenPosition-1);
        T removedData = null;
        if(nodeToRemove==getFirstNode()) {
            removedData = removeFirstNode();
        }
        else{
            removedData = removeAfterNode(nodeToRemove);}

        return removedData;}
        else{
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }


    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        if((givenPosition >= 1)&&(givenPosition <= getLength())){
            Node desireNode = getNodeAt(givenPosition);
            T originalEntry = desireNode.getData();
            desireNode.setData(newEntry);
            return originalEntry;
        }
        else{
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= getLength()))
        {
            return getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        Node currentNode = getFirstNode();
        while (currentNode != null){
            if(currentNode.getData() == anEntry) {
                result = true;
                break;
            }
            else{

                currentNode = currentNode.getNext();

            }
        }
        return result;
    }
}
