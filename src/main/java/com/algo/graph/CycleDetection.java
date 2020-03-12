package com.algo.graph;

import com.datastruct.graph.Graph;

public class CycleDetection {

    private Graph G;
    private boolean[] visited;

    public CycleDetection(Graph g) {
        this.G = g;
        this.visited = new boolean[G.getV()];
    }

    public boolean hasCycle() {
        for (int v = 0; v < G.getV(); v++) {
            if (!visited[v]) {
                if (dfs(v, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从顶点v开始，检测图中是否有环
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        CycleDetection cd = new CycleDetection(g);
        System.out.println(cd.hasCycle());

        Graph g2 = new Graph("src/main/resources/g2.txt");
        CycleDetection cd2 = new CycleDetection(g2);
        System.out.println(cd2.hasCycle());
    }
}
