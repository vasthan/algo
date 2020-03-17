package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图的广度优先遍历
 */
public class GraphBFS {

    private Graph G;
    private boolean[] visited;
    private List<Integer> order = new ArrayList<>();

    public GraphBFS(Graph g) {
        this.G = g;
        this.visited = new boolean[g.getV()];

        for (int v = 0; v < G.getV(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public List<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/bfs.txt");
        GraphBFS bfs = new GraphBFS(g);
        System.out.println(bfs.order());
    }
}
