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
    
    final private String nama;
    final private int nomor;
    private String status;
    final private String waktu;
    
    public Pasien(String nama, int nomor) {
        this.nama = nama;
        this.nomor = nomor;
        this.status = "Dalam Antrian";
        this.waktu = new SimpleDateFormat("EEEEE, dd MMMM yyyy, HH:mm").format(new Date());
    }

    public String getNama() {
        return nama;
    }

    public int getNomor() {
        return nomor;
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
    
}
