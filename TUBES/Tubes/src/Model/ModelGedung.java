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
//public class Gedung {
//    private Database db;
//    private String sql;
//    private ArrayList<ModelGedung> listGedung = new ArrayList();
//    
    public class ModelGedung {
        private String KD_GD;
        private String nama_GD;

        public ModelGedung(String KD_GD, String nama_GD) {
            this.KD_GD = KD_GD;
            this.nama_GD = nama_GD;
        }

        public String getKD_GD() {
            return KD_GD;
        }

        public void setKD_GD(String KD_GD) {
            this.KD_GD = KD_GD;
        }

        public String getNama_GD() {
            return nama_GD;
        }

        public void setNama_GD(String nama_GD) {
            this.nama_GD = nama_GD;
        }    
    }
    
//    public Gedung(Database a) {
//        db = a;
//        try {
//            db.connect();
//            sql = "SELECT * FROM Gedung";
//            db.setRs(db.getStmt().executeQuery(sql));
//            while (db.getRs().next()) {
//                listGedung.add(new ModelGedung(db.getRs().getString("kode_gedung"), db.getRs().getString("nama_gedung")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();;
//        }
//    }
//
//    public ArrayList<ModelGedung> getListGedung() {
//        return listGedung;
//    }
//
//    public void setListGedung(ArrayList<ModelGedung> listGedung) {
//        this.listGedung = listGedung;
//    }
//}

