package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.*;

/**
 * BFS求无权图单源最短路径问题
 */
public class UnweightedSingleSourceShortestPath {

    private Graph G;
    private int s;
    // 保存每个顶点是否遍历过
    private boolean[] visited;
    // 保存每个顶点的上一个点
    private int[] pre;
    // 保存每个顶点到源点的距离
    private int[] dis;

    public UnweightedSingleSourceShortestPath(Graph g, int s) {
        g.validateVertex(s);
        this.G = g;
        this.s = s;
        this.visited = new boolean[G.getV()];
        this.pre = new int[G.getV()];
        this.dis = new int[G.getV()];
        for (int i = 0; i < G.getV(); i++) {
            pre[i] = -1;
            dis[i] = -1;
        }
        bfs(s);

        // 打印每个点到原点s的距离
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i] + " ");
        }
        System.out.println();
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public List<Integer> path(int t) {
        List<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t)) {
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

    public int distance(int t) {
        G.validateVertex(t);
        return dis[t];
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;
        dis[s] = 0;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;
                    dis[w] = dis[v] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph("src/main/resources/bfs.txt");
        UnweightedSingleSourceShortestPath path = new UnweightedSingleSourceShortestPath(g, 1);
        System.out.println(path.isConnectedTo(6));
        System.out.println("1 -> 6 : " + path.path(6));
        System.out.println(path.distance(6));
    }
}
