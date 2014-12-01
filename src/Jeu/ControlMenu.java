package Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Berenice on 14/11/14.
 */
public class ControlMenu implements ActionListener {
    private Model model;
    private View view;

    public ControlMenu(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setListenerMenu(this);
    }
    //Action sur le bouton quitter
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.exit) {
            System.exit(0);
        }
    }
}
