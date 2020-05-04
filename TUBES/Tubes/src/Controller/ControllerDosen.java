package Controller;


import Model.Database;
import Model.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tubes.MainGUIDosen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public class ControllerDosen implements ActionListener{
    private MainGUIDosen viewDosen;           
    Database db;
    private ModelDosen dosen;  
    //private ArrayList<ModelDosen> listDosen = new ArrayList();
    
    public ControllerDosen(Database db) {
        viewDosen = new MainGUIDosen();
        viewDosen.setVisible(true);
        viewDosen.addActionListener(this);    
        this.db = db;
       // this.dosen = dsn;
        //getlistData();
        //viewDosen.setDataDosen(listDosen);
    } 
    
//    public void getlistData(){
//        try{
//            db.connect();
//            String sql = "select * from dosen";
//            db.setRs(db.getStmt().executeQuery(sql));
//            listDosen.removeAll(listDosen);
//            while(db.getRs().next()){
//                ModelDosen dsn = new ModelDosen(db.getRs().getString("NIDN"), db.getRs().getString("FirstName"), db.getRs().getString("LastName"));
//                listDosen.add(dsn);          
//            }
//            db.disconnect();
//        }catch(Exception e){
//            System.out.println("Error refresh"+e.getMessage());
//        }
//    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source.equals(viewDosen.getBtn_back())) {
                new Controller();
                viewDosen.dispose();
            } 
            else if (source.equals(viewDosen.getBtnCari())) {
//                getlistData();
                try {
                    if (viewDosen.getjTextFieldNID().getText().equals("")){
                        JOptionPane.showMessageDialog(null, "NIDN harus diisi terlebih dahulu");
                    } else {
//                        db.connect();
                        String NID = viewDosen.getjTextFieldNID().getText();
                        viewDosen.resetTable();
                        liatJadwal(NID, db);
//                        String sql = "SELECT * FROM mata_kuliah NATURAL JOIN jadwal WHERE NID ='"+NID+"'";
//                        db.setRs(db.getStmt().executeQuery(sql));
//                        while(db.getRs().next()){
//                            ModelDosen dsn1 = new ModelDosen(rs.getString("NIDN"), rs.getString("FirstName"), rs.getString("LastName"));
//                            listDosen.add(dsn1);          
//                        }
//                        db.disconnect();
//                        viewDosen.setDataDosen(listDosen);
                    }
                } catch (Exception es) {
                    System.out.println("Error 404 "+ es.getMessage());
                    JOptionPane.showMessageDialog(null, "Data Dosen Tidak DItemukan");
                }
            }
        } catch (Exception ef) {
            JOptionPane.showMessageDialog(null, "Data Dosen Tidak DItemukan");
        }
    }
    
    public void liatJadwal(String NID, Database db) {
       try{
            int j = 0;
            db.connect();
            String sql = "SELECT * FROM mata_kuliah NATURAL JOIN jadwal NATURAL JOIN enroll WHERE NID = '" + NID +"'";
            db.setRs(db.getStmt().executeQuery(sql));
            while(db.getRs().next()){
                viewDosen.setTabel(
                        db.getRs().getString("id_jadwal"),
                        db.getRs().getString("no_ruangan"),
                        db.getRs().getString("waktu"),
                        db.getRs().getString("nim"), 
                        j);
                j++;
            }
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }           
    }
}
