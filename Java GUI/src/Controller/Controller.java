/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pasien;
import java.util.ArrayList;

/**
 *
 * @author TecRa Z50-C
 */
public class Controller {
    
    private ArrayList<Pasien> antrian = new ArrayList<>();
    private int nomor = 0;
    
    public void addPasien(String nama) {
        nomor++;
        antrian.add(new Pasien(nama, nomor));
    }

    public int getNomor() {
        return nomor - 1;
    }
    
    public Pasien getPasien(int index) {
        return antrian.get(index);
    }
    
}
