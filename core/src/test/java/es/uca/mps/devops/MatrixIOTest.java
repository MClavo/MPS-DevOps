package es.uca.mps.devops;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;



public class MatrixIOTest {

    private static final int N = 5;
    private static final int[][] MATRIX = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    };
    private static final String FILE_NAME = "test_matrix.txt";

    @Test
    public void testMostrarMatriz() {
        // Test para comprobacion visual, no automatizado
        MatrixIO.mostrarMatriz(MATRIX);
    }

    @Test
    public void testCargarMatriz() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int[] fila : MATRIX) {
                for (int elemento : fila) {
                    bw.write(elemento + " ");
                }
                bw.newLine();
            }
        } catch (IOException e) {
            fail("Error setting up test file: " + e.getMessage());
        }

        int[][] loadedMatrix = new int[N][N];
        boolean result = MatrixIO.cargarMatriz(FILE_NAME, loadedMatrix);
        assertTrue(result);
        assertArrayEquals(MATRIX, loadedMatrix);

        new File(FILE_NAME).delete();
    }
}
