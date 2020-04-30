/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import Model.Database;
import Model.Matkul;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author R O G
 */
public class ModelRuangan extends ModelGedung{
    private String KD_Ruangan;
    Statement stat;
    String sql;
    int status;
    int id;
    private ArrayList<ModelRuangan> listRuang = new ArrayList();
    
    public class Ruangan{
       private String KD_Ruangan;
       public Ruangan(String KD_GD, String nama_GD, String KD_Ruangan) {
            super(KD_GD, nama_GD);
            this.KD_Ruangan = KD_Ruangan;
        }

        public String getKD_Ruangan() {
            return KD_Ruangan;
        }

        public void setKD_Ruangan(String KD_Ruangan) {
            this.KD_Ruangan = KD_Ruangan;
        } 
    }
    
    public ModelRuangan(Database a) {
        db = a;
        try {
            db.connect();
            sql = "SELECT * FROM ruangan";
            db.setRs(db.getStmt().executeQuery(sql));
            Ruangan m;
            while (db.getRs().next()) {
                m = new Ruangan(
                    db.getRs().getString("KD_Ruangan"),
                );
                listRuang.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
     public boolean addRuang(String kodeGedung, String namaGedung , String kodeRuangan){
        boolean value = false;

        try{            
            sql = "INSERT INTO gedung VALUES ('"+kodeGedung+"','"+namaGedung+"')";
            stat.executeUpdate(sql);            
            value = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal, "+e.getMessage());
        }
        
        return value;
    }

}
