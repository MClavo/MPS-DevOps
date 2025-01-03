package es.uca.mps.devops;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MatrixOperationsTest {

    private static final int N = 5;

    private static final int[][] MATRIX_A = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    };

    private static final int[][] MATRIX_B = {
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1}
    };

    private static final int[][] MATRIX_C = {
        {5, 4, 3, 2, 1},
        {10, 9, 8, 7, 6},
        {15, 14, 13, 12, 11},
        {20, 19, 18, 17, 16},
        {25, 24, 23, 22, 21}
    };

    private static final int[][] IDENTITY_MATRIX = {
        {1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 1}
    };

    private static final int[][] SYMMETRIC_MATRIX = {
        {1, 2, 3, 4, 5},
        {2, 1, 6, 7, 8},
        {3, 6, 1, 9, 10},
        {4, 7, 9, 1, 11},
        {5, 8, 10, 11, 1}
    };

    private static final int[][] NON_SYMMETRIC_MATRIX = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    };


    @Test
    public void testSumarMatrices() {
        int[][] R = new int[N][N];
        int[][] expected = {
            {2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11},
            {12, 13, 14, 15, 16},
            {17, 18, 19, 20, 21},
            {22, 23, 24, 25, 26}
        };

        MatrixOperations.sumarMatrices(MATRIX_A, MATRIX_B, R);
        assertArrayEquals(expected, R);
    }

    @Test
    public void testRestarMatrices() {
        int[][] R = new int[N][N];
        int[][] expected = {
            {4, 3, 2, 1, 0},
            {9, 8, 7, 6, 5},
            {14, 13, 12, 11, 10},
            {19, 18, 17, 16, 15},
            {24, 23, 22, 21, 20}
        };

        MatrixOperations.restarMatrices(MATRIX_C, MATRIX_B, R);
        assertArrayEquals(expected, R);
    }

    @Test
    public void testMultiplicarMatrices() {
        int[][] R = new int[N][N];
        int[][] expected = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        MatrixOperations.multiplicarMatrices(MATRIX_A, IDENTITY_MATRIX, R);
        assertArrayEquals(expected, R);
    }

}
