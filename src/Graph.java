package com.ood.di;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravinderk on 6/25/2017.
 */
public class Graph {
    List<Integer>[] v;
    boolean directed = false;
    public Graph(int v, boolean directed) {
        this.v = new List[v];
        for (int i = 0 ; i < v; i++) {
            this.v[i] = new LinkedList<>();
        }
        this.directed = directed;
    }

    public void addEdge(int a, int b){
        v[a].add(b);
        if(!directed) {
            v[a].add(b);
        }
    }

    public int getVeticeCount() {
        return v.length;
    }

    public List<Integer> getAdjacentEdges(int s) {
        return v[s];
    }
}
