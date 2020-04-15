package tubes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private String server = "jdbc:mysql://TubesPBOsql";//nama database
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;
    private ResultSet rs = null;
    
    public Database() { 
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        connect();
    }
    public void connect() { 
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat koneksi");
        }
    }
    
    public ResultSet getData(String str) { 
        try{
            rs = statement.executeQuery(str);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return rs;
    }
    
    public void query(String str) { 
        try{
            statement.executeUpdate(str);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
   
}
