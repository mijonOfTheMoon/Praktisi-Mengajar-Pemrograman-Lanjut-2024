package Controller;

import Model.TV;
import Model.Pengguna;
import Model.Peminjaman;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controller {
    
    private ArrayList<Pengguna> pengguna = new ArrayList<>();
    private ArrayList<TV> televisi = new ArrayList<>();
    private ArrayList<Peminjaman> peminjaman = new ArrayList<>();
    private Pengguna loginAdmin;

    public Controller() {
        pengguna.add(new Pengguna("", "Admin", "", "admin", "admin",  "Admin"));
        televisi.add(new TV("1", "PS 5", "Tersedia"));
        televisi.add(new TV("2", "PS 5", "Tersedia"));
        televisi.add(new TV("3", "XBOX", "Tersedia"));
        televisi.add(new TV("4", "XBOX", "Tersedia"));
        televisi.add(new TV("5", "PC", "Tersedia"));
    }
    
    public Pengguna getUser(int index) {
        return pengguna.get(index);
    }
    
    public int getJumlahUser(){
        return pengguna.size();
    }
    
    public void addUser(String id, String nama, String nomor, String role, String username, String password) {
        pengguna.add(new Pengguna (id, nama, nomor, role, username, password));
    }

    public void editUser(String startingId, String id, String nama, String nomor, String role, String username, String password) {
        pengguna.set(searchUserId(startingId), new Pengguna(id, nama, nomor, role, username, password));
    }

    public void delUser(String id) {
        pengguna.remove(searchUserId(id));
    }

    public int searchUserId(String id) {
        for (int i = 0; i < getJumlahUser(); i++) {
            if (pengguna.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public int searchUsername(String username) {
        for (int i = 0; i < getJumlahUser(); i++) {
            if (pengguna.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public int searchTV(String id) {
        for (int i = 0; i < getJumlahTV(); i++) {
            if (televisi.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addTV(String id, String jenis, String status) {
        televisi.add(new TV(id, jenis, status));
    }

    public void editTV(String id, String jenis, String status) {
        televisi.set(searchTV(id), new TV(id, jenis, status));
    }

    public void delTV(String id) {
        televisi.remove(searchTV(id));
    }
    
    public TV getTV(int index) {
        return televisi.get(index);
    }
    
    public int getJumlahTV(){
        return televisi.size();
    }

    public boolean addPeminjaman(Pengguna pengguna, TV televisi, String sesi) {
        String tanggalSekarang = new SimpleDateFormat("EEEEE, dd MMMM yyyy").format(new Date());

        for (Peminjaman peminjaman : peminjaman) {
            if (peminjaman.getTelevisi().getId().equals(televisi.getId()) &&
                peminjaman.getTanggal().equals(tanggalSekarang) &&
                peminjaman.getSesi().equals(sesi)) {
                return false;
            }
        }
        peminjaman.add(new Peminjaman(pengguna, televisi, sesi));
        return true;
    }

    public Peminjaman getPeminjaman(int index) {
        return peminjaman.get(index);
    }

    public Peminjaman getPeminjamanAktif(int indexTV) {
        for (Peminjaman peminjaman : peminjaman) {
            if (peminjaman.getStatus().equals("Sesi Berlangsung") && 
                peminjaman.getTelevisi().getId().equals(String.valueOf(indexTV + 1))) {
                return peminjaman;
            }
        }
        return null;
    }
    
    public int getJumlahPeminjaman() {
        return peminjaman.size();
    }

    public void refreshStatusPeminjaman() {
        SimpleDateFormat format = new SimpleDateFormat("EEEEE, dd MMMM yyyy HH:mm:ss");
        Date Sesi;
        Date Selesai;
        Date Sekarang;

        for (Peminjaman pinjaman : peminjaman) {
            try {
                Sesi = format.parse(pinjaman.getTanggal() + " " + pinjaman.getSesi().substring(0, 5) + ":00");
                Selesai = format.parse(pinjaman.getTanggal() + " " + pinjaman.getSesi().substring(8, 13) + ":00");
                Sekarang = format.parse(format.format(new Date()));
                if (Sekarang.before(Sesi)) {
                    pinjaman.setStatus("Sesi Belum Dimulai");
                } else if (Sekarang.after(Sesi) && Sekarang.before(Selesai)) {
                    pinjaman.setStatus("Sesi Berlangsung");
                } else {
                    pinjaman.setStatus("Sesi Selesai");
                }
            } catch (ParseException error) {
                error.printStackTrace();
            }
        }
    }

    public String getSisaWaktu(Peminjaman pinjamanAktif) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        Date waktuSelesai;
        Date waktuSekarang;
        String sisaWaktu = "";

        try {
            waktuSelesai = format.parse(pinjamanAktif.getSesi().substring(11, 13) + ":00");
            waktuSekarang = format.parse(format.format(new Date()));
            long sisa = waktuSelesai.getTime() - waktuSekarang.getTime();
            long menit = (sisa % 3600000) / 60000;
            long detik = (sisa % 60000) / 1000;
            sisaWaktu = String.format("%02d:%02d", 59 + menit, 59 + detik);
            return sisaWaktu;
        } catch (ParseException error) {
            error.printStackTrace();
        }
        
        return "-";
    }

    public String[] getSesiPeminjaman() {
        String[] sesi = new String[]{""};
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date jamSesi;
        Date jamSekarang;

        try {
            jamSesi = format.parse("08:00:00");
            jamSekarang = format.parse(format.format(new Date()));
            if (jamSekarang.before(jamSesi)) {
                sesi = new String[]{"08:00 - 09:00", "09:15 - 10:15", "10:30 - 11:30", "11:45 - 12:45", "13:00 - 14:00", "14:15 - 15:15", "15:30 - 16:30", "16:45 - 17:45"};
            } else {
                jamSesi = format.parse("09:15:00");
                if (jamSekarang.before(jamSesi)) {
                    sesi = new String[]{"09:15 - 10:15", "10:30 - 11:30", "11:45 - 12:45", "13:00 - 14:00", "14:15 - 15:15", "15:30 - 16:30", "16:45 - 17:45"};
                } else {
                    jamSesi = format.parse("10:30:00");
                    if (jamSekarang.before(jamSesi)) {
                        sesi = new String[]{"10:30 - 11:30", "11:45 - 12:45", "13:00 - 14:00", "14:15 - 15:15", "15:30 - 16:30", "16:45 - 17:45"};
                    } else {
                        jamSesi = format.parse("11:45:00");
                        if (jamSekarang.before(jamSesi)) {
                            sesi = new String[]{"11:45 - 12:45", "13:00 - 14:00", "14:15 - 15:15", "15:30 - 16:30", "16:45 - 17:45"};
                        } else {
                            jamSesi = format.parse("13:00:00");
                            if (jamSekarang.before(jamSesi)) {
                                sesi = new String[]{"13:00 - 14:00", "14:15 - 15:15", "15:30 - 16:30", "16:45 - 17:45"};
                            } else {
                                jamSesi = format.parse("14:15:00");
                                if (jamSekarang.before(jamSesi)) {
                                    sesi = new String[]{"14:15 - 15:15", "15:30 - 16:30", "16:45 - 17:45"};
                                } else {
                                    jamSesi = format.parse("15:30:00");
                                    if (jamSekarang.before(jamSesi)) {
                                        sesi = new String[]{"15:30 - 16:30", "16:45 - 17:45"};
                                    } else {
                                        jamSesi = format.parse("16:45:00");
                                        if (jamSekarang.before(jamSesi)) {
                                            sesi = new String[]{"16:45 - 17:45"};
                                        } else {
                                            sesi = new String[]{""};
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ParseException error) {
            error.printStackTrace();
        }
        return sesi;
    }

    public boolean login(String username, String password) {
        for (Pengguna user : pengguna) {
            if (user.getRole().equals("Admin")) {
                if(user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                    loginAdmin = user;
                    return true;
                }
            }
        }
        return false;
    }

    public Pengguna getLoginAdmin() {
        return loginAdmin;
    }

    public void saveRiwayatPeminjaman() {
        File file = new File("Riwayat Peminjaman Game Corner.txt");
        JFileChooser save = new JFileChooser();
        save.setSelectedFile(file);

        if (save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = save.getSelectedFile();
            try {
                file.createNewFile();
                FileOutputStream fileOutput = new FileOutputStream(file);

                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write(("Penanggung Jawab\t\t: " + getLoginAdmin().getNama()).getBytes());
                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write(("Tanggal Penyimpanan Riwayat\t: " + new SimpleDateFormat("EEEEE, dd MMMM yyyy HH:mm").format(new Date())).getBytes());
                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write("======================================== Riwayat Peminjaman Game Corner ========================================"
                        .getBytes());
                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write("----------------------------------------------------------------------------------------------------------------"
                        .getBytes());
                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write("|          Peminjam          |  Nomor TV  |      Tanggal Peminjaman      |     Sesi     |        Status        |"
                        .getBytes());
                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write("----------------------------------------------------------------------------------------------------------------"
                        .getBytes());

                for (Peminjaman pinjaman : peminjaman) {
                    fileOutput.write(System.lineSeparator().getBytes());
                    fileOutput.write(String.format( "| %-26.26s | %-10s | %-28s | %-12s | %-19s |\n",
                                                            pinjaman.getPengguna().getNama(),
                                                            "TV-" + pinjaman.getTelevisi().getId(),
                                                            pinjaman.getTanggal(),
                                                            pinjaman.getSesi(),
                                                            pinjaman.getStatus()).getBytes());
                }

                fileOutput.write(System.lineSeparator().getBytes());
                fileOutput.write("----------------------------------------------------------------------------------------------------------------"
                        .getBytes());
                fileOutput.close();

                JOptionPane.showMessageDialog(null, "Berhasil menyimpan file!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException error) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
