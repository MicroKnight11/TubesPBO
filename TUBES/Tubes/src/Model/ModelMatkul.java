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
    
public class ModelMatkul {
    private String KD_MK;
    private String nama_MK;
    private String SKS;
    private ModelDosen Dsn;
        
    public ModelMatkul(String KD_MK, String nama_MK, String SKS) {
        this.KD_MK = KD_MK;
        this.nama_MK = nama_MK;
        this.SKS = SKS;
    }
        
    public ModelMatkul(String KD_MK, String nama_MK, String SKS, String nid, Database db) {
        this.KD_MK = KD_MK;
        this.nama_MK = nama_MK;
        this.SKS = SKS;
        try {
            db.connect();
            String sql = "SELECT * FROM dosen where nid = '"+nid+"'";
            db.setRs(db.getStmt().executeQuery(sql));
            ModelDosen m;
            while (db.getRs().next()) {
                m = new ModelDosen(
                    db.getRs().getString("nid"),
                    db.getRs().getString("nama_dosen")
                );
            Dsn = m;
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }            
    }
        
    public String getKD_MK() {
        return KD_MK;
    }

    public void setKD_MK(String KD_MK) {
        this.KD_MK = KD_MK;
    }

    public String getNama_MK() {
        return nama_MK;
    }

    public void setNama_MK(String nama_MK) {
        this.nama_MK = nama_MK;
    }

    public String getSKS() {
        return SKS;
    }

    public void setSKS(String SKS) {
        this.SKS = SKS;
    }

    public ModelDosen getDsn() {
        return Dsn;
    }

    public void setDsn(ModelDosen Dsn) {
        this.Dsn = Dsn;
    }
}
