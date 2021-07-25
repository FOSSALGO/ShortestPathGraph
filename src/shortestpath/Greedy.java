package shortestpath;

import java.util.Vector;

public class Greedy {

    /* VARIABEL INPUT */
    String[] label = null;
    double[][] adjacencyMatrix = null;
    int indexVertexAwal = -1;
    int indexVertexAkhir = -1;

    public Greedy(String[] label, double[][] adjacencyMatrix, int indexVertexAwal, int indexVertexAkhir) {
        this.label = label;
        this.adjacencyMatrix = adjacencyMatrix;
        this.indexVertexAwal = indexVertexAwal;
        this.indexVertexAkhir = indexVertexAkhir;
    }

    private boolean validasiInput() {
        boolean result = true;
        if (label == null
                || adjacencyMatrix == null
                || label.length != adjacencyMatrix.length
                || label.length != adjacencyMatrix[0].length
                || indexVertexAwal < 0
                || indexVertexAwal >= label.length
                || indexVertexAkhir < 0
                || indexVertexAkhir >= label.length) {
            result = false;
        }
        return result;
    }

    public Solution find() {
        Solution solusi = new Solution(null, 0, "Algoritma Greedy");
        boolean inputValid = validasiInput();
        if (inputValid) {
            boolean[] visited = new boolean[label.length];
            double totalBobot = 0;
            int vertexAsal = indexVertexAwal;
            visited[vertexAsal] = true;
            boolean missionComplete = false; //variabel missionComplete=TRUE berarti berhasil menemukan vertex akhir
            Vector<Integer> path = new Vector<>();
            path.add(vertexAsal);
            while (vertexAsal != indexVertexAkhir) {
                int vertexTujuan = -1;
                double MIN = Double.MAX_VALUE;
                for (int i = 0; i < adjacencyMatrix[vertexAsal].length; i++) {
                    double bobot = adjacencyMatrix[vertexAsal][i];
                    boolean isVisited = visited[i];
                    if (bobot > 0 && !isVisited && bobot < MIN) {
                        MIN = bobot;
                        vertexTujuan = i;
                    }
                }
                if (vertexTujuan != -1) {
                    visited[vertexTujuan] = true;
                    path.add(vertexTujuan);
                    double bobot = adjacencyMatrix[vertexAsal][vertexTujuan];
                    totalBobot += bobot;
                    vertexAsal = vertexTujuan;
                } else {
                    break;
                }
            }//end of while

            //Set Output
            if(path.size() > 0 && path.get(path.size()-1)==indexVertexAkhir){
                missionComplete = true;
            }
            if (missionComplete) {
                StringBuilder sb;
                sb = new StringBuilder();
                sb.append(label[path.get(0)]);
                for (int i = 1; i < path.size(); i++) {
                    sb.append(" - ");
                    sb.append(label[path.get(i)]);
                }
                String stringPathSolusiGreedy = sb.toString();
                double bobotSolusiGreedy = totalBobot;
                solusi = new Solution(stringPathSolusiGreedy, bobotSolusiGreedy, "Algoritma Greedy");
            }
        }//end of if (inputValid)
        return solusi;
    }
}
