package com.DataStructures.com;
// Creating our own Array class

public class Array {
    private int items[]; // We store our items ina a regular Array
    private int count; // Initially 0

    public Array(int length) {
        items = new int [length];
    }

    public void print() {
        //for (int i = 0; i < items.length; i++)
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    // O(n)
    public void insert(int item) {
        //If the array is full, resize it
        if (items.length == count){
            //create a new array (twice the size)
            int[] newItems = new int[count * 2];

            //copy all the existing items
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            //set "items" to this new array
            items = newItems;
        }

        //Add the new item at the end
        items[count++] = item; // It adds the item at count, and then increments count
        // Or:
        // items[count] = item;
        // count++; // Both work
    }

    // O(n)
    public void removeAt(int index) {
        // validate the index (removing the last part of the array when a value has been deleted)
        if (index < 0 || index >= count)
            throw new IllegalArgumentException(); //used to break the loop when an illegal number is added (too big/small)

        //Shift the items to the left to fill the hole
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--; // We shrink the array
    }

    // Best Case Runtime Complexity O(1)
    // Worst Case: O(n)
    // Therefore, it's O(n)
    public int indexOf (int item) { //A method that is not void always returns a value
        //If we find it, return index
        //Otherwise, return -1
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i; //return is used to end the execution of a method when its execution is complete

        return -1;
    }

}

