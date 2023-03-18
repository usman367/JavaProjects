package com.DataStructures.com;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int item){
        Node node = new Node(item);

        //If the LinkedLIst is empty, set its first and last pointers to this node
        if(isEmpty() )
            first = last = node;
        else{
            last.next = node; // The last node will point to this node
            last = node; // We set the last node to this node
        }

    }


    public void addFirst(int item){
        var node = new Node(item); // Instead of writing Node twice, we can write var and it will give it the same data type we say after =

        //If the LinkedLIst is empty, set its first and last pointers to this node
        if(isEmpty())
            first = last = null;
        else{
            node.next = first; // We want this node to point to our first node
            first = node; // We set the first node to this node
        }
    }

    // To check if the first node is empty
    // Returns true if it is
    public boolean isEmpty(){
        return first == null;
    }


    public int indexOf(int item){
        int index = 0;

        var current = first;
        while (current != null){
            if (current.value == item)
                return index;

            current = current.next; // Otherwise sets current to the next node
            index++; // Increments the index
        }

        return -1; // Otherwise, the element doesn't exist
    }


    public boolean contains(int item){
        // It returns true if the indexOf() method above doesn't return -1
        return indexOf(item) != -1;
    }


    public void removeFirst(){
        // [10 -> 20 -> 30]

        //If the list is empty, throw an exception
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        // If theres only 1 node in the list
        if(first == last){
            first = last = null; // Sets first and last to null
            return; // Ends the execution of the method
        }

        var second = first.next; // Points to 20
        first.next = null; // Removes the link between the first and the 2nd element
        first = second;
    }


    public void removeLast(){
        // [10 -> 20 -> 30]
        // last -> 30 should become last -> 20

        //If the list is empty, throw an exception
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        // If theres only 1 node in the list
        if(first == last){
            first = last = null; // Sets first and last to null
            return; // Ends the execution of the method
        }

        // Gets the node before the last node
        // previous -> 20
        var previous = getPrevious(last);
        last = previous; // Sets the last to the previous node, previous -> 20
        last.next = null; // Removes the link between the new last node and the previous last node, last -> 20
    }


    // Gets the previous node
    private Node getPrevious(Node node){
        var current = first;
        while (current != null){
            if(current.next == node)
                return current; // If the next node is equal to their node, return this node

            current = current.next;
        }

        return null;
    }





}
