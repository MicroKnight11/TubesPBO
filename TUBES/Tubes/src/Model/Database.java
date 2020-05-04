package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author satria
 */
public class Database {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/XE";
    private static final String USER = "PBO";
    private static final String PASS = "tubes";
    
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private String sql;
    
    private ArrayList<ModelRuangan> listRuangan = new ArrayList();
    private ArrayList<ModelDosen> listDosen = new ArrayList();
    private ArrayList<ModelMahasiswa> listMahasiswa = new ArrayList();
    private ArrayList<ModelMatkul> listMatkul = new ArrayList();
    
    public Database() {
        loadDosen();
        loadMahasiswa();
        loadMatkul();
        loadRuangan();
    }

    public void connect() throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
    }
    
    public void disconnect() throws SQLException {
        stmt.close();
        conn.close();
    }
    
    public Connection getConn() {
        return conn;
    }

    public ResultSet getRs() {
        return rs;
    }
    
    public Statement getStmt() {
        return stmt;
    }

    public static void setRs(ResultSet rs) {
        Database.rs = rs;
    }

    public void loadDosen() {
      try {
            connect();
            sql = "SELECT * FROM dosen";
            rs = stmt.executeQuery(sql);
            ModelDosen m;
            while (rs.next()) {
                m = new ModelDosen(
                    rs.getString("nid"),
                    rs.getString("nama_dosen")
                );
            listDosen.add(m);
            }
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();;
        }          
    }

    public void loadMahasiswa() {
        try {
           connect();
           sql = "SELECT * FROM mahasiswa";
           rs = stmt.executeQuery(sql);
           ModelMahasiswa m;
           while (rs.next()) {
               m = new ModelMahasiswa(
                   rs.getString("nim"),
                   rs.getString("nama_mhs")
               );
            listMahasiswa.add(m);
           }
           disconnect();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void loadRuangan() {
        try {
           connect();
           sql = "SELECT * FROM ruangan"
                   + " natural join gedung";
           rs = stmt.executeQuery(sql);
           ModelRuangan m;
           while (rs.next()) {
               m = new ModelRuangan(
                   rs.getString("kode_gedung"),
                   rs.getString("nama_gedung"),
                   rs.getString("NO_Ruangan"),
                   rs.getInt("kapasitas")
               );
            listRuangan.add(m);
           }
           disconnect();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void loadMatkul() {
        try {
           connect();
           sql = "SELECT * FROM mata_kuliah";
           rs = stmt.executeQuery(sql);
           ModelMatkul m;
           while (rs.next()) {
                m = new ModelMatkul(
                   rs.getString("kode_MK"),
                   rs.getString("nama_MK"),
                   rs.getString("SKS")
//                   rs.getString("nid"),
//                   this
                );
                listMatkul.add(m);
           }
           disconnect();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public ArrayList<ModelRuangan> getListRuangan() {
        return listRuangan;
    }

    public ArrayList<ModelDosen> getListDosen() {
        return listDosen;
    }

    public ArrayList<ModelMahasiswa> getListMahasiswa() {
        return listMahasiswa;
    }

    public ArrayList<ModelMatkul> getListMatkul() {
        return listMatkul;
    }
    
}
