package DAO;


import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public abstract class  DAO {
    protected Database DB;
    protected String table;
    protected List<String> column = new ArrayList();
    protected String sql;


    public DAO(Database DB, String table) {
        this.DB = DB;
        this.table = table;
    }
    
    public void getColumn() throws SQLException, ClassNotFoundException{
        DB.connect();
        sql =   "SELECT column_name\n" +
                "FROM USER_TAB_COLUMNS\n" +
                "WHERE TABLE_NAME = UPPER('"+ table +"')";
        DB.setRs(DB.getStmt().executeQuery(sql));
        while (DB.getRs().next()) {                
            column.add(DB.getRs().getString("column_name"));
        }
        DB.disconnect();
    }
    
    public void getAll() throws SQLException, ClassNotFoundException {
        DB.connect();
        sql =   "SELECT *\n" +
                "FROM "+ table;
        DB.setRs(DB.getStmt().executeQuery(sql));
        while (DB.getRs().next()) {         
            for (int i = 0; i < column.size(); i++) {
                System.out.println(DB.getRs().getString(column.get(i)));
            }
        }
        DB.disconnect();
    }
    
    public void deleteAll() throws SQLException, ClassNotFoundException{
        DB.connect();
        sql = "DELETE FROM " + table;
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Delete success");
        DB.disconnect();
    }
    
    public void delete(String key) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "DELETE FROM " + table + " WHERE " + column.get(0) + " = '" + key + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        System.out.println("Delete success");
        DB.disconnect();
    }
    
    public void get(String key) throws SQLException, ClassNotFoundException {
        DB.connect();
        sql = "SELECT * FROM " + table + " WHERE " + column.get(0) + " = '" + key + "'";
        DB.setRs(DB.getStmt().executeQuery(sql));
        while (DB.getRs().next()) {                
            for (int i = 0; i < column.size(); i++) {
                System.out.println(DB.getRs().getString(column.get(i)));
            }
        }
        DB.disconnect();
    }
}
