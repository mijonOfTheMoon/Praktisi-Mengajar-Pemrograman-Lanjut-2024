/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pasien;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

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
    
    public void flushPasien() {
        antrian.clear();
        nomor = 0;
    }
    
    public void saveTXT(String status) {
        JFileChooser saver = new JFileChooser();
        saver.showSaveDialog(saver);
        
        File file = saver.getSelectedFile();
        

        try {
            file.createNewFile();
            FileOutputStream fileOutput = new FileOutputStream(file);
            
            fileOutput.write(System.lineSeparator().getBytes());
            fileOutput.write("=============================== Daftar Antrian Pasien ===============================".getBytes());
            fileOutput.write(System.lineSeparator().getBytes());
            fileOutput.write("-------------------------------------------------------------------------------------".getBytes());
            fileOutput.write(System.lineSeparator().getBytes());
            fileOutput.write("| No. | Nama Pasien          | Waktu Pengambilan Nomor Antrian |       Status       |".getBytes());
            fileOutput.write(System.lineSeparator().getBytes());
            fileOutput.write("-------------------------------------------------------------------------------------".getBytes());
            
            for(Pasien pasien : antrian) {
                if (pasien.getStatus().equals(status) || status.equals("Semua")) {
                    fileOutput.write(System.lineSeparator().getBytes());
                    fileOutput.write(String.format("| %-3s | %-20.20s | %-31s | %-18s |\n",
                                            pasien.getNomor(),
                                            pasien.getNama(),
                                            pasien.getWaktu(),
                                            pasien.getStatus()).getBytes());
                }
            }
            
            fileOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getJumlahPasien() {
        return antrian.size();
    }
    
    public int getNomor() {
        return nomor - 1;
    }
    
    public Pasien getPasien(int index) {
        return antrian.get(index);
    }
    
}
