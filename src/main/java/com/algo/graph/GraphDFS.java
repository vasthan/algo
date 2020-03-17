package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的深度优先遍历
 */
public class GraphDFS {

    private Graph g;
    // 存放深度优先遍历的结果
    private List<Integer> preOrder = new ArrayList<>();
    private List<Integer> postOrder = new ArrayList<>();
    // 标记已遍历过的点
    private boolean[] visited;

    public GraphDFS(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        preOrder.add(v);
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        postOrder.add(v);
    }

    public List<Integer> preOrder() {
        return preOrder;
    }

    public List<Integer> postOrder() {
        return postOrder;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        GraphDFS dfs = new GraphDFS(g);
        System.out.println(dfs.preOrder());
        System.out.println(dfs.postOrder());
    }
}
