package Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Berenice on 14/11/14.
 */
public class ControlBouton implements ActionListener {
    private Model model;
    private View view;

    public ControlBouton(Model model, View view) {
        this.model = model;
        this.view = view;

        view.setControlDeck(this);
    }

    public void actionPerformed(final ActionEvent e) {
        if(e.getSource() == view.jbContentDeck) {
            Carte cartePiocher = new Carte(model.tirerUneCarte());
            view.afficherCarte(cartePiocher);
        }
    }
}
