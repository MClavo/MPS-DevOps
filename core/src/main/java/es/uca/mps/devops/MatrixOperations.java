package es.uca.mps.devops;

public class MatrixOperations {
    private static final int N = 5;

    public static void sumarMatrices(int[][] A, int[][] B, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    public static void restarMatrices(int[][] A, int[][] B, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] - B[i][j];
            }
        }
    }
}