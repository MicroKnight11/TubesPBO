/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author R O G
 */
public class ModelGedung {
    private String KD_GD;
    private String nama_GD;

    public ModelGedung(String KD_GD, String nama_GD) {
        this.KD_GD = KD_GD;
        this.nama_GD = nama_GD;
    }
    
    public ModelGedung(){
        
    }

    public String getKD_GD() {
        return KD_GD;
    }

    public void setKD_GD(String KD_GD) {
        this.KD_GD = KD_GD;
    }

    public String getNama_GD() {
        return nama_GD;
    }

    public void setNama_GD(String nama_GD) {
        this.nama_GD = nama_GD;
    }    
}
