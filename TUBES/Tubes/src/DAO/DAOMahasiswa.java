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
public class DAOMahasiswa extends DAO {

    public DAOMahasiswa(Database DB) {
        super(DB, "mahasiswa");
    }

    public void insert(Model.ModelMahasiswa m) throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "INSERT INTO "+ table +" VALUES('" + m.getNIM() + "','" + m.getNama() +"','"+ m.getTanggalLahir() +"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Insert success");
        DB.disconnect();
    }
    
    public void insert(String nim, String nama, String tanggalLahir) throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "INSERT INTO "+ table +" VALUES('" + nim + "','" + nama + "','"+ tanggalLahir +"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Insert success");
        DB.disconnect();
    }

    public void delete(Model.ModelMahasiswa m) throws SQLException, ClassNotFoundException {
        super.delete(m.getNIM());
    }

    public void updateNIM(Model.ModelMahasiswa m, String nim) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET nim = '" + nim + "' WHERE nim = '" + m.getNIM() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateNama(Model.ModelMahasiswa m, String nama) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET nama = '" + nama + "' WHERE nim = '" + m.getNIM() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void updateTanggalLahir(Model.ModelMahasiswa m, String tanggalLahir) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "UPDATE "+ table +" SET tanggal_lahir = '" + tanggalLahir + "' WHERE nim = '" + m.getNIM() + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Update success");
        DB.disconnect();
    }
    
    public void get(Model.ModelMahasiswa m) throws SQLException, ClassNotFoundException {
        super.get(m.getNIM());
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
