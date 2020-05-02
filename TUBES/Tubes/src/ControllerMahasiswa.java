
import GUI.tes;
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
public class ControllerMahasiswa extends MouseAdapter implements ActionListener{
    private tes view;
    
    public ControllerMahasiswa() {
        view = new tes();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
