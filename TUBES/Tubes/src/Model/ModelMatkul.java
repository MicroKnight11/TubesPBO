/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
//import java.sql.Statement;
//import javax.swing.JOptionPane;

/**
 *
 * @author R O G
 */
public class ModelMatkul {
    private String KD_MK;
    private String nama_MK;
    private String SKS;
    private ArrayList<ModelMahasiswa> Mhs;
    private ModelDosen Dsn;
//    String sql;
//    Statement stat;
    
    
    public ModelMatkul(String KD_MK, String nama_MK, String SKS) {
        this.KD_MK = KD_MK;
        this.nama_MK = nama_MK;
        this.SKS = SKS;
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

//    public void addMahasiswa(ModelMahasiswa mhs) {
//        this.Mhs.add(mhs);
//    }
//    
//    public void delMahasiswa(ModelMahasiswa mhs) {
//        this.Mhs.remove(mhs);
//    }
    
//    public boolean addMatkul(String KD_MK, String Nama_MK, String SKS) {
//        boolean value = false;
//        System.out.println(value);
//        try{            
//            sql = "INSERT INTO matakuliah VALUES ('"+KD_MK+"','"+Nama_MK+"','"+SKS+"')";
//            stat.executeUpdate(sql);            
//            value = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal, "+e.getMessage());
//        }
//        
//        return value;
//    
//    }
}
