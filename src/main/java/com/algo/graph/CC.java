package com.algo.graph;

import com.datastruct.graph.Graph;

/**
 * Connected Component联通分量
 */
public class CC {
    private Graph G;
    // 联通分量个数
    private int count;
    private int[] visited;

    public CC(Graph g) {
        this.G = g;
        this.visited = new int[g.getV()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        for (int v = 0; v < g.getV(); v++) {
            if (visited[v] == -1) {
                dfs(v, count);
                count++;
            }
        }
    }

    private void dfs(int v, int ccId) {
        visited[v] = ccId;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, ccId);
            }
        }
    }

    public int count() {
        for (int i : visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        CC cc = new CC(new Graph("src/main/resources/g.txt"));
        System.out.println(cc.count());
    }

}
