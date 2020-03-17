package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.*;

/**
 * 广度优先遍历求解单源路径问题
 */
public class SingleSourcePathBFS {

    private Graph G;
    private int s;
    private boolean[] visited;
    // 保存遍历路径中每个顶点的上个顶点
    private int[] pre;

    // 从源点s开始搜索路径
    public SingleSourcePathBFS(Graph g, int s) {
        g.validateVertex(s);
        this.G = g;
        this.s = s;
        this.visited = new boolean[g.getV()];
        this.pre = new int[g.getV()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;
                }
            }
        }
    }

    public boolean isConnectTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public List<Integer> path(int t) {
        List<Integer> res = new ArrayList<>();
        if (!isConnectTo(t)) {
            return res;
        }

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph("src/main/resources/bfs.txt");
        SingleSourcePathBFS ssp = new SingleSourcePathBFS(g, 0);
        System.out.println(ssp.isConnectTo(4));
        System.out.println("0 -> 4 : " + ssp.path(4));
    }
}
