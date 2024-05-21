/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayDeque;
import java.util.Queue;

import Model.Pasien;

/**
 *
 * @author TecRa Z50-C
 */
public class Controller {
    
    Queue<Pasien> antrian = new ArrayDeque<>();
    int nomor = 1;

    public void addPasien(String nama) {
        Pasien pasien = new Pasien();
        pasien.setNama(nama);
        pasien.setNomor(nomor);
        pasien.setStatus("Dalam Antrian");
        pasien.setWaktu();
        antrian.offer(pasien);
    }
    
}
