package Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

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
    
    
//    //DAO Mahasiswa
//    
//    public void getAllMahasiswa() throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "SELECT * FROM mahasiswa";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {                
//            System.out.println("NIM = " + rs.getString("nim"));
//            System.out.println("nama = " + rs.getString("nama"));
//        }
//        disconnect();
//    }
//    
//    public void getMahasiswaByNama(String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "SELECT * FROM mahasiswa WHERE nama = '" + nama + "'";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {                
//            System.out.println("NIM = " + rs.getString("nim"));
//            System.out.println("nama = " + rs.getString("nama"));
//        }
//        disconnect();
//    }
//    public void getMahasiswaByNim(String nim) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "SELECT * FROM mahasiswa WHERE nim = '" + nim + "'";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {                
//            System.out.println("NIM = " + rs.getString("nim"));
//            System.out.println("nama = " + rs.getString("nama"));
//        }
//        disconnect();
//    }
//    
//    public void insertMahasiswa(String nim, String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "INSERT INTO mahasiswa VALUES('" + nim + "','" + nama + "')";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Insert success");
//        disconnect();
//    }
//    
//    public void deleteMahasiswaByNama(String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "DELETE FROM mahasiswa WHERE nama = '" + nama + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Deletete success");
//        disconnect();
//    }
//    public void deleteMahasiswaByNim(String nim) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Delete success");
//        disconnect();
//    }
//    
//    public void updateNamaMahasiswaByNim(String nim, String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "UPDATE mahasiswa SET nama = '" + nama + "' WHERE nim = '" + nim + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Update success");
//        disconnect();
//    }
//    
//    public void updateNimMahasiswaByNama(String nim, String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "UPDATE mahasiswa SET nim = '" + nim + "' WHERE nama = '" + nama + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Update success");
//        disconnect();
//    }
//    
//    //DAO Dosen
//    
//    public void getAllDosen() throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "SELECT * FROM dosen";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {                
//            System.out.println("NIP = " + rs.getString("nip"));
//            System.out.println("nama = " + rs.getString("nama"));
//        }
//        disconnect();
//    }
//    
//    public void getDosenByNama(String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "SELECT * FROM dosen WHERE nama = '" + nama + "'";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {                
//            System.out.println("NIP = " + rs.getString("nip"));
//            System.out.println("nama = " + rs.getString("nama"));
//        }
//        disconnect();
//    }
//    public void getDosenByNip(String nip) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "SELECT * FROM mahasiswa WHERE nip = '" + nip + "'";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {                
//            System.out.println("NIP = " + rs.getString("nip"));
//            System.out.println("nama = " + rs.getString("nama"));
//        }
//        disconnect();
//    }
//    
//    public void insertDosen(String nip, String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "INSERT INTO dosen VALUES('" + nip + "','" + nama + "')";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Insert success");
//        disconnect();
//    }
//    
//    public void deleteDosenByNama(String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "DELETE FROM dosen WHERE nama = '" + nama + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Delete success");
//        disconnect();
//    }
//    public void deleteDosenByNip(String nip) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "DELETE FROM dosen WHERE nip = '" + nip + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Delete success");
//        disconnect();
//    }
//    
//    public void updateNamaDosenByNip(String nip, String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "UPDATE dosen SET nama = '" + nama + "' WHERE nip = '" + nip + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Update success");
//        disconnect();
//    }
//    
//    public void updateNipDosenByNama(String nip, String nama) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "UPDATE dosen SET nip = '" + nip + "' WHERE nama = '" + nama + "'";
//        rs = stmt.executeQuery(sql);
//        System.out.println("Update success");
//        disconnect();
//    }

    public static void setRs(ResultSet rs) {
        Database.rs = rs;
    }

}
