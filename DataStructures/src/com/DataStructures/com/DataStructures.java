package com.DataStructures.com;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

//https://www.youtube.com/watch?v=BBpAmxU_NQo&list=PLvxuqxA4YloD_0xkY6QYpA9PwZ4WeT-Ut&index=9

public class DataStructures {
    public static void main(String[] args) {
        //Testing our array class:
//        Array numbers = new Array(3);
//        numbers.insert(10);
//        numbers.insert(20);
//        numbers.insert(30);
//        numbers.insert(40);
//        numbers.removeAt(1);
//        System.out.println(numbers.indexOf(100));
//        numbers.print();

        //Example of the actual LinkedList;
//        java.util.LinkedList list = new java.util.LinkedList();// We don't specify its data type
//        list.addLast(10);
//        list.addLast(20);
//        list.add(30);
//        list.addFirst(5);
//        System.out.println(list.contains(20));
//        System.out.println(list.indexOf(20));
//        System.out.println(list.size());
//        System.out.println(list);

        //Testing our LinkedList class (using the debugger);
//        LinkedList list = new LinkedList();
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
//        list.removeFirst();
//        System.out.println(list.indexOf(20));
//        list.removeLast();
//        System.out.println(list.contains(10));


        //System.out.println(35.6 % 10);


        vigenereDecrypter("tsmvmmppcwczugxhpecprfaueiobqwppimsfxipctsqpksznulopacrddpktslvfweltkrghizsfnidfarmuenoskrgdiphwsgvledmcmsmwkpiyojstlvfahpbjiraqiwhldgaiyoux", "alice");




    }













    public static String vigenereDecrypter(String s, String key) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
        map.put("g", 6);
        map.put("h", 7);
        map.put("i", 8);
        map.put("j", 9);
        map.put("k", 10);
        map.put("l", 11);
        map.put("m", 12);
        map.put("n", 13);
        map.put("o", 14);
        map.put("p", 15);
        map.put("q", 16);
        map.put("r", 17);
        map.put("s", 18);
        map.put("t", 19);
        map.put("u", 20);
        map.put("v", 21);
        map.put("w", 22);
        map.put("x", 23);
        map.put("y", 24);
        map.put("z", 25);

        Map<Integer, String> keyMap = new HashMap<>();
        keyMap.put(0, "a");
        keyMap.put(1, "b");
        keyMap.put(2, "c");
        keyMap.put(3, "d");
        keyMap.put(4, "e");
        keyMap.put(5, "f");
        keyMap.put(6, "g");
        keyMap.put(7, "h");
        keyMap.put(8, "i");
        keyMap.put(9, "j");
        keyMap.put(10, "k");
        keyMap.put(11, "l");
        keyMap.put(12, "m");
        keyMap.put(13, "n");
        keyMap.put(14, "o");
        keyMap.put(15, "p");
        keyMap.put(16, "q");
        keyMap.put(17, "r");
        keyMap.put(18, "s");
        keyMap.put(19, "t");
        keyMap.put(20, "u");
        keyMap.put(21, "v");
        keyMap.put(22, "w");
        keyMap.put(23, "x");
        keyMap.put(24, "y");
        keyMap.put(25, "z");

        StringBuilder ans = new StringBuilder();
        int j = 0; //Looping though the key

        for(int i = 0; i<s.length(); i++){
            int cyphValue = s.charAt(map.get(i));

            int keyValue = key.charAt(map.get(j));
            j++;
            if(j == 4){
                j = 0;
            }

            int finalValue = cyphValue - keyVal;
            String finalLetter = keyMap.get(finalValue);

            ans.append(finalLetter);



        }


        return ans.toString();
    }












}
