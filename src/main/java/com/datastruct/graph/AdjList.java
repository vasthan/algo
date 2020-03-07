package com.datastruct.graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 邻接表：链表实现
 */
public class AdjList {
    private int v;
    private int e;
    private LinkedList<Integer>[] adj;

    public AdjList(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            v = scanner.nextInt();
            if (v < 0) {
                throw new IllegalArgumentException("顶点数不能为负数");
            }
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }

            e = scanner.nextInt();
            if (e < 0) {
                throw new IllegalArgumentException("边数不能为负数");
            }

            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                if (a == b) {
                    throw new IllegalArgumentException("不允许自环边");
                }
                if (adj[a].contains(b)) {
                    throw new IllegalArgumentException("不允许平行边");
                }
                adj[a].add(b);
                adj[b].add(a);
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
        return adj[a].contains(b);
    }

    public LinkedList<Integer> adj(int k) {
        validateVertex(k);
        return adj[k];
    }

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
            sb.append(i + ": ").append(adj[i]).append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjList adjList = new AdjList("src/main/resources/g.txt");
        System.out.println(adjList);
    }
}
