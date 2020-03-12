package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 求在图中，源顶点source到目标顶点target的路径
// 提前结束递归，路径问题优化
public class Path {
    private Graph G;
    private int s;
    private int t;
    private boolean[] visited;
    private int[] pre;

    public Path(Graph graph, int source, int target) {
        graph.validateVertex(source);
        graph.validateVertex(target);
        this.G = graph;
        this.s = source;
        this.t = target;
        this.visited = new boolean[graph.getV()];
        this.pre = new int[graph.getV()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(s, s);
    }

    // 搜索从顶点v到顶点t是否有路径
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        if (v == t) {
            return true;
        }
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isConnected() {
        return visited[t];
    }

    public List<Integer> path() {
        List<Integer> path = new ArrayList<>();
        if (!isConnected()) {
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

    public void printVisited() {
        System.out.println(Arrays.toString(visited));
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        Path path = new Path(g, 0, 6);
        path.printVisited();
        System.out.println("0 -> 6 : " + path.path());

        path = new Path(g, 0, 1);
        path.printVisited();
        System.out.println("0 -> 1 : " + path.path());

    }
}
