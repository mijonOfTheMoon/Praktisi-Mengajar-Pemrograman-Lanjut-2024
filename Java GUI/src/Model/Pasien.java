/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TecRa Z50-C
 */
public class Pasien {
    
    private String nama;
    private int nomor;
    private String status;
    private String waktu;
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu() {
        this.waktu = new SimpleDateFormat("EEEEE, dd MMMM yyyy, HH:mm").format(new Date());
    }
    
}
