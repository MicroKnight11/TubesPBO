/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author R O G
 */
public class Ruangan {
    private Database db;
    private String sql;
    private ArrayList<ModelRuangan> listRuang = new ArrayList();
    
    public class ModelRuangan extends ModelGedung{
        private String NO_Ruangan;
        private int kapasitas;
        
        public ModelRuangan(String KD_GD, String nama_GD, String NO_Ruangan, int kapasitas) {
            super(KD_GD, nama_GD);
            this.NO_Ruangan = NO_Ruangan;
            this.kapasitas = kapasitas;
        }
        
        public ModelRuangan(ModelGedung m, String NO_Ruangan, int kapasitas) {
            super(m.getKD_GD(),m.getNama_GD());
            this.NO_Ruangan = NO_Ruangan;
            this.kapasitas = kapasitas;
        }

        public String getNO_Ruangan() {
            return NO_Ruangan;
        }

        public void setNO_Ruangan(String NO_Ruangan) {
            this.NO_Ruangan = NO_Ruangan;
        } 
    }
    
    public Ruangan(Database a) {
        db = a;
        try {
            db.connect();
            sql = "SELECT * FROM ruangan"
                    + "natural join gedung";
            db.setRs(db.getStmt().executeQuery(sql));
            ModelRuangan m;
            while (db.getRs().next()) {
                m = new ModelRuangan(
                    db.getRs().getString("kode_gedung"),
                    db.getRs().getString("nama_gedung"),
                    db.getRs().getString("NO_Ruangan"),
                    db.getRs().getInt("kapasitas")
                );
                listRuang.add(m);
            }
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
     public void addRuang(ModelRuangan m){
        try{   
            db.connect();
            sql = "INSERT INTO ruangan VALUES ('"+m.NO_Ruangan+"','"+m.getKD_GD()+"','"+m.kapasitas+"')";
            db.setRs(db.getStmt().executeQuery(sql)); 
            db.disconnect();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal, "+e.getMessage());
        }
    }

}
