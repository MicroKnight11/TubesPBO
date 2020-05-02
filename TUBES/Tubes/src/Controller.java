/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author satria
 */
import GUI.login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controller implements ActionListener{
    private login view;
    
    public Controller() {
        view = new login();
        view.addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnLogin())) {
            if (view.getUser() == "Mahasiswa") {
                new ControllerMahasiswa();
            }
        }
    }    
}
