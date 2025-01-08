package es.uca.mps.devops;

import java.util.Scanner;

public class MatrixMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrizA = new int[5][5];
        int[][] matrizB = new int[5][5];
        int[][] resultado = new int[5][5];

        System.out.println("\n--- MENU MATRIX ---");
        System.out.println("1. Mostrar matrices inicializadas");
        System.out.println("2. Sumar matrices");
        System.out.println("3. Restar matrices");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                MatrixIO.mostrarMatriz(matrizA);
                break;
            case 2:
                MatrixOperations.sumarMatrices(matrizA, matrizB, resultado);
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 3:
                MatrixOperations.restarMatrices(matrizA, matrizB, resultado);
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 4:
                System.out.println("Gracias por usar el programa.");
                break;
            case 5:
                MatrixOperations.multiplicarMatrices(matrizA, matrizB, resultado);
                System.out.println("Resultado de la multiplicación de matrices:");
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 6:
                System.out.print("Ingrese el nombre del archivo para guardar el resultado: ");
                scanner.nextLine(); // Limpiar buffer
                String nombreArchivo = scanner.nextLine();
                MatrixIO.guardarMatriz(nombreArchivo, resultado);
                break;
            case 7:
                if (MatrixOperations.verificarSimetria(matrizA)) {
                    System.out.println("La matriz A es simétrica.");
                } else {
                    System.out.println("La matriz A no es simétrica.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
            
        }
    }
}
