import java.io.*;

public class MatrixIO {
    private static final int N = 5;

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    public static boolean cargarMatriz(String nombreArchivo, int[][] matriz) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            for (int i = 0; i < N; i++) {
                String[] elementos = br.readLine().trim().split("\\s+");
                for (int j = 0; j < N; j++) {
                    matriz[i][j] = Integer.parseInt(elementos[j]);
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return false;
        }
    }

    public static void guardarMatriz(String nombreArchivo, int[][] matriz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int[] fila : matriz) {
                for (int elemento : fila) {
                    bw.write(elemento + " ");
                }
                bw.newLine();
            }
            System.out.println("Matriz guardada en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
