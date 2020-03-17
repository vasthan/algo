package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 深度优先遍历求解单源路径问题
 */
public class SingleSourcePath {

    private Graph G;
    private boolean[] visited;
    private int s;
    // 记录访问路径中的上一个顶点
    private int[] pre;

    // 求出在图 G 中，从源 s 到任意顶点的路径（无路径则返回空数组）
    public SingleSourcePath(Graph g, int s) {
        g.validateVertex(s);
        this.G = g;
        this.s = s;
        this.pre = new int[G.getV()];
        this.visited = new boolean[G.getV()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(s, s);
    }

    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
            }
        }
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public List<Integer> path(int t) {
        G.validateVertex(t);
        List<Integer> path = new ArrayList<>();
        if (!isConnectedTo(t)) {
            return path;
        }

        int cur = t;
        while (cur != s) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        SingleSourcePath ssPath = new SingleSourcePath(g, 0);
        System.out.println(ssPath.isConnectedTo(6));
        System.out.println(ssPath.isConnectedTo(5));

        System.out.println("0 -> 6 : " + ssPath.path(6));
        System.out.println("0 -> 5 : " + ssPath.path(5));
    }
}
