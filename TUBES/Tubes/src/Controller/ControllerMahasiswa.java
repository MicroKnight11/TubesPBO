package Controller;


import GUI.GUIMahasiswa;
import Model.Database;
import Model.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Database db;
    
    public ControllerMahasiswa(Database db) {
        this.db = db;
        view = new GUIMahasiswa();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setDaftarMatkul(getMatkul());
        combobox();
        view.setVisible(true);
    }
    public String[] getMatkul() {
        if (db.getListMatkul().size() <= 0){
            JOptionPane.showMessageDialog(null, "Matkul Kosong");
        } else {
            String[] listMatkul = new String[db.getListMatkul().size()];
            for (int i = 0; i < listMatkul.length; i++) {
                listMatkul[i] = db.getListMatkul().get(i).getNama_MK();
            }
        }
        return null;
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
                        String nim = view.getTfNIM();
                        String id_jadwal = view.getCbJadwalText();
                        if (nama == null || nim == null || id_jadwal == null) {
                            JOptionPane.showMessageDialog(view, "Input Belum Benar");
                        }else{
                            int i = getRollNum() + 1;
                            ModelMahasiswa mhs = new ModelMahasiswa(nim, nama);
                            mhs.addMhs(db);
                            mhs.addJadwal(id_jadwal, i, db);
                            mhs.addMatkul(id_jadwal, db);
                            view.resetView();  
                        }
                                     
                } catch (Exception es) {
                    es.printStackTrace();
//                    JOptionPane.showMessageDialog(null, "input salah") ;                 
                }
            }
        } catch (Exception ef) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getListMatkul())) {
            String nama_mk = view.getSelectedMatkul();
            try {
                int i = 0;
                db.connect();
                String sql = "SELECT * FROM mahasiswa NATURAL JOIN enroll NATURAL JOIN jadwal NATURAL JOIN mata_kuliah WHERE nama_mk = '"+ nama_mk +"'";
                db.setRs(db.getStmt().executeQuery(sql));
                view.resetTable();
                while(db.getRs().next()){
                   view.setTabel(
                           db.getRs().getString("nama_mhs"),
                           db.getRs().getString("nim"),
                           i);
                    i++;                                            
                }
                db.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void combobox(){
        view.getCbJadwal().addItem("pilih");
        try{
            db.connect();
            String sql = "SELECT id_jadwal FROM jadwal ORDER BY id_jadwal ASC";
            db.setRs(db.getStmt().executeQuery(sql));
            while(db.getRs().next()){
                String name = db.getRs().getString("id_jadwal");
                view.getCbJadwal().addItem(name); 
            }
            db.disconnect();
            view.getCbJadwal().addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    try{
                        if (view.getCbJadwalText()== "pilih"){
                            view.setJtHari(null);
                            view.setJtMatkul(null);
                            view.setJtRuang(null);
                        }
                        else{
                            db.connect();
                            String sql = "SELECT * FROM jadwal"
                                + " NATURAL JOIN mata_kuliah"
                                + " WHERE id_jadwal = '"+ view.getCbJadwalText()+"'";
                            db.setRs(db.getStmt().executeQuery(sql));
                            while(db.getRs().next()){
                                view.setJtHari(db.getRs().getString("waktu"));
                                view.setJtMatkul(db.getRs().getString("kode_mk"));
                                view.setJtRuang(db.getRs().getString("no_ruangan"));
                            }
                        }                           
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public int getRollNum() {
        int i = 0;
        try {
            db.connect();
            String sql = "SELECT no_enroll FROM enroll ORDER BY no_enroll ASC";
            db.setRs(db.getStmt().executeQuery(sql));
            while (db.getRs().next()) {                
                i = db.getRs().getInt("no_enroll");
            }
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
// buat mahasiswa
    
//    public boolean cekRuangan (String id_jadwal) {
//        boolean a = true;
//        int i = 0;
//        try {
//            db.connect();
//            String sql = "SELECT no_enroll FROM enroll WHERE id_jadwal = '" + id_jadwal + "'";
//            db.setRs(db.getStmt().executeQuery(sql));
//            while(db.getRs().next()) {
//                i++;
//            }
//            sql = "SELECT kapasitas FROM jadwal NATURAL JOIN ruangan WHERE id_jadwal = '" + id_jadwal + "'";
//            db.setRs(db.getStmt().executeQuery(sql));
//            while(db.getRs().next()) {
//               if (i >= db.getRs().getInt("kapasitas")){
//                   a = false;
//               }
//            }
//            db.disconnect();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return a;
//    }
    
}
