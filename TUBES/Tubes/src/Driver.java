

import Controller.Controller;
import Model.Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Controller();
//    Database db = new Database();
//        int i = 0;
//        try {
//            db.connect();
//            String sql = "SELECT no_enroll FROM enroll ORDER BY no_enroll ASC";
//            db.setRs(db.getStmt().executeQuery(sql));
//            while (db.getRs().next()) {                
//                i = db.getRs().getInt("no_enroll");
//            }
//            db.disconnect();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        System.out.println(i);
    }  
}
