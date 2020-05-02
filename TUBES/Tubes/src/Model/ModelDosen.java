/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author R O G
 */
//public class Dosen {

//    private ArrayList<ModelDosen> listDosen = new ArrayList();
//    
    public class ModelDosen extends Human{
        private String KK;
        private String NID;
        private Database db;
        private String sql; 
        
        public ModelDosen(String NID, String KK, String nama, String tanggalLahir) {
            super(nama, tanggalLahir);
            this.KK = KK;
            this.NID = NID;
        }
    
        public String getKK() {
            return KK;
        }
    
        public void setKK(String KK) {
            this.KK = KK;
        }
    
        public String getNID() {
            return NID;
        }
    
        public void setNID(String NID) {
            this.NID = NID;
        }
        
        public void liatJadwal(String id_jadwal) {
            try{
                db.connect();
                sql = "SELECT * FROM jadwal WHERE id_jadwal = '" + id_jadwal +"';";
                db.setRs(db.getStmt().executeQuery(sql));
                
                db.disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
//    public Dosen(Database a) {
//        db = a;
//        try {
//            db.connect();
//            sql = "SELECT * FROM dosen";
//            db.setRs(db.getStmt().executeQuery(sql));
//            ModelDosen m;
//            while (db.getRs().next()) {
//                m = new ModelDosen(
//                    db.getRs().getString("nik"),
//                    db.getRs().getString("kelompok_keahlian"),
//                    db.getRs().getString("nama"),
//                    db.getRs().getString("tgl_lahir")
//                );
//                listDosen.add(m);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();;
//        }
//    }
//    public void addDosen(ModelDosen m) {
//        try {
//            db.connect();
//            sql = "INSERT INTO dosen VALUES('" + m.getNID() + "','" + m.getNama() + "','"+m.getKK()+"','"+m.getTanggalLahir()+"')";
//            db.setRs(db.getStmt().executeQuery(sql));
//            System.out.println("Insert success");
//            db.disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(Dosen.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Dosen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void deleteDosen(ModelDosen m) {
//        try {
//            db.connect();
//            sql = "DELETE FROM dosen WHERE nik = '" + m.NID + "'";
//            db.setRs(db.getStmt().executeQuery(sql));
//            db.disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(Dosen.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Dosen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
