/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//import java.sql.Statement;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
import Model.ModelMatkul;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
/**
 *
 * @author R O G
 */
//public class Mahasiswa {
//    private Database db;
//    private String sql;
//    private ArrayList<ModelMahasiswa> listMahasiswa = new ArrayList();
    
    public class ModelMahasiswa extends Human{
        private Database db;
        private String sql;
        private String nim;
        private ArrayList<ModelMatkul> listMatKul;
        
        public ModelMahasiswa(String NIM, String nama, String tanggalLahir) {
            super(nama, tanggalLahir);
            this.nim = nim;
            listMatKul = new ArrayList();
        }    

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }
        
        public void addMatkul(String id_jadwal) {
            try {
            db.connect();
            sql = "SELECT kode_mk, nama_mk, sks, nid FROM jadwal"
                    + "natural join mata_kuliah"
                    + "where id_jadwal = '" +id_jadwal+"';";
            db.setRs(db.getStmt().executeQuery(sql));
            while (db.getRs().next()) {
                ModelMatkul m = new ModelMatkul(
                    db.getRs().getString("kode_MK"),
                    db.getRs().getString("nama_MK"),
                    db.getRs().getString("SKS"),
                    db.getRs().getString("nid")
                );
                listMatKul.add(m);
            }
            db.disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
    
//    public Mahasiswa(Database a) {
//        db = a;
//        try {
//            db.connect();
//            sql = "SELECT * FROM mahasiswa";
//            db.setRs(db.getStmt().executeQuery(sql));
//            ModelMahasiswa m;
//            while (db.getRs().next()) {
//                m = new ModelMahasiswa(
//                    db.getRs().getString("nim"),
//                    db.getRs().getString("nama"),
//                    db.getRs().getString("tgl_lahir")
//                );
//                listMahasiswa.add(m);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();;
//        }
//    }
//    
//    public void addMahasiswa(ModelMahasiswa m){
//        //boolean value = false;
//        try{   
//            db.connect();
//            sql = "INSERT INTO mahasiswa VALUES('" + m.getNim()+ "','" + m.getNama() +"','"+ m.getTanggalLahir() +"')";
//            db.setRs(db.getStmt().executeQuery(sql));
//            db.disconnect();
//            listMahasiswa.add(m);
//            //value = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal, "+e.getMessage());
//        }
//        //return value;
//    }
//    
//    public void deleteMahasiswa(ModelMahasiswa m){
//        //boolean value = false;
//        try{   
//            db.connect();
//            sql = "DELETE FROM mahasiswa WHERE nim = '" + m.nim + "'";
//            db.setRs(db.getStmt().executeQuery(sql));
//            db.disconnect();
//            listMahasiswa.remove(m);
//            //value = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Delete Gagal, "+e.getMessage());
//        }
//        //return value;
//    }
//
//    public ArrayList<ModelMahasiswa> getListMahasiswa() {
//        return listMahasiswa;
//    }
//
//    public void setListMahasiswa(ArrayList<ModelMahasiswa> listMahasiswa) {
//        this.listMahasiswa = listMahasiswa;
//    }
//    
//    
//}
