import java.util.InputMismatchException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue<String> antrian = new ArrayDeque<>();
        String menu, pasien;
        int nomorAntrian = 1;

        loopingSampaiKeluar:
        do {

            System.out.println("==========================");
            System.out.println("Sistem Antrian Rumah Sakit");
            System.out.println("==========================");
            System.out.println("1. Tambah Antrian Pasien");
            System.out.println("2. Lihat Antrian Pasien");
            System.out.println("3. Panggil Pasien Selanjutnya");
            System.out.println("4. Panggil Nomor Pasien");
            System.out.println("5. Keluar");
            System.out.println("==========================");

            do {
                System.out.print("Pilih Menu Tujuan (1-5): ");
            } while (!(menu = input.nextLine()).matches("[1-5]"));

            switch (menu) {
                case "1":
                    do {
                        System.out.println("==========================");
                        System.out.print("Masukkan Nama Pasien: ");
                    } while ((pasien = input.nextLine()).isEmpty());
                    antrian.offer(nomorAntrian++ + ". " + pasien);
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
                        for (String queue : antrian) {
                            System.out.println(queue);
                        }
                    }
                    continue;
                case "3":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        System.out.println("==========================");
                        System.out.println("Pasien selanjutnya: " + antrian.poll() + " silahkan menuju ruang periksa");
                    }
                    continue;
                case "4":
                    try {
                        System.out.println("==========================");
                        System.out.print("Masukkan Nomor Antrian: ");
                        int nomorPanggilan = input.nextInt();
                        input.nextLine();

                        for (String queue : antrian) {
                            int nomorQueue = Integer.valueOf(queue.substring(0, queue.indexOf('.')));
                            if (nomorQueue == nomorPanggilan) {
                                System.out.println("==========================");
                                System.out.println("Pasien dengan nomor antrian " + nomorQueue + " silahkan menuju ruang periksa");
                                antrian.remove(queue);
                                continue loopingSampaiKeluar;
                            }
                        }
                        System.out.println("==========================");
                        System.out.println("Nomor Antrian Tidak Ditemukan");

                    } catch (InputMismatchException error) {
                        System.out.println("==========================");
                        System.out.println("Harap Masukkan Angka!");
                        input.nextLine();
                    }
                    continue;
                case "5":
                    input.close();
                    break;
            }

        } while (!menu.equals("5"));

    }

}