package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;

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

    // 查询联通分量个数
    public int count() {
        return count;
    }

    // 判断两个顶点是否在一个联通分量中
    public boolean isConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    // 获取每个联通分量及它拥有的顶点
    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] components = new ArrayList[count];
        for (int i = 0; i < components.length; i++) {
            components[i] = new ArrayList<>();
        }
        for (int v = 0; v < visited.length; v++) {
            components[visited[v]].add(v);
        }
        return components;
    }

    public static void main(String[] args) {
        CC cc = new CC(new Graph("src/main/resources/g.txt"));

        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(0, 5));
        ArrayList<Integer>[] components = cc.components();
        for (int ccId = 0; ccId < components.length; ccId++) {
            System.out.println(ccId + " : " + components[ccId]);
        }
    }

}
