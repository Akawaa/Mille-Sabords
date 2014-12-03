package Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == view.exit) {
            model.supprimerCarteRepertoireScore();
            System.exit(0);
        }
        if (event.getSource() == view.start) {
            /*
            * créer un nouveau modele
            * faire vue.dispose()
            * controlGroup(model)*/
            Model model1 = new Model();
            view.dispose();
            try {
                ControlGroup controlGroup = new ControlGroup(model1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
