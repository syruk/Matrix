import java.util.Arrays;
import java.util.Scanner;

public class MyMatrix {
    public static void matrixPrint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double maxMatrixElement(int[][] matrix) {
        double biggerValue = Double.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > biggerValue) {
                    biggerValue = matrix[i][j];
                }
            }
        }
        return biggerValue;
    }
    public static double minMatrixElement(int[][] matrix) {
        int smallerValue = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < smallerValue) {
                    smallerValue = matrix[i][j];
                }
            }
        }
        return smallerValue;
    }

    public static double averageMatrixElement(int[][] matrix) {
        double total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                total += matrix[i][j];
            }
        }
        return total / (matrix.length * matrix[0].length);
    }

    public static boolean elementExistInMatrix(int[][] matrix, double element) {
        boolean valueExist = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element) {
                    valueExist = true;
                }
            }
        }
        return valueExist;
    }

    public static double countRepetitions(int[][] matrix, int element) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element) {
                    counter++;
                }
            }
        }
        return counter;
    }
    public static double[][] addMatrix(int[][] matrix, int[][] matrix2) {
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrix(int[][] matrix1, int[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    public static boolean isMatrixUnit(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows != columns) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                }
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void menu() {
        System.out.println("Escribe el carácter para acceder al ejercicio:");
        System.out.println("a) Un procedimiento que imprime la Matríz seleccionada.\n" +
                "b) Una funcion que devuelve el máximo de la Matríz seleccionada.\n" +
                "c) Una función que devuelve el mínimo de la Matríz seleccionada.\n" +
                "d) Una función que devuelve la media de la Matríz seleccionada.\n" +
                "e) Una función que devuelve cuantas veces se repite un número en una matriz.\n"+
                "f) Una función que dice si un elemento existe dentro de la Matríz.\n" + //
                "g) Una función que suma las Matríces.\n" +
                "h) Una función que resta las Matríces.\n" +
                "i) Una función que comprueba se la Matríz es Matríz Unidad.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la cantidad de filas y columnas del la primera Matríz:");
        System.out.println("Filas:");
        int rowsLength = scanner.nextInt();
        System.out.println("Columnas:");
        int columnsLength = scanner.nextInt();
        int[][] matrix = new int[rowsLength][columnsLength];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Introduce el valor de la posición [" + i + "," + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("La primera Matríz es:");
        MyMatrix.matrixPrint(matrix);

        System.out.println("Introduce la cantidad de filas y columnas del la segunda Matríz:");
        System.out.println("Filas:");
        int rowsLength2 = scanner.nextInt();
        System.out.println("Columnas:");
        int columnsLength2 = scanner.nextInt();
        int[][] matrix2 = new int[rowsLength2][columnsLength2];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.println("Introduce el valor de la posición [" + i + "," + j + "]: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }
        System.out.println("La segunda Matríz es:");
        MyMatrix.matrixPrint(matrix2);

        MyMatrix.menu();
        String option = scanner.next();
        int matrixChoice;
        int number;
        switch (option) {
            case "a":
                System.out.println("Escoge que Matríz imprimir, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    MyMatrix.matrixPrint(matrix);
                } else if (matrixChoice == 2) {
                    MyMatrix.matrixPrint(matrix2);
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            case "b":
                System.out.println("Escoge de qué Matríz quieres saber su elemento máximo, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    System.out.println(MyMatrix.maxMatrixElement(matrix));
                } else if (matrixChoice == 2) {
                    System.out.println(MyMatrix.maxMatrixElement(matrix2));
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            case "c":
                System.out.println("Escoge de qué Matríz quieres saber su elemento mínimo, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    System.out.println(MyMatrix.minMatrixElement(matrix));
                } else if (matrixChoice == 2) {
                    System.out.println(MyMatrix.minMatrixElement(matrix2));
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            case "d":
                System.out.println("Escoge una Matríz para saber la media de sus elementos, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    System.out.println(MyMatrix.averageMatrixElement(matrix));
                } else if (matrixChoice == 2) {
                    System.out.println(MyMatrix.averageMatrixElement(matrix2));
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            case "e":
                System.out.println("Escoge una Matríz para saber cuántas veces se repite en ella un elemento, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    System.out.println("Introduce el número que quieres buscar dentro de la Matríz:");
                    number = scanner.nextInt();
                    System.out.println(MyMatrix.countRepetitions(matrix, number));
                } else if (matrixChoice == 2) {
                    System.out.println("Introduce el número que quieres buscar dentro de la Matríz:");
                    number = scanner.nextInt();
                    System.out.println(MyMatrix.countRepetitions(matrix, number));
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            case "f":
                System.out.println("Escoge una Matríz para saber si un elemento existe en él o no, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    System.out.println("Introduce el número que quieres buscar dentro de la Matríz:");
                    number = scanner.nextInt();
                    System.out.println(MyMatrix.elementExistInMatrix(matrix,number));
                } else if (matrixChoice == 2) {
                    System.out.println("Introduce el número que quieres buscar dentro de la Matríz:");
                    number = scanner.nextInt();
                    System.out.println(MyMatrix.elementExistInMatrix(matrix2,number));
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            case "g":
                System.out.println("La suma de los elementos de las 2 Matrices introducidas es:");
                System.out.println(Arrays.deepToString(MyMatrix.addMatrix(matrix, matrix2)));
                break;
            case "h":
                System.out.println("La resta de los elementos de las 2 Matríces introducidas es:");
                System.out.println(Arrays.deepToString(MyMatrix.subtractMatrix(matrix, matrix2)));
                break;
            case "i":
                System.out.println("Escoge una Matríz para saber si es Matríz unidad o no, 1 o 2:");
                matrixChoice = scanner.nextInt();
                if (matrixChoice == 1) {
                    System.out.println(MyMatrix.isMatrixUnit(matrix));
                } else if (matrixChoice == 2) {
                    System.out.println(MyMatrix.isMatrixUnit(matrix2));
                } else System.out.println("ERROR: Escoge una Matríz válida (1 o 2)");
                break;
            default:
                System.out.println("ERROR: Elige una opción válida.");
                break;
        }
    }
}
