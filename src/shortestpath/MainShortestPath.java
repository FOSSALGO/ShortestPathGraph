package shortestpath;

public class MainShortestPath {

    public static void main(String[] args) {
        String[ ] label = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

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

        int indexVertexAwal = 2;    // 6 = vertex-G
        int indexVertexAkhir = 9;  // 11 = vertex-L

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