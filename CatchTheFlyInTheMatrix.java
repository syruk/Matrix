
import java.util.Random;
import java.util.Scanner;

public class CatchTheFlyInTheMatrix {
    private static char[][] board = new char[4][4];
    private static int flyPositionX;
    private static int flyPositionY;

    public static void main(String[] args) {
        startGame();
        play();
    }
    public static void startGame() {
        Random rand = new Random();
        flyPositionX = rand.nextInt(4);
        flyPositionY = rand.nextInt(4);
        System.out.println("¡Bienvenido al juego Atrapa a la Mosca!");
        System.out.println("Intenta encontrar la mosca en un tablero de 4x4.");
        System.out.println("Ingresa las coordenadas (fila y columna) para atraparla.");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = '-';
            }
        }
    }
    public static void showBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean validateCoords(int x, int y) {
        if (x < 1 || x > 4 || y < 1 || y > 4) {
            System.out.println("Coordenadas fuera de rango. Ingresa nuevamente.");
            return false;
        } else if (x - 1 == flyPositionX && y - 1 == flyPositionY) {
            System.out.println("¡Felicidades! Has atrapado a la mosca.");
            return true;
        } else {
            moveFlyIfIsClose();
            return false;
        }
    }
    public static void moveFlyIfIsClose() {
        Random rand = new Random();
        int deltaX = rand.nextInt(3) - 1;
        int deltaY = rand.nextInt(3) - 1;
        if (flyPositionX + deltaX >= 0 && flyPositionX + deltaX < 4 &&
                flyPositionY + deltaY >= 0 && flyPositionY + deltaY < 4) {
            flyPositionX += deltaX;
            flyPositionY += deltaY;
        }
    }
    public static void play() {
        Scanner scanner = new Scanner(System.in);
        boolean winner = false;
        while (!winner) {
            showBoard();
            System.out.print("Ingresa la fila (1-4): ");
            int fila = scanner.nextInt();
            System.out.print("Ingresa la columna (1-4): ");
            int columna = scanner.nextInt();
            board[fila - 1][columna - 1] = 'X';
            winner = validateCoords(fila, columna);
        }
        scanner.close();
    }
}