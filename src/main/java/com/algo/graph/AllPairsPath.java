package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.List;

// 所有点对路径问题
public class AllPairsPath {

    private Graph G;
    private SingleSourcePath[] paths;

    public AllPairsPath(Graph g) {
        this.G = g;
        paths = new SingleSourcePath[g.getV()];
        for (int v = 0; v < G.getV(); v++) {
            paths[v] = new SingleSourcePath(G, v);
        }
    }

    public boolean isConnectedTo(int s, int t) {
        G.validateVertex(s);
        return paths[s].isConnectedTo(t);
    }

    public List<Integer> path(int s, int t) {
        G.validateVertex(s);
        return paths[s].path(t);
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        AllPairsPath paths = new AllPairsPath(g);
        System.out.println(paths.isConnectedTo(6, 0));
        System.out.println("6 -> 0 : " + paths.path(6, 0));
    }
}
