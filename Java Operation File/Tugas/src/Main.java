import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Inisiasi Variabel Awal
        Scanner input = new Scanner(System.in);
        Queue<String> antrian = new ArrayDeque<>();
        String menu, pasien;
        int nomorAntrian = 1;
        File daftarAntrian;

        // Looping Menu
        loopingSampaiKeluar: do {

            // Tampilan Menu
            System.out.println("==========================");
            System.out.println("Sistem Antrian Rumah Sakit");
            System.out.println("==========================");
            System.out.println("1. Tambah Antrian Pasien");
            System.out.println("2. Lihat Antrian Pasien");
            System.out.println("3. Panggil Pasien Selanjutnya");
            System.out.println("4. Panggil Nomor Pasien");
            System.out.println("5. Unduh Antrian Pasien ke dalam File");
            System.out.println("6. Keluar");
            System.out.println("==========================");

            // Prompt Menu
            do {
                System.out.print("Pilih Menu Tujuan (1-6): ");
            } while (!(menu = input.nextLine()).matches("[1-6]"));

            switch (menu) {
                // Tambah Antrian Pasien
                case "1":
                    do {
                        System.out.println("==========================");
                        System.out.print("Masukkan Nama Pasien: ");
                    } while ((pasien = input.nextLine()).isEmpty());
                    antrian.offer(nomorAntrian++ + "$" + pasien + "$"
                            + new SimpleDateFormat("EEEEE, dd MMMM yyyy, HH:mm").format(new Date()));
                    System.out.println("==========================");
                    System.out.println("Pasien Berhasil Ditambahkan ke dalam Antrian");
                    continue;
                // Lihat Antrian Pasien
                case "2":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        System.out.println("==========================");
                        System.out.println("Daftar Antrian Pasien");
                        System.out.println("==========================");
                        System.out.println("----------------------------------------------------------------");
                        System.out.printf("| %-3s | %-20.20s | %-31s |\n", "No.", "Nama Pasien",
                                "Waktu Pengambilan Nomor Antrian");
                        System.out.println("----------------------------------------------------------------");
                        for (String queue : antrian) {
                            System.out.printf("| %-3s | %-20.20s | %-31s |\n",
                                    queue.substring(0, queue.indexOf('$')),
                                    queue.substring(queue.indexOf('$') + 1, queue.lastIndexOf('$')),
                                    queue.substring(queue.lastIndexOf('$') + 1));
                            System.out.println("----------------------------------------------------------------");
                        }
                    }
                    continue;
                // Panggil Pasien Selanjutnya
                case "3":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        pasien = antrian.poll();
                        System.out.println("==========================");
                        System.out.println("Pasien selanjutnya: "
                                + pasien.substring(pasien.indexOf("$") + 1, pasien.lastIndexOf("$"))
                                + " silahkan menuju ruang periksa");
                    }
                    continue;
                // Panggil Nomor Pasien
                case "4":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        try {
                            System.out.println("==========================");
                            System.out.print("Masukkan Nomor Antrian: ");
                            int nomorPanggilan = input.nextInt();
                            input.nextLine();

                            for (String queue : antrian) {
                                int nomorQueue = Integer.valueOf(queue.substring(0, queue.indexOf('$')));
                                if (nomorQueue == nomorPanggilan) {
                                    System.out.println("==========================");
                                    System.out.println(
                                            "Pasien dengan nomor antrian " + nomorQueue
                                                    + " silahkan menuju ruang periksa");
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
                    }
                    continue;
                // Unduh Antrian Pasien ke dalam File
                case "5":
                    if (antrian.isEmpty()) {
                        System.out.println("==========================");
                        System.out.println("Antrian Kosong");
                    } else {
                        System.out.println("==========================");
                        System.out.print("Nama file tujuan (Daftar Antrian Pasien.txt): ");
                        String namaFile = input.nextLine();
                        System.out.print("Direktori tujuan (Downloads): ");
                        String dir = input.nextLine();

                        if (dir.isEmpty()) {
                            dir = System.getProperty("user.home") + "/Downloads";
                        }
                        if (namaFile.isEmpty()) {
                            namaFile = "Daftar Antrian Pasien.txt";
                        }

                        daftarAntrian = new File(dir, namaFile);

                        try {
                            daftarAntrian.createNewFile();
                            FileOutputStream fileOutput = new FileOutputStream(daftarAntrian);

                            fileOutput.write(System.lineSeparator().getBytes());
                            fileOutput
                                    .write("===================== Daftar Antrian Pasien ====================="
                                            .getBytes());
                            fileOutput.write(System.lineSeparator().getBytes());
                            fileOutput
                                    .write("----------------------------------------------------------------"
                                            .getBytes());
                            fileOutput.write(System.lineSeparator().getBytes());
                            fileOutput
                                    .write("| No. | Nama Pasien          | Waktu Pengambilan Nomor Antrian |"
                                            .getBytes());
                            fileOutput.write(System.lineSeparator().getBytes());
                            fileOutput
                                    .write("----------------------------------------------------------------"
                                            .getBytes());

                            for (String queue : antrian) {
                                fileOutput.write(System.lineSeparator().getBytes());
                                fileOutput.write(String.format("| %-3s | %-20.20s | %-31s |\n",
                                        queue.substring(0, queue.indexOf('$')),
                                        queue.substring(queue.indexOf('$') + 1, queue.lastIndexOf('$')),
                                        queue.substring(queue.lastIndexOf('$') + 1)).getBytes());
                                fileOutput
                                        .write("----------------------------------------------------------------"
                                                .getBytes());
                            }

                            fileOutput.close();

                            System.out.println("==========================");
                            System.out.println("File Berhasil Disimpan di " + daftarAntrian.getAbsolutePath());
                        } catch (IOException error) {
                            System.out.println(error);
                            System.out.println("==========================");
                            System.out.println("Gagal Menyimpan File di " + daftarAntrian.getAbsolutePath());
                            continue;
                        }
                    }
                    continue;
                // Keluar
                case "6":
                    input.close();
                    break;
            }

        } while (!menu.equals("6"));

    }

}