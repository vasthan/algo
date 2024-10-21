package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.Arrays;

/**
 * 二分图检测
 */
public class BiPartitionDetection {

    private Graph g;
    // 表示每个顶点是否被遍历过
    private boolean[] visited;
    // 表示每个顶点的染色情况
    private int[] colors;
    private boolean isBiPartition = true;

    public BiPartitionDetection(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        this.colors = new int[g.getV()];
        Arrays.fill(colors, -1);
        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) {
                if (!dfs(v, 0)) {
                    isBiPartition = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else if (colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBiPartition() {
        return isBiPartition;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/no_bipartition.txt");
        BiPartitionDetection biPartitionDetection = new BiPartitionDetection(g);
        System.out.println(biPartitionDetection.isBiPartition());

    }
}
