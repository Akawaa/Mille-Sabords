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
    private ControlMenu controlMenu = null;

    public ControlBouton(Model model, View view, ControlMenu controlMenu) {
        this.model = model;
        this.view = view;
        this.controlMenu = controlMenu;

        view.setValiderNbJoueurListener(this);
    }

    public void actionPerformed(final ActionEvent e) {
        if(e.getSource() == view.jbContentDeck) {
            model.tirerUneCarte();
            view.afficherCarte(model.getCartePiochee());
            view.desacDeck();
            view.initBoutonLancerDe();
            view.setBoutonLancerDe(this);
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
                game = new Partie(model.getNbJoueur(), nomDesJoueurs, view, model);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            model.setPartie(game);
            view.setControlDeck(this);
            view.desacBoutonPasserTour();
            view.setListenerMenuPartieLancee(controlMenu);
        }

        if (e.getSource() == view.jbPasserTour){
            view.supprimerTouteTeteMort();
            view.removeAllElements();
            game.setFinTour(true);
            game.setAluiJoueur(false, game.joueurs[game.getIteratorJoueur()]); //passe l'état de la variable boolean du joueur qui vient de terminer son tour à "false"
            game.setIteratorJoueur(game.getIteratorJoueur()+1); //Incrémente l'itérateur du tableau qui séléctionne le joeuur qui joue

            game.setIteratorJoueur(game.getIteratorJoueur()); //passe au joueur suivant
            if (game.getIteratorJoueur() >= game.getNbJoueur()) {
                game.setIteratorJoueur(0);
            }
            game.compterPointTotal(game.getJoueur(game.getIteratorJoueur())); //On compte les points
            game.setAluiJoueur(true, game.joueurs[game.getIteratorJoueur()]); //passe l'état de la variable boolean du joueur qui commence son tour à "true"
            game.newTour(game.getIteratorJoueur(), game.getNbJoueur()); //lance un nouveau tour
            view.setBoutonPasserTour(this);
            view.setControlDeck(this);
            view.desacBoutonPasserTour();
        }

        if(e.getSource() == view.jbLancerDe) {
            if(view.getJbTableFaceTirer() != null) {
                view.supprimerLesDe();
            }

            view.setBoutonPasserTour(this);
            view.activBoutonPasserTour();

            // Affectation au joueur en cours un nombre de face de dé (Pour le moment 8 de base)
            try {
                game.getJoueur(game.getIteratorJoueur()).lancerLesDes();
                game.compterPointTotal(game.getJoueur(game.getIteratorJoueur()));
            } catch(ListFacesInferieurA1Exception l) {
                System.out.println(l.getMessage());
            } catch(ListFacesSuperieurA8Exception m) {
                System.out.println(m.getMessage());
            }
            for(int a=0;a<game.getJoueur(game.getIteratorJoueur()).getFacesTirees().size();a++) {
                System.out.println(game.getJoueur(game.getIteratorJoueur()).getFacesTirees().get(a));
            }
            System.out.println("\n");

            // Affichage des faces tiré par le joueur
            view.afficherFaceDe(view.supprimerTeteMort(game.getJoueur(game.getIteratorJoueur()).getFacesTirees()));
            view.initAffichageTeteMort();
            view.afficherTeteMort();

            // Activation des listener du dé
            view.activFaceDe();
        }
    }
}
