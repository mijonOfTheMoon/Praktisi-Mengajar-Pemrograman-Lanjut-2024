import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue<String> antrianRS = new ArrayDeque();
        String pasien;

        while (true) {
            System.out.print("Masukkan nama pasien (q untuk keluar): ");
            pasien = input.nextLine();
            if (pasien.equals("q")) {
                break;
            } else {
                if (pasien.isEmpty()) {
                    continue;
                }
                antrianRS.add(pasien);
            }
        }

        System.out.println("\nAntrian Pasien Saat Ini\n");

        int antrian = 0;
        for (String nama : antrianRS) {
            System.out.println("Pasien no." + (antrian += 1) + ": " + nama);
        }

    }

}
