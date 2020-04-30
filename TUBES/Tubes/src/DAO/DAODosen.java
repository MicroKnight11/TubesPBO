/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Database;
import java.sql.SQLException;

/**
 *
 * @author satria
 */
public class DAODosen extends DAO {
     
    public DAODosen(Database DB) {
        super(DB, "dosen");
    }

    public void insert(Model.ModelDosen m) throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "INSERT INTO "+ table +" VALUES('" + m.getNID() + "','" + m.getNama() + "','"+m.getKK()+"','"+m.getTanggalLahir()+"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Insert success");
        DB.disconnect();
    }
    
    public void insert(String nid, String nama, String KK, String tanggalLahir) throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "INSERT INTO "+ table +" VALUES('" + nid + "','" + nama + "'"+ KK +"','"+ tanggalLahir +"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Insert success");
        DB.disconnect();
    }

    public void delete(Model.ModelDosen m) throws SQLException, ClassNotFoundException {
        super.delete(m.getNID());
    }

    public void updateNID(Model.ModelDosen m, String nid) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET nid = '" + nid + "' WHERE nid = '" + m.getNID() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateNama(Model.ModelDosen m, String nama) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET nama = '" + nama + "' WHERE nid = '" + m.getNID() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateKK(Model.ModelDosen m, String KK) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET kelompok_keahlian = '" + KK + "' WHERE nid = '" + m.getNID() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateTanggalLahir(Model.ModelDosen m, String tanggalLahir) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET tanggal_lahir = '" + tanggalLahir + "' WHERE nim = '" + m.getNID() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void get(Model.ModelDosen m) throws SQLException, ClassNotFoundException {
        super.get(m.getNID());
    }

    @Override
    public void get(String nama) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "SELECT * FROM " + table + " WHERE nama LIKE '%" + nama + "%'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        while (DB.getRs().next()) {                
            for (int i = 0; i < column.size(); i++) {
                System.out.println(DB.getRs().getString(column.get(i)));
            }
        }
    }
}
