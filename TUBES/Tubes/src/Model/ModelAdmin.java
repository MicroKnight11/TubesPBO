/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import Controller.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author R O G
 */
public class ModelAdmin {   
//    private int id;
//    private ArrayList<ModelMatkul> Mk;

//    public ModelAdmin() {
//        this.Mk = new ArrayList<>();
//    }
//   
//    public void addMatkul(ModelMatkul e){
//        this.Mk.add(e);
//    }
//    
//    public void delMatkul(ModelMatkul MK){
//        this.Mk.remove(MK);
//    }
    private Database db;
    private String sql;
    
    public void addJadwal(String id_jadwal, String kode_mk, String no_ruangan, String waktu) {
        try {
            db.connect();
            sql = "INSERT INTO jadwal VALUES ('"
                    +id_jadwal+"','"
                    +kode_mk+"','"
                    +no_ruangan+"','"
                    +waktu+"',null);";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteJadwal(String id_jadwal) {
        try{
            db.connect();
            sql = "DELETE FROM jadwal WHERE id_jadwal = '" + id_jadwal +"';";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteMahasiswa(String nim) {
        try{
            db.connect();
            sql = "DELETE FROM jadwal WHERE nim = '" + nim +"';";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
