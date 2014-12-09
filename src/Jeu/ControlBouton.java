package Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Berenice on 14/11/14.
 */
public class ControlBouton implements ActionListener {
    private Model model;
    private View view;
    protected Partie game = null;

    public ControlBouton(Model model, View view) {
        this.model = model;
        this.view = view;

        view.setValiderNbJoueurListener(this);
    }

    public void actionPerformed(final ActionEvent e) {
        if(e.getSource() == view.jbContentDeck) {
            model.tirerUneCarte();
            view.afficherCarte(model.getCartePiochee());
            view.desacDeck();
            //view.initBoutonLancerDe();
        }
        if(e.getSource() == view.jbValiderNbJoueur) {
            model.setNbJoueur( Integer.parseInt((String) view.getNombreJoueur().getSelectedItem()));
            view.removeAllElements();
            view.nommerJoueur(model.getNbJoueur());
            view.setValiderNomJoueurListener(this);
        }
        if(e.getSource() == view.validerNomJoueur) {
            String[] nomDesJoueurs = new String[view.nomJoueur.length];
            for(int i=0;i<nomDesJoueurs.length;i++) {
                nomDesJoueurs[i] = view.nomJoueur[i].getText();
            }
            try {
                game = new Partie(model.getNbJoueur(), nomDesJoueurs, view, model, this);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            model.setPartie(game);
            view.setControlDeck(this);
        }

        if (e.getSource() == view.jbPasserTour){
            System.out.print("clic");
            view.activDeck();
            //ControlBouton cb = new ControlBouton(model, view);
            view.removeAllElements();
            game.setFinTour(true);
            game.setIteratorJoueur(game.getIteratorJoueur() + 1); //passe au joueur suivant
            if (game.getIteratorJoueur() >= game.getNbJoueur()) {
                game.setIteratorJoueur(0);
            }
            game.newTour(game.getIteratorJoueur(), this, game.getNbJoueur()); //lance un nouveau tour
            view.setBoutonPasserTour(this);
        }
    }

    public void actionBoutonPasserTour() {
        view.setBoutonPasserTour(this);
    }
}
