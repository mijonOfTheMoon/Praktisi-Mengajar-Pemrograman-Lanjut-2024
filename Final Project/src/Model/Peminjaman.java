package Model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Peminjaman {
    
    final private Pengguna pengguna;
    final private TV televisi;
    final private String tanggal;
    final private String sesi;
    private String status;

    public Peminjaman(Pengguna pengguna, TV televisi, String sesi) {
        this.pengguna = pengguna;
        this.televisi = televisi;
        this.tanggal = new SimpleDateFormat("EEEEE, dd MMMM yyyy").format(new Date());
        this.sesi = sesi;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public TV getTelevisi() {
        return televisi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getSesi() {
        return sesi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
