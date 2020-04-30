/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import Controller.Controller;

import java.util.ArrayList;

/**
 *
 * @author R O G
 */
public class ModelAdmin {   
    private int id;
    private ArrayList<ModelMatkul> Mk;

    public ModelAdmin() {
        this.Mk = new ArrayList<>();
    }
   
    public void addMatkul(ModelMatkul e){
        this.Mk.add(e);
    }
    
    public void delMatkul(ModelMatkul MK){
        this.Mk.remove(MK);
    }
}
