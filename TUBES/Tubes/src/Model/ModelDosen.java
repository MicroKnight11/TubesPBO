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
    private String KK;
    private String NID;
        
    public ModelDosen(String NID, String KK, String nama, String tanggalLahir) {
        super(nama, tanggalLahir);
        this.KK = KK;
        this.NID = NID;
    }
    
    public String getKK() {
        return KK;
    }
    
    public void setKK(String KK) {
        this.KK = KK;
    }
    
    public String getNID() {
        return NID;
    }
    
    public void setNID(String NID) {
        this.NID = NID;
    }           
 }
