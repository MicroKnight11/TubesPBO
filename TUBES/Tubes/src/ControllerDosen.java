/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

//import View.MainGUIDosen;
//import View.MainGUIhome;

//import Model.Dosen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import model.Database;

/**
 *
 * @author R O G
 */
public class ControllerDosen {
    private MainGUIDosen viewDosen;
    //private View.MainGUIhome viewHome;            
    Database db;
    ModelDosen dosen;  
    private ArrayList<ModelDosen> listDosen = new ArrayList();
    ResultSet rs;
    
    public ControllerDosen(ModelDosen dsn) {
        viewDosen = new MainGUIDosen();
        viewDosen.setVisible(true);
        viewDosen.addActionListener(this);    
        db = new Database();
        this.dosen = dsn;
        getlistData();
        viewDosen.setDataDosen(listDosen);
    } 
    
    public void getlistData(){
        try{
            ResultSet rs = db.getData("select * from dosen");
            listDosen.removeAll(listDosen);
            while(rs.next()){
                ModelDosen dsn = new ModelDosen(rs.getString("NIDN"), rs.getString("FirstName"), rs.getString("LastName"));
                listDosen.add(dsn);          
            }
        }catch(Exception e){
            System.out.println("Error refresh"+e.getMessage());
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source.equals(viewDosen.getBtn_back())) {
                new MainControllerHome();
                viewDosen.dispose();
            } 
            else if (source.equals(viewDosen.getBtnCari())) {
                getlistData();
                try {
                    if (viewDosen.getjTextFieldNID().getText().equals("")){
                        JOptionPane.showMessageDialog(null, "NIDN harus diisi terlebih dahulu");
                    } else {
                        String NID = viewDosen.getjTextFieldNID().getText();
                        String dsn = "SELECT FROM dosen WHERE NIDN ='"+NID+"'";
                        db.getData(dsn);
                        while(rs.next()){
                            ModelDosen dsn1 = new ModelDosen(rs.getString("NIDN"), rs.getString("FirstName"), rs.getString("LastName"));
                            listDosen.add(dsn1);          
                        }
                        viewDosen.setDataDosen(listDosen);
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
}
