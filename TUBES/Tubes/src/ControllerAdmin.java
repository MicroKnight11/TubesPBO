
import GUI.tes;
import Model.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satria
 */
public class ControllerAdmin extends MouseAdapter implements ActionListener {
    private GUIAdmin view;
    
    public ControllerAdmin(Database db){
        view = new GUIAdmin(db);
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
