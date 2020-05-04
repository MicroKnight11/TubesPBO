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
    
public class ModelRuangan extends ModelGedung{
    private String NO_Ruangan;
    private int kapasitas;
        
    public ModelRuangan(String KD_GD, String nama_GD, String NO_Ruangan, int kapasitas) {
        super(KD_GD, nama_GD);
        this.NO_Ruangan = NO_Ruangan;
        this.kapasitas = kapasitas;
    }
        
    public ModelRuangan(ModelGedung m, String NO_Ruangan, int kapasitas) {
        super(m.getKD_GD(),m.getNama_GD());
        this.NO_Ruangan = NO_Ruangan;
        this.kapasitas = kapasitas;
    }

    public String getNO_Ruangan() {
        return NO_Ruangan;
    }

    public void setNO_Ruangan(String NO_Ruangan) {
        this.NO_Ruangan = NO_Ruangan;
    } 
}
