package shortestpath;

public class Solution {

    String path = null;
    double weight;
    String algorithm = "";

    public Solution(String path, double weight, String algorithm) {
        this.path = path;
        this.weight = weight;
        this.algorithm = algorithm;
    }

    public void print() {
        if (path != null && weight > 0) {
            System.out.print("Path: [ " + path);
            System.out.print(" ] Jarak = " + weight);
            System.out.println(" <--Solusi " + algorithm);
        } else {
            System.out.println("Path: NULL <--Solusi " + algorithm);
            System.err.println("GAGAL menemukan Solusi " + algorithm);
        }
    }

}
