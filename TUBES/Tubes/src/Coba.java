
import DAO.*;
import Database.Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public class Coba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database d = new Database();
        DAOMahasiswa a = new DAOMahasiswa(d);
        try {
            a.getAll();
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
