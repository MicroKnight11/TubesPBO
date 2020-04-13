/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.Database;
import java.sql.SQLException;

/**
 *
 * @author satria
 */
public class DAOMatKul extends DAO {
    
    public DAOMatKul(Database DB) {
        super(DB, "mata_kuliah");
    }
    
    public void insert(Model.ModelMatkul m) throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "INSERT INTO "+ table +" VALUES('" + m.getKD_MK() + "','" + m.getNama_MK() +"','"+ m.getSKS() +"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Insert success");
        DB.disconnect();
    }
    
    public void insert(String KD, String nama, String SKS) throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "INSERT INTO "+ table +" VALUES('" + KD + "','" + nama + "','"+ SKS +"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Insert success");
        DB.disconnect();
    }

    public void delete(Model.ModelMatkul m) throws SQLException, ClassNotFoundException {
        super.delete(m.getKD_MK());
    }

    public void updateKD(Model.ModelMatkul m, String KD) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET kode = '" + KD + "' WHERE nim = '" + m.getKD_MK() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateNama(Model.ModelMatkul m, String nama) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET nama = '" + nama + "' WHERE nim = '" + m.getKD_MK() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateSKS(Model.ModelMatkul m, String SKS) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET sks = '" + SKS + "' WHERE nim = '" + m.getKD_MK() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void get(Model.ModelMatkul m) throws SQLException, ClassNotFoundException {
        super.get(m.getKD_MK());
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
