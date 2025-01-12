package es.uca.mps.devops;

import java.util.Scanner;

public class MatrixMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrizA = new int[5][5];
        int[][] matrizB = new int[5][5];
        int[][] resultado = new int[5][5];
        boolean continuar = true;
        MatrixIO.cargarMatriz("matrizA.txt", matrizA);
        MatrixIO.cargarMatriz("matrizB.txt", matrizB);
        
        while(continuar){
            System.out.println("\n--- MENU MATRIX ---");
            System.out.println("1. Cargar Matrices");
            System.out.println("2. Mostrar matrices inicializadas");
            System.out.println("3. Sumar matrices");
            System.out.println("4. Restar matrices");
            System.out.println("5. Multiplicar matrices");
            System.out.println("6. Guardar resultado en Archivo");
            System.out.println("7. Verificar simetría de A");
            System.out.println("8. Transponer matriz A");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
        
            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Limpiar el buffer
                    MatrixIO.cargarMatriz("matrizA.txt", matrizA);
                    MatrixIO.cargarMatriz("matrizB.txt", matrizB);
                    break;
                case 2:
                    MatrixIO.mostrarMatriz(matrizA);
                    System.out.println();
                    MatrixIO.mostrarMatriz(matrizB);
                    break;
                case 3:
                    MatrixOperations.sumarMatrices(matrizA, matrizB, resultado);
                    MatrixIO.mostrarMatriz(resultado);
                    break;
                case 4:
                    MatrixOperations.restarMatrices(matrizA, matrizB, resultado);
                    MatrixIO.mostrarMatriz(resultado);
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
                case 8:
                    int[][] resultadoTranspuesta = new int[5][5];
                    MatrixOperations.transponerMatriz(matrizA, resultadoTranspuesta);
                    System.out.println("Transpuesta de la matriz A:");
                    MatrixIO.mostrarMatriz(resultadoTranspuesta);
                    break; 
                case 9:
                    System.out.println("Gracias por usar el programa.");
                    continuar = false;
                    break;               
                default:
                    System.out.println("Opción no válida.");   
            }
        }
    }
}
