import java.util.Scanner;

public class WifiSignalInTheMatrix {
    public static void main(String[] args) {
        int[][] hotel = new int[12][5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("SIMULACION DE COBERTURA WIFI DE UN HOTEL");
        System.out.println("Introduce la planta del hotel (1-12):");
        int floor = scanner.nextInt();
        if (floor < 1 || floor > 12) {
            System.out.println("ERROR: Planta inválida. Debe estar entre 1 y 12.");
            return;
        }
        System.out.println("Introduce la habitación (1-5):");
        int room = scanner.nextInt();
        if (room < 1 || room > 12) {
            System.out.println("ERROR: Habitación inválida. Debe estar entre 1 y 5.");
            return;
        }
        System.out.println("Introduce la potencia de la señal del router (1-6):");
        int wifiSignal = scanner.nextInt();
        if (wifiSignal < 1 || wifiSignal > 6) {
            System.out.println("ERROR: Potencia de transmisión inválida. Debe estar entre 1 y 6.");
            return;
        }
        hotel[floor - 1][room - 1] = wifiSignal;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 5; j++) {
                if (hotel[i][j] == 0) {
                    int distance = Math.abs(i - (floor - 1)) + Math.abs(j - (room - 1));
                    hotel[i][j] = Math.max(0, wifiSignal - distance);
                }
                System.out.print(hotel[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
