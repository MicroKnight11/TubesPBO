/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
//import java.sql.Statement;
//import javax.swing.JOptionPane;

/**
 *
 * @author R O G
 */
//public class Matkul {
//    private Database db;
//    private String sql;
//   // private Statement stat;
//    private ArrayList<ModelMatkul> listMatkul = new ArrayList();
    
    public class ModelMatkul {
        private Database db;
        private String sql;
        private String KD_MK;
        private String nama_MK;
        private String SKS;
        private ModelDosen Dsn;
        
        public ModelMatkul(String KD_MK, String nama_MK, String SKS) {
            this.KD_MK = KD_MK;
            this.nama_MK = nama_MK;
            this.SKS = SKS;
        }
        
        public ModelMatkul(String KD_MK, String nama_MK, String SKS, String nid) {
            this.KD_MK = KD_MK;
            this.nama_MK = nama_MK;
            this.SKS = SKS;
            try {
                db.connect();
                sql = "SELECT * FROM dosen where nid = '"+nid+"';";
                db.setRs(db.getStmt().executeQuery(sql));
                ModelDosen m;
                while (db.getRs().next()) {
                    m = new ModelDosen(
                        db.getRs().getString("nid"),
                        db.getRs().getString("kelompok_keahlian"),
                        db.getRs().getString("nama_dosen"),
                        db.getRs().getString("tgl_lahir")
                    );
                Dsn = m;
                }
            } catch (Exception e) {
                e.printStackTrace();;
            }            
        }
        
        public String getKD_MK() {
            return KD_MK;
        }

        public void setKD_MK(String KD_MK) {
            this.KD_MK = KD_MK;
        }

        public String getNama_MK() {
            return nama_MK;
        }

        public void setNama_MK(String nama_MK) {
            this.nama_MK = nama_MK;
        }

        public String getSKS() {
            return SKS;
        }

        public void setSKS(String SKS) {
            this.SKS = SKS;
        }

        public ModelDosen getDsn() {
            return Dsn;
        }

        public void setDsn(ModelDosen Dsn) {
            this.Dsn = Dsn;
        }
    }
    
//     public Matkul (Database a) {
//        db = a;
//        try {
//            db.connect();
//            sql = "SELECT * FROM matkul";
//            db.setRs(db.getStmt().executeQuery(sql));
//            ModelMatkul m;
//            while (db.getRs().next()) {
//                m = new ModelMatkul(
//                    db.getRs().getString("kode_MK"),
//                    db.getRs().getString("nama_MK"),
//                    db.getRs().getString("SKS")
//                );
//                listMatkul.add(m);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();;
//        }
//    }
//    
//    public void addMatkul(ModelMatkul m){
//        //boolean value = false;
//        try{   
//            db.connect();
//            sql = "INSERT INTO matkul VALUES('" + m.getKD_MK()+ "','" + m.getNama_MK() +"','"+ m.getSKS() +"')";
//            db.setRs(db.getStmt().executeQuery(sql));
//            db.disconnect();
//            listMatkul.add(m);
//            //value = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal, "+e.getMessage());
//        }
//        //return value;
//    }
//    
//    public void deleteMatkul(ModelMatkul m){
//        //boolean value = false;
//        try{   
//            db.connect();
//            sql = "DELETE FROM matkul WHERE KD_MK = '" + m.getKD_MK() + "'";
//            db.setRs(db.getStmt().executeQuery(sql));
//            db.disconnect();
//            listMatkul.remove(m);
//            //value = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Delete Gagal, "+e.getMessage());
//        }
//        //return value;
//    }
//    
////     public ArrayList<ModelMatkul> getListMatkul() {
////        return listMahatkul;
////    }
//
//    public void setListMatkul(ArrayList<ModelMatkul> listMatkul) {
//        this.listMatkul = listMatkul;
//    }
//}
