package shortestpath;

public class Backtracking {

    /* VARIABEL INPUT */
    String[] label = null;
    double[][] adjacencyMatrix = null;
    int indexVertexAwal = -1;
    int indexVertexAkhir = -1;

    public Backtracking(String[] label, double[][] adjacencyMatrix, int indexVertexAwal, int indexVertexAkhir) {
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
        Solution solusi = new Solution(null, 0, "Algoritma Backtracking");
        boolean inputValid = validasiInput();
        if (inputValid) {
            boolean[] visited = new boolean[label.length];
            Stack<Integer> stackVertex = new Stack<Integer>();
            visited[indexVertexAwal] = true; //menandai vertexAwal sebagai vertex yang telah dikunjungi
            stackVertex.push(indexVertexAwal); //memasukkan vertexAwal ke dalam stackVertex
            boolean missionComplete = false; //variabel missionComplete=TRUE berarti pencarian berakhir

            while (!stackVertex.isEmpty()) {
                int vertexAsal = stackVertex.peek();
                if (vertexAsal == indexVertexAkhir) {
                    missionComplete = true;
                    break;
                } else {
                    int vertexTujuan = -1;
                    for (int i = 0; i < adjacencyMatrix[vertexAsal].length; i++) {
                        double bobot = adjacencyMatrix[vertexAsal][i];
                        boolean isVisited = visited[i];
                        if (bobot > 0 && !isVisited) {
                            vertexTujuan = i;
                            break;
                        }
                    }

                    if (vertexTujuan != -1) {
                        stackVertex.push(vertexTujuan);
                        visited[vertexTujuan] = true;
                    } else {
                        stackVertex.pop();
                    }
                }
            }//end of while (!stackVertex.isEmpty())

            //Set Output
            if (missionComplete && !stackVertex.isEmpty()) {
                StringBuilder sb;
                sb = new StringBuilder();
                sb.append(label[stackVertex.get(0)]);
                double totalBobot = 0;
                for (int i = 1; i < stackVertex.size(); i++) {
                    int va = stackVertex.get(i - 1);
                    int vb = stackVertex.get(i);
                    double bobot = adjacencyMatrix[va][vb];
                    totalBobot += bobot;
                    sb.append(" - ");
                    sb.append(label[vb]);
                }
                String stringPathSolusiBacktracking = sb.toString();
                double bobotSolusiBacktracking = totalBobot;
                solusi = new Solution(stringPathSolusiBacktracking, bobotSolusiBacktracking, "Algoritma Backtracking");
            }
        }//end of if (inputValid)
        return solusi;
    }
}
