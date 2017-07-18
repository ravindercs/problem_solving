package com.ood.di;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravinderk on 6/29/2017.
 */
public class VoteWinnerFinder {
    public static void main(String[] args) {
        System.out.println(findWinner(new String[]{"Alex","John","Alex","Mia","Sunny"}).equals("Alex"));
        System.out.println(findWinner(new String[]{"Alex","John","Alex","Mia","Sunny","Sunny"}).equals("Sunny"));
    }

    private static String findWinner(String[] ballot) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0 ; i < ballot.length; i++){
            if(!map.containsKey(ballot[i])) {
                map.put(ballot[i],1);
            } else {
                map.put(ballot[i],map.get(ballot[i])+1);
            }
        }

        List<String> winner = new LinkedList<>();
        int maxVotes = Integer.MIN_VALUE;
        for (String key : map.keySet()){
            int votes = map.get(key);
            maxVotes = maxVotes < votes ? votes : maxVotes;
        }

        for (String key : map.keySet()){
            if(map.get(key) == maxVotes) {
                winner.add(key);
            }
        }

        Collections.sort(winner);

        return winner.get(winner.size()-1);
    }
}
