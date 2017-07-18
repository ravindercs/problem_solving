package com.ood.di;

import java.util.LinkedHashMap;

/**
 * Created by ravinderk on 7/1/2017.
 */
public class WordFinder {
    private static int SIZE = 26; //only small alphabets

    public static void main(String[] args) {
        String s = "abcab";
        int count = 0;
        int[] f = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            count = count + 2;
            f[s.charAt(i)-'a']++;
        }
    }

    private static void testWords(){
        String[] dict = {"go","bat","me","eat","goal", "boy", "run"};
        TrieNode root = createTrie(dict);
        char[] arr = {'e','o','b', 'a','m','g', 'l'};
        boolean[] hash = new boolean[SIZE];
        for (int i = 0 ; i < arr.length; i++) {
            hash[arr[i]-'a'] = true;
        }
        printValidWords(root,hash,"");
    }
    private static void printValidWords(TrieNode root, boolean[] hash, String word) {
        if(root.isLeaf) {
            System.out.println(word);
        }

        for (int i = 0 ; i < SIZE; i++) {
            if(hash[i] && root.children[i] != null) {
                printValidWords(root.children[i],hash, word+(char)(i+'a'));
            }
        }
    }

    private static TrieNode createTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (int i = 0 ; i < dict.length; i++) {
            insertWord(root, dict[i]);
        }
        return root;
    }

    private static void insertWord(TrieNode root, String word) {
        TrieNode curNode = root;
        for (int i = 0 ; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curNode.children[index] == null) {
                curNode.children[index] = new TrieNode();
            }
            curNode = curNode.children[index];
        }
        curNode.isLeaf = true;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[SIZE];
        boolean isLeaf = false;
    }
}
