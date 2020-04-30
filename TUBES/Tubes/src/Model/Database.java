package Model;

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

    public static void setRs(ResultSet rs) {
        Database.rs = rs;
    }

}
