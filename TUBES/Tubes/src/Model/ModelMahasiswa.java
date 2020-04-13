/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//import java.sql.Statement;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author R O G
 */
public class ModelMahasiswa extends Human {
    private String NIM;
    private ArrayList<ModelMatkul> listMatKul;
//    Statement stat;
//    String sql;
//    int status;
//    int id;

    public ModelMahasiswa(String NIM, String nama, String tanggalLahir) {
        super(nama, tanggalLahir);
        this.NIM = NIM;
    }    

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }
    
//    public boolean addMahasiswa(String NIM , String Nama, String TanggalLahir, String Alamat, String Nilai){
//        boolean value = false;
//
//        try{            
//            sql = "INSERT INTO mahasiswa VALUES ('"+NIM+"','"+Nama+"','"+TanggalLahir+"','"+Alamat+"','"+Nilai+"')";
//            stat.executeUpdate(sql);            
//            value = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal, "+e.getMessage());
//        }
//        
//        
//        return value;
//    }

}
