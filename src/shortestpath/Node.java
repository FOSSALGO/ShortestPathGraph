package shortestpath;

import java.util.Vector;

public class Node {

    Vector<Integer> pathFromRoot = null;
    int value;

    public Node(Vector<Integer> parentPath, int nodeValue) {
        pathFromRoot = new Vector<Integer>();
        if (parentPath != null) {
            for (int v : parentPath) {
                pathFromRoot.add(v);
            }
        }
        pathFromRoot.add(nodeValue);
        this.value = nodeValue;
    }

    public double hitungBobot(double[][] adjacency) {
        double result = 0;
        if (adjacency != null && pathFromRoot != null && pathFromRoot.size() > 1) {
            double totalBobot = 0;
            for (int i = 1; i < pathFromRoot.size(); i++) {
                int v1 = pathFromRoot.get(i - 1);
                int v2 = pathFromRoot.get(i);
                if (v1 >= 0 && v2 >= 0 && v1 < adjacency.length && v2 < adjacency.length) {
                    double bobot = adjacency[v1][v2];
                    totalBobot += bobot;
                } else {
                    System.err.println("PARAMETER TIDAK VALID");
                    totalBobot = 0;
                    break;
                }
            }
            result = totalBobot;
        }
        return result;
    }

    public void cetakPath(double[][] adjacency, char[] label) {
        System.out.print("Path: ");
        if (pathFromRoot != null && pathFromRoot.size() > 0) {
            System.out.print(label[pathFromRoot.get(0)]);
            for (int i = 1; i < pathFromRoot.size(); i++) {
                System.out.print(" - " + label[pathFromRoot.get(i)]);
            }
        } else {
            System.out.print(" NULL ");
        }
    }

}
