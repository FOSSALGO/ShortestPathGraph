package shortestpath;

import java.util.Arrays;
import java.util.Scanner;

public class MainShortestPathInputVertexAwalDanAkhir {

    public static void main(String[] args) {
        String[] label = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        double[][] adjacencyMatrix = {
            {0, 5, 3.8, 7, 0, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 6, 0, 9.4, 0, 0, 0, 0},
            {3.8, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 2, 0, 5, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 0, 0, 14, 0, 0, 0, 0, 17},
            {0, 6, 4, 0, 0, 0, 3, 7, 9, 0, 0, 0},
            {0, 0, 0, 5, 14, 3, 0, 0, 0, 6, 0, 0},
            {0, 9.4, 0, 0, 0, 7, 0, 0, 0, 0, 24, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0, 4, 29, 5},
            {0, 0, 0, 0, 0, 0, 6, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 24, 29, 0, 0, 8},
            {0, 0, 0, 0, 17, 0, 0, 0, 5, 0, 8, 0}
        };

        int indexVertexAwal = 0;    // 6 = vertex-G
        int indexVertexAkhir = 9;  // 11 = vertex-L

        Scanner sc = new Scanner(System.in);
        //INPUT VERTEX AWAL
        boolean terpilih = false;
        while (!terpilih) {
            System.out.println("Vertex tersedia: " + Arrays.toString(label));
            System.out.print("Pilih Vertex Awal: ");
            String pilihVertex = sc.next();
            for (int i = 0; i < label.length; i++) {
                if (label[i].equalsIgnoreCase(pilihVertex)) {
                    indexVertexAwal = i;
                    terpilih = true;
                    break;
                }
            }
        }
        
        //INPUT VERTEX AKHIR
        terpilih = false;
        while (!terpilih) {
            System.out.println("Vertex tersedia: " + Arrays.toString(label));
            System.out.print("Pilih Vertex Akhir: ");
            String pilihVertex = sc.next();
            for (int i = 0; i < label.length; i++) {
                if (label[i].equalsIgnoreCase(pilihVertex)) {
                    indexVertexAkhir = i;
                    terpilih = true;
                    break;
                }
            }
        }

        /**
         * SOLUSI Greedy
         */
        Greedy greedy = new Greedy(label, adjacencyMatrix, indexVertexAwal, indexVertexAkhir);
        Solution solusiGreedy = greedy.find();
        solusiGreedy.print();

        /**
         * SOLUSI Backtracking
         */
        Backtracking backtracking = new Backtracking(label, adjacencyMatrix, indexVertexAwal, indexVertexAkhir);
        Solution solusiBacktracking = backtracking.find();
        solusiBacktracking.print();

        /**
         * SOLUSI BFS
         */
        BFS bfs = new BFS(label, adjacencyMatrix, indexVertexAwal, indexVertexAkhir);
        Solution solusiBFS = bfs.find();
        solusiBFS.print();

        /**
         * SOLUSI Brute Force
         */
        BruteForce bruteForce = new BruteForce(label, adjacencyMatrix, indexVertexAwal, indexVertexAkhir);
        Solution solusiBruteForce = bruteForce.find();
        solusiBruteForce.print();
    }

}
