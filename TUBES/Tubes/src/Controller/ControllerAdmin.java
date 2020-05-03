package Controller;


import GUI.Admin;
import Model.Database;
import Model.ModelAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public class ControllerAdmin extends MouseAdapter implements ActionListener {
    private Admin view;
    private Database db;
    private Model.ModelAdmin admin = new ModelAdmin();
    
    public ControllerAdmin(Database db){
        this.db = db;
        view = new Admin();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setListRuangan(getRuangan());
        view.setListJadwal(getNoJadwal());
        view.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())) {
            String ruangan = view.getSelectedRuangan();
            String matkul = getKodeMk(view.getMatkul());
            ArrayList<String> hari = view.getHari();
            String id_jadwal = "jadwal" + getBanyakJadwal();
            for (String s : hari) {
                admin.addJadwal(id_jadwal, matkul, ruangan, s, db);
            }
            view.resetView();
            view.setListJadwal(getNoJadwal());            
        }
        else if (source.equals(view.getBtnDelete())) {
            String jadwal = view.getSelectedJadwal();
            admin.deleteJadwal(jadwal, db);
            view.resetView();
            view.setListJadwal(getNoJadwal());
        }
    }
    
    public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
        if (source.equals(view.getListJadwal())) {
            String id_jadwal = view.getSelectedJadwal();
            String detail = "";
            try {
                db.connect();
                String sql = "SELECT nim FROM jadwal WHERE id_jadwal = '"+ id_jadwal +"'";
                db.setRs(db.getStmt().executeQuery(sql));
                while(db.getRs().next()){
                    detail = detail + db.getRs().getString("nim") + "\n";
                }
                db.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            view.setTxJadwal(detail);
        }
    }
    
    public String[] getRuangan() {
        String[] listRuangan = new String[db.getListRuangan().size()];
        for (int i = 0; i < listRuangan.length; i++) {
            listRuangan[i] = db.getListRuangan().get(i).getNO_Ruangan();
        }
        return listRuangan;
    }
    
    public String[] getNoJadwal() {
        String[] jadwal = new String[getBanyakJadwal()];
        try {
            db.connect();
            String sql = "SELECT id_jadwal FROM jadwal";
            db.setRs(db.getStmt().executeQuery(sql));
            int i = 0;
            while (db.getRs().next()){
                jadwal[i] = db.getRs().getString("id_jadwal");
                i++;
            }
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jadwal;
    }
    
    public int getBanyakJadwal() {
        int i = 0;
        try {
            db.connect();
            String sql = "SELECT id_jadwal FROM jadwal";
            db.setRs(db.getStmt().executeQuery(sql));
            while (db.getRs().next()){
                i++;
            }
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        i++;
        return i;
    }
    
    public String getKodeMk(String nama_mk) {
        String kode = null;
        try {
            db.connect();
            String sql = "SELECT kode_mk FROM mata_kuliah WHERE nama_mk = '" + nama_mk +"'";
            db.setRs(db.getStmt().executeQuery(sql));
            while(db.getRs().next()) {
                kode = db.getRs().getString("kode_mk");
            }
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return kode;
    }
    
}
