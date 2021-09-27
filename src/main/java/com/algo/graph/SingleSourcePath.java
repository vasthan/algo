package com.algo.graph;

import com.datastruct.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 深度优先遍历求解单源路径问题
 */
public class SingleSourcePath {

    private Graph g;
    private int s;
    // 记录每个顶点的前一个顶点是谁
    private int[] pre;
    // 记录每个顶点是否被遍历过
    private boolean[] visited;

    // 求出在图 G 中，从源 s 到任意顶点的路径（无路径则返回空数组）
    /**
     *
     * @param g 图的数据结构表示
     * @param s 源点
     */
    public SingleSourcePath(Graph g, int s) {
        this.g = g;
        // 验证s是否合法
        g.validateVertex(s);
        this.s = s;
        this.pre = new int[g.getV()];
        this.visited = new boolean[g.getV()];
        Arrays.fill(pre, -1);

        // 从顶点s进行一次DFS
        dfs(s, s);
    }

    /**
     * dfs过程记录每个顶点的上一个顶点
     * @param v         当前遍历到的顶点
     * @param parent    s的来源节点
     */
    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
            }
        }
    }

    // 判断顶点x和源点s是否有路径
    public boolean isConnectedTo(int x) {
        g.validateVertex(x);
        return visited[x];
    }

    // 获得从源点s到x的路径
    public List<Integer> path(int x) {
        List<Integer> path = new ArrayList<>();
        if (!isConnectedTo(x)) {
            return path;
        }
        int cur = x;
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
        SingleSourcePath ss = new SingleSourcePath(g, 0);
        System.out.println(ss.isConnectedTo(5));
        System.out.println(ss.isConnectedTo(6));

        System.out.println(ss.path(6));
    }
}
