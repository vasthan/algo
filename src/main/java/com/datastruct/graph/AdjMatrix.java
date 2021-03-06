package com.datastruct.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 邻接矩阵 (adjacency matrix)
 */
public class AdjMatrix {
    // vertex 顶点数
    private int v;
    // edge 边数
    private int e;
    // 二维矩阵，图的具体表示
    private int[][] adj;

    public AdjMatrix(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            v = scanner.nextInt();
            if (v < 0) {
                throw new IllegalArgumentException("顶点数不能是负数");
            }
            adj = new int[v][v];

            e = scanner.nextInt();
            if (e < 0) {
                throw new IllegalArgumentException("边数不能是负数");
            }

            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                if (a == b) {
                    throw new IllegalArgumentException("不允许自环边");
                }
                if (adj[a][b] == 1) {
                    throw new IllegalArgumentException("不允许平行边");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public boolean hasEdge(int a, int b) {
        validateVertex(a);
        validateVertex(b);
        return adj[a][b] == 1;
    }

    // 获取一个顶点的相邻点（边）
    public List<Integer> adj(int k) {
        validateVertex(k);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (adj[k][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    // 获取一个顶点的度
    public int degree(int k) {
        return adj(k).size();
    }

    private void validateVertex(int k) {
        if (k < 0 || k >= v) {
            throw new IllegalArgumentException("vertex " + k + " is invalid.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V=%d, E=%d\n", v, e));
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                sb.append(adj[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("src/main/resources/g.txt");
        System.out.println(adjMatrix);
    }
}
