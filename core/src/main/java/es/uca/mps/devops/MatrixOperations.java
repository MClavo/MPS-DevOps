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

    public static void multiplicarMatrices(int[][] A, int[][] B, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public static boolean verificarSimetria(int[][] A) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] != A[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void transponerMatriz(int[][] A, int[][] R) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                R[j][i] = A[i][j];
            }
        }
    }
}
