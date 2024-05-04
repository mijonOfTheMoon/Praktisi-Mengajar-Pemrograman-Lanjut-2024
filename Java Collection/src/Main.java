import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue<String> antrian = new ArrayDeque<>();
        String menu, pasien;
        int nomor = 1;

        do {

            System.out.println("==========================");
            System.out.println("Sistem Antrian Rumah Sakit");
            System.out.println("==========================");
            System.out.println("1. Tambah Antrian Pasien");
            System.out.println("2. Lihat Antrian Pasien");
            System.out.println("3. Panggil Pasien");
            System.out.println("4. Keluar");
            System.out.println("==========================");

            do {
                System.out.print("Pilih Menu Tujuan (1-4): ");
            } while (!(menu = input.nextLine()).matches("[1-4]"));

            switch (menu) {
                case "1":
                    do {
                        System.out.println("==========================");
                        System.out.print("Masukkan Nama Pasien: ");
                    } while ((pasien = input.nextLine()).isEmpty());
                    antrian.offer(pasien);
                    System.out.println("==========================");
                    System.out.println("Pasien Berhasil Ditambahkan ke dalam Antrian");
                    continue;
                case "2":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        System.out.println("==========================");
                        System.out.println("Daftar Antrian Pasien");
                        System.out.println("==========================");
                        int no = nomor;
                        for (String queue : antrian) {
                            System.out.println(no++ + ". " + queue);
                        }
                    }
                    continue;
                case "3":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        nomor++;
                        System.out.println("==========================");
                        System.out.println("Pasien Selanjutnya: " + antrian.poll() +  " Silahkan Menuju Ruang Periksa");
                    }
                    continue;
                case "4":
                    input.close();
                    break;
            }

        } while (!menu.equals("4"));
        
    }

}