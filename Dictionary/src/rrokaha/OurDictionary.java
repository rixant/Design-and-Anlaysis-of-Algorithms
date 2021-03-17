/***
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * March 12
 * Assignment 16
 */

package rrokaha;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OurDictionary<K extends Comparable<K>,V> implements DictionaryInterface<K,V> {

    //List of unsorted search keys
    private List<K> keys;
    //Parallel list of values corresponding to the search keys
    private List<V> values;

    //Default constructor
    public OurDictionary() {
        keys=new ArrayList<>();
        values=new ArrayList<>();
    }
    //Constructor
    public OurDictionary(int initialCapacity) {
        keys=new ArrayList<>(initialCapacity);
        values=new ArrayList<>(initialCapacity);
    }

    @Override
    public V add(K key, V value) {
        if((key==null) || value==null)
            throw new IllegalArgumentException("Cannot add null to a dictionary");
        else{
            V result=null;
            int keyIndex=keys.indexOf(key);
            if(keyIndex>-1 && keyIndex<keys.size()) {
                //Key found,return and replace entry's value
                result = values.set(keyIndex, value);
            }
            else{
                //Key not found and add a new entry to dictionary
                keys.add(key);
                values.add(value);
            }
            return result;
        }
    }

    @Override
    public V remove(K key) {
        V result=null;
        int keyIndex=keys.indexOf(key);
        if(keyIndex>-1 && keyIndex<keys.size()) {
            //Key found,remove entry and replace entry's value
            keys.remove(keyIndex);
            result=values.remove(keyIndex);
        }
        return result;
    }

    @Override
    public V getValue(K key) {
        //Initialize results object type V
        V result=null;
        //Retrieve in index of key
        int keyIndex=keys.indexOf(key);

        //Check to see if key is found
        if(keyIndex>-1 && keyIndex<keys.size()) {
            //if key found, initialize result object to entry in value list
            result=values.get(keyIndex);
        }
        //return result object
        return result;

    }

    @Override
    public boolean contains(K key) {
        //Return the results from the contains method from key list
        return keys.contains(key);
    }

    @Override
    public Iterator<K> getKeyIterator() {
        //Return the results from the iterator method from key list
        return keys.iterator();
    }

    @Override
    public Iterator<V> getValueIterator() {
        //Return the results from the iterator method from key list
        return values.iterator();
    }

    @Override
    public boolean isEmpty() {
        //return the results from the isEmpty method from keys and values lists
        return getSize()==0 || keys.isEmpty();
    }

    @Override
    public int getSize() {
        //return the results from the isEmpty method from keys and values lists
        return keys.size();
    }

    @Override
    public void clear() {
        //clears the results from the clear method from keys and values lists
        keys.clear();
        values.clear();
    }


}


