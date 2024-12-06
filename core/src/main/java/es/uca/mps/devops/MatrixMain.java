package es.uca.mps.devops;

import java.io.*;
import java.util.Scanner;

public class MatrixMain {
    private static final int N = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrizA = new int[N][N];
        int[][] matrizB = new int[N][N];
        int[][] resultado = new int[N][N];
        boolean matrizACargada = false;
        boolean matrizBCargada = false;

        int opcion;
        do {
            System.out.println("\n--- MENU MATRIX ---");
            System.out.println("1. Cargar Matrices");
            System.out.println("2. Operaciones");
            System.out.println("3. Mostrar Matrices");
            System.out.println("4. Guardar Resultado en Archivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    matrizACargada = cargarMatriz("A", matrizA);
                    matrizBCargada = cargarMatriz("B", matrizB);
                    break;
                case 2:
                    if (matrizACargada && matrizBCargada) {
                        ejecutarOperaciones(matrizA, matrizB, resultado);
                    } else {
                        System.out.println("Ambas matrices deben estar cargadas.");
                    }
                    break;
                case 3:
                    if (matrizACargada) {
                        System.out.println("Matriz A:");
                        MatrixIO.mostrarMatriz(matrizA);
                    }
                    if (matrizBCargada) {
                        System.out.println("Matriz B:");
                        MatrixIO.mostrarMatriz(matrizB);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del archivo para guardar el resultado: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String nombreArchivo = scanner.nextLine();
                    MatrixIO.guardarMatriz(nombreArchivo, resultado);
                    break;
                case 5:
                    System.out.println("Gracias por usar el programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static boolean cargarMatriz(String nombre, int[][] matriz) {
        System.out.print("Ingrese el nombre del archivo para cargar la matriz " + nombre + ": ");
        scanner.nextLine(); // Limpiar el buffer
        String nombreArchivo = scanner.nextLine();
        if (MatrixIO.cargarMatriz(nombreArchivo, matriz)) {
            System.out.println("Matriz " + nombre + " cargada correctamente.");
            return true;
        } else {
            System.out.println("Error al cargar la matriz " + nombre + ".");
            return false;
        }
    }

    private static void ejecutarOperaciones(int[][] matrizA, int[][] matrizB, int[][] resultado) {
        System.out.println("\n--- OPERACIONES ---");
        System.out.println("1. Sumar Matrices");
        System.out.println("2. Restar Matrices");
        System.out.println("3. Multiplicar Matrices");
        System.out.println("4. Producto Escalar");
        System.out.println("5. Transponer Matriz A");
        System.out.println("6. Verificar Simetría de A");
        System.out.print("Seleccione una operación: ");
        int operacion = scanner.nextInt();

        switch (operacion) {
            case 1:
                MatrixOperations.sumarMatrices(matrizA, matrizB, resultado);
                System.out.println("Resultado de la suma:");
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 2:
                MatrixOperations.restarMatrices(matrizA, matrizB, resultado);
                System.out.println("Resultado de la resta:");
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 3:
                MatrixOperations.multiplicarMatrices(matrizA, matrizB, resultado);
                System.out.println("Resultado de la multiplicación:");
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 4:
                System.out.print("Ingrese el escalar: ");
                int escalar = scanner.nextInt();
                MatrixOperations.productoEscalar(matrizA, escalar, resultado);
                System.out.println("Resultado del producto escalar:");
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 5:
                MatrixOperations.transponerMatriz(matrizA, resultado);
                System.out.println("Transpuesta de A:");
                MatrixIO.mostrarMatriz(resultado);
                break;
            case 6:
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
