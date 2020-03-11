package com.datastruct.graph;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 图数据结构
 */
public class Graph {
    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    public Graph(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("顶点数不能为负数");
            }
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<>();
            }

            E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("边数不能为负数");
            }

            for (int i = 0; i < E; i++) {
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
        return V;
    }

    public int getE() {
        return E;
    }

    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    public Set<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        return adj(v).size();
    }

    public void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is invalid.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V=%d, E=%d\n", V, E));
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ").append(adj[i]).append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph("src/main/resources/g.txt");
        System.out.println(graph);
    }
}
