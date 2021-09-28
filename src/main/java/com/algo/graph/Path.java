package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 求在图中，源顶点source到目标顶点target的路径
// 提前结束递归，路径问题优化
public class Path {

    private Graph g;
    // source
    private int s;
    // target
    private int t;
    // 记录每一个顶点是否访问过，可以优化，用pre数组代替
    private boolean[] visited;
    // 记录每一个顶点的前一个顶点
    private int[] pre;

    // 任意两点间的路径，一次性
    public Path(Graph g, int s, int t) {
        g.validateVertex(s);
        g.validateVertex(t);
        this.g = g;
        this.s = s;
        this.t = t;
        this.visited = new boolean[g.getV()];
        this.pre = new int[g.getV()];
        Arrays.fill(pre, -1);
        dfs(s, s);
        System.out.println(Arrays.toString(visited));
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        if (v == t) {
            // 遍历到t，表示有路径
            return true;
        }
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    // s和t是否相联通
    public boolean isConnected() {
        return visited[t];
    }

    // s到t的路径
    public List<Integer> path() {
        List<Integer> p = new ArrayList<>();
        if (!isConnected()) {
            return p;
        }
        int cur = t;
        while (cur != s) {
            p.add(cur);
            cur = pre[cur];
        }
        p.add(s);
        Collections.reverse(p);
        return p;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/g.txt");
        Path path = new Path(g, 0, 1);
        System.out.println("0 -> 1 is connected? " + path.isConnected());
        System.out.println("0 -> 1 path: " + path.path());

        Path path2 = new Path(g, 0, 6);
        System.out.println("0 -> 6 is connected? " + path2.isConnected());
        System.out.println("0 -> 6 path: " + path2.path());

        Path path3 = new Path(g, 0, 5);
        System.out.println("0 -> 5 is connected? " + path3.isConnected());
        System.out.println("0 -> 5 path: " + path3.path());
    }
}
