package Controller;


import GUI.GUIMahasiswa;
import Model.Database;
import Model.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public class ControllerMahasiswa extends MouseAdapter implements ActionListener{
    private GUIMahasiswa view;
    Database db;
    private ModelMahasiswa mhs;
    private ArrayList<ModelMahasiswa> daftarmhs;
    
    public ControllerMahasiswa(Database db) {
        view = new GUIMahasiswa(db);
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setDaftarMatkul(getMatkul());
        view.setVisible(true);
    }
    public String[] getMatkul() {
        String[] listMatkul = new String[db.getListMatkul().size()];
        for (int i = 0; i < listRuangan.length; i++) {
            listMatkul[i] = db.getListMatkul().get(i).getNama_MK();
        }
        return listMatkul;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source.equals(view.getBtnBack())) {
                new Controller();
                view.dispose();
            } 
            else if (source.equals(view.getBtnAdd())) {
                try {
                        String nama = view.getNama();
                        String kelas = view.getTfKelas();
                        String nim = view.getTfNIM();
                        int i = get
                        view.resetView();
                        liatJadwal(NID, db);
                    
                } catch (Exception es) {
                    System.out.println("Error 404 "+ es.getMessage());
                    JOptionPane.showMessageDialog(null, "Data Dosen Tidak DItemukan");
                }
            }
        } catch (Exception ef) {
            JOptionPane.showMessageDialog(null, "Data Dosen Tidak DItemukan");
        }
    }
}
