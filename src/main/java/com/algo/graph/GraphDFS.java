package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {

    private Graph g;
    // 存放深度优先遍历的结果
    private List<Integer> order = new ArrayList<>();
    // 标记已遍历过的点
    private boolean[] visited;

    public GraphDFS(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        dfs(0);
    }

    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public List<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        GraphDFS dfs = new GraphDFS(g);
        System.out.println(dfs.order);
    }
}
