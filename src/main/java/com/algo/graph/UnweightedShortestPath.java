package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.*;

/**
 * BFS求解两点最短路径，找到提前返回
 */
public class UnweightedShortestPath {
    private Graph G;
    private int s;
    private int t;
    private int[] pre;
    private boolean[] visited;

    public UnweightedShortestPath(Graph g, int s, int t) {
        g.validateVertex(s);
        g.validateVertex(t);
        this.G = g;
        this.s = s;
        this.t = t;
        this.visited = new boolean[G.getV()];
        this.pre = new int[G.getV()];
        for (int v = 0; v < G.getV(); v++) {
            pre[v] = -1;
        }

        bfs(s);

        for (int v = 0; v < G.getV(); v++) {
            System.out.print(visited[v] + " ");
        }
        System.out.println();

        for (int v = 0; v < G.getV(); v++) {
            System.out.print(pre[v] + " ");
        }
        System.out.println();
    }

    private boolean bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;
        if (s == t) {
            return true;
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;

                    if (w == t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isConnected() {
        return visited[s] && visited[t];
    }

    public List<Integer> path() {
        List<Integer> res = new ArrayList<>();
        if (!isConnected()) {
            return res;
        }
        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/bfs.txt");
        UnweightedShortestPath path = new UnweightedShortestPath(g, 5, 6);
        System.out.println(path.isConnected());
        System.out.println(path.path());
    }
}
