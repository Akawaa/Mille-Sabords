package Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Berenice on 14/11/14.
 */
public class ControlMenu implements ActionListener {
    private Model model;
    private View view;
    private Partie partie;

    public ControlMenu(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setListenerMenu(this);
    }
    //Action sur le bouton quitter
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == view.exit) {
            System.exit(0);
        }
        if (event.getSource() == view.start) {
            /*
            * créer un nouveau modele
            * faire vue.dispose()
            * controlGroup(model) */
            Model model1 = new Model();
            view.dispose();
            try {
                ControlGroup controlGroup = new ControlGroup(model1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        //Action sur le bouton help
        if (event.getSource() == view.help){
            view.Documentationview();
        }

        //Enregistrer la partie (test)
        if (event.getSource() == view.enregistrerPartie) {
            System.out.print("kaka");
        }
    }
}
