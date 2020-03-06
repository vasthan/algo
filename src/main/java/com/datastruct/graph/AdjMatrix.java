package com.datastruct.graph;

import java.io.File;
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
    private int[][] matrix;

    public AdjMatrix(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            v = scanner.nextInt();
            matrix = new int[v][v];

            e = scanner.nextInt();
            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                matrix[a][b] = 1;
                matrix[b][a] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V=%d, E=%d\n", v, e));
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                sb.append(matrix[i][j]).append(' ');
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
