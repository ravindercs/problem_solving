package com.ood.di;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravinderk on 6/19/2017.
 */
/*
Given a sorted dictionary of an alien language having N words and
k starting alphabets of standard dictionary the task is to complete
 the function which returns a string denoting the order of characters in the language.

Create a list from starting chars. Check size if equal to k.
Now read next char from all the strings which starts with first char of list. if missing add it
ar proper index.
Now check the size of list is equal to k.
Now do the same for remaining chars in list.

Input:  Dict[] =
{ "baa",
  "abcd",
  "abca",
  "cab",
  "cad"
}, k = 4

   |b|      |a|       |c|
|a|-|-|-| |b|
|a|-|-|-| |c|
list -> b -> a -> c  => 3 < k
list -> 1 ...2.. b -> d -> a -> c => 4 == k
Recursive nature
 */
public class AlientDictionary {
    public static void main(String[] args) {

    }

//    List<Character> getOrderedChars(String[] words) {
//        List<Character> orderList = getOrderedChars(words, 0, words.length-1, 0);

//        return orderList;
//    }

//    private List<Character> getOrderedChars(String[] words, int i, int j, int k) {
//        if(i > j) return new ArrayList<>();
//        List<Character> list = new ArrayList<>();
//        for (int it = i; it <= j; it++) {
////            if(k < words[it].length() && !orderList.contains(words[it].charAt(k))) {
//
////            }
//        }
//    }
}
