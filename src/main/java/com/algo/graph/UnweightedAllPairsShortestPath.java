package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.List;

/**
 * BFS求所有点对最短路径
 */
public class UnweightedAllPairsShortestPath {

    private Graph G;
    private UnweightedSingleSourceShortestPath[] paths;

    public UnweightedAllPairsShortestPath(Graph g) {
        this.G = g;
        paths = new UnweightedSingleSourceShortestPath[G.getV()];
        for (int v = 0; v < g.getV(); v++) {
            paths[v] = new UnweightedSingleSourceShortestPath(G, v);
        }
    }

    public boolean isConnected(int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);
        return paths[s].isConnectedTo(t);
    }

    public List<Integer> path(int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);
        return paths[s].path(t);
    }

    public int distance(int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);
        return paths[s].distance(t);
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/bfs.txt");
        UnweightedAllPairsShortestPath path = new UnweightedAllPairsShortestPath(g);
        System.out.println("1 -> 6 : " + path.path(1, 6));
        System.out.println(path.distance(1, 6));
    }
}
