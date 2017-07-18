package com.ood.di;

import java.util.*;

/**
 * Created by ravinderk on 6/20/2017.
 */
/*
Given an array of words, print the count of
all anagrams together in sorted order (increasing order of counts).
For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”},
then grouped anagrams are “(dog, god) (cat, tac, act)”. So the output will be 2 3
 */
public class FindAnagramsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            List<String> words = new LinkedList<>();
            for (int i = 0 ; i < n; i++) {
                words.add(sc.next());
            }

            findAnagrams(words);
        }
    }

    private static void findAnagrams(List<String> words) {
        List<Integer> anaCount = new ArrayList<>();
        while (!words.isEmpty()) {
            String w = words.get(0);
            List<String> anagrams = new LinkedList<>();
            anagrams.add(w);
            for (int i = 1 ; i < words.size(); i++) {
                if(w.length() != words.get(i).length()) { continue; }
                boolean isAnagram = true;
                int[] count = new int[26];//Only works for small characters
                for (int j = 0 ; j < w.length(); j++) {
                    count[w.charAt(j) - 'a']++;
                }
                for (int j = 0 ; j < w.length(); j++) {
                    count[words.get(i).charAt(j) - 'a']--;
                    if(count[words.get(i).charAt(j) - 'a'] < 0) {
                        isAnagram = false; break;
                    }
                }

                if(isAnagram) {
                    anagrams.add(words.get(i));
                }
            }
            anagrams.forEach( a -> words.remove(a));
            anaCount.add(anagrams.size());
        }

        Collections.sort(anaCount);
        anaCount.forEach(a -> System.out.print(a+" "));
        System.out.println();
    }
}
