package shortestpath;

import java.util.Vector;

public class BFS {

    /* VARIABEL INPUT */
    String[] label = null;
    double[][] adjacencyMatrix = null;
    int indexVertexAwal = -1;
    int indexVertexAkhir = -1;

    public BFS(String[] label, double[][] adjacencyMatrix, int indexVertexAwal, int indexVertexAkhir) {
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
        Solution solusi = new Solution(null, 0, "Algoritma Breadth First Search");
        boolean inputValid = validasiInput();
        if (inputValid) {
            Queue<Node> queue = new Queue<>();
            Node root = new Node(null, indexVertexAwal);
            queue.add(root);
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
                                Vector<Integer> pathSolusiBFS = childNode.pathFromRoot;
                                double bobotSolusiBFS = childNode.hitungBobot(adjacencyMatrix);
                                //konversi path ke String berdasarkan label
                                StringBuilder sb = new StringBuilder();
                                sb.append(label[pathSolusiBFS.get(0)]);
                                for (int j = 1; j < pathSolusiBFS.size(); j++) {
                                    sb.append(" - ");
                                    sb.append(label[pathSolusiBFS.get(j)]);
                                }
                                String stringPathSolusiBFS = sb.toString();
                                solusi = new Solution(stringPathSolusiBFS, bobotSolusiBFS, "Algoritma Breadth First Search");
                                break outer;//solusi BFS ditemukan dan langsung keluar dari loop while                             
                            } else {
                                //jika childNode bukan vertexAkhir, maka masukkan ia ke queue
                                queue.add(childNode);
                            }
                        }
                    }
                }//end of for
                queue.poll();
            }//end of while
        }//end of if (inputValid)
        return solusi;
    }

}
