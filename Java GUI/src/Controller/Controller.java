/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pasien;
import View.MainMenu;
import java.util.ArrayList;

/**
 *
 * @author TecRa Z50-C
 */
public class Controller {
    
    private ArrayList<Pasien> antrian = new ArrayList<>();
    private int nomor = 0;
    
    public Pasien getAntrian(int index) {
        return antrian.get(index);
    }

    public void setAntrian(ArrayList<Pasien> antrian) {
        this.antrian = antrian;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public void addPasien(String nama) {
        nomor++;
        Pasien pasien = new Pasien();
        pasien.setNama(nama);
        pasien.setNomor(nomor);
        pasien.setStatus("Dalam Antrian");
        pasien.setWaktu();
        antrian.add(pasien);
    }
    
    public void mulaiApp() {
        new MainMenu().setVisible(true);
    }
    
}
