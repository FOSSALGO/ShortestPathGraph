package shortestpath;

import java.util.Vector;

public class BruteForce {

    /* VARIABEL INPUT */
    String[] label = null;
    double[][] adjacencyMatrix = null;
    int indexVertexAwal = -1;
    int indexVertexAkhir = -1;

    public BruteForce(String[] label, double[][] adjacencyMatrix, int indexVertexAwal, int indexVertexAkhir) {
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
        Solution solusi = new Solution(null, 0, "Algoritma Brute Force");
        boolean inputValid = validasiInput();
        if (inputValid) {
            Queue<Node> queue = new Queue<>();
            Node root = new Node(null, indexVertexAwal);
            queue.add(root);

            int numSolusiDitemukan = 0;
            Node nodeTerbaik = null;
            double solusiTerbaik = Double.MAX_VALUE;
            boolean missionComplete = false; //variabel missionComplete=TRUE berarti berhasil menemukan vertex akhir

            outer:
            while (!queue.isEmpty()) {
                Node nodeAsal = queue.peek();
                int vertexAsal = nodeAsal.value;
                Vector<Integer> path = nodeAsal.pathFromRoot;
                //periksa semua vertex yang adjacent ke node asal dan belum ada di path
                for (int i = 0; i < adjacencyMatrix[vertexAsal].length; i++) {
                    if (!path.contains(i)) {
                        double bobot = adjacencyMatrix[vertexAsal][i];
                        if (bobot > 0) {
                            //vertex-i saling adjacent dengan node/vertex asal dan belum ada di path
                            Node childNode = new Node(path, i);
                            //jika i adalah index vertex akhir maka pencarian BFS dihentikan
                            if (i == indexVertexAkhir) {
                                double totalBobot = childNode.hitungBobot(adjacencyMatrix);
                                if (totalBobot < solusiTerbaik) {
                                    solusiTerbaik = totalBobot;
                                    nodeTerbaik = childNode;
                                }
                                missionComplete = true;
                            } else {
                                //jika childNode bukan vertexAkhir, maka masukkan ia ke queue
                                queue.add(childNode);
                            }
                        }
                    }
                }//end of for
                queue.poll();
            }//end of while
            
            if(missionComplete && nodeTerbaik!=null){
                Vector<Integer> path = nodeTerbaik.pathFromRoot;
                StringBuilder sb;
                sb = new StringBuilder();
                sb.append(label[path.get(0)]);
                for (int i = 1; i < path.size(); i++) {
                    sb.append(" - ");
                    sb.append(label[path.get(i)]);
                }
                String stringPathSolusiBruteForce = sb.toString();
                double bobotSolusiBruteForce = nodeTerbaik.hitungBobot(adjacencyMatrix);
                solusi = new Solution(stringPathSolusiBruteForce, bobotSolusiBruteForce, "Algoritma Brute Force");
            }
        }//end of if (inputValid)
        return solusi;
    }
}
