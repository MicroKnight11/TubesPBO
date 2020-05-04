/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author R O G
 */

public class ModelDosen extends Human{
    private String NID;
        
    public ModelDosen(String NID, String nama) {
        super(nama);
        this.NID = NID;
    }
    
    public String getNID() {
        return NID;
    }
    
    public void setNID(String NID) {
        this.NID = NID;
    }           
 }
