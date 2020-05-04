/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author R O G
 */

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
    
