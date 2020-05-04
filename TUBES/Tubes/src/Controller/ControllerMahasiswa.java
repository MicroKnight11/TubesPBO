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
        this.db = db;
        view = new GUIMahasiswa();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setDaftarMatkul(getMatkul());
        combobox();
        view.setVisible(true);
    }
    public String[] getMatkul() {
        String[] listMatkul = new String[db.getListMatkul().size()];
        for (int i = 0; i < listMatkul.length; i++) {
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
                        String nim = view.getTfNIM();
                        String matkul = view.getTfMatkul();
                        mhs.addMhs(nama, nim,matkul, db);
                        view.resetView();                    
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(null, "input salah")  ;                 
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
                        if (view.getCbJadwalIndex() == "pilih"){
                            view.setJtHari(null);
                            view.setJtMatkul(null);
                            view.setJtRuang(null);
                        }
                        else{
                            db.connect();
                            String sql = "SELECT * FROM jadwal"
                                + " NATURAL JOIN mata_kuliah"
                                + " WHERE id_jadwal = '"+ view.getCbJadwalIndex()+"'";
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
}
