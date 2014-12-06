package Jeu;

import java.io.IOException;
import java.io.*;

/**
 * Created by aurelien on 01/12/14.
 */
public class Partie {

    View view;
    Joueur[] joueurs;
    boolean finPartie = false;
    boolean finTour = false;
    int iteratorJoueur = 0;
    public int getIteratorJoueur;
    private int nbJoueur;

    public Partie(int nbJoueur, String[] nomJoueur, View view, ControlBouton cb) throws InterruptedException, IOException {
        setNbJoueur(nbJoueur);
        System.out.print("nb joueur : " + getNbJoueur());
        this.view = view;
        // Intérieur de la partie à faire
        // --> Créer les joueurs
        // --> Organiser les tours ...
        // Pour le moment : load la vue
        int i =0;
        joueurs = new Joueur[nbJoueur];

        for (i = 0; i < nbJoueur; i++) {
            joueurs[i] = new Joueur(nomJoueur[i]);
        }

        view.removeAllElements();
        view.afficherRegle();

        /*Initialisation du premier tour*/
        newTour(iteratorJoueur, cb, nbJoueur);

    }

    public void newTour(int iteratorJoueur, ControlBouton cb, int nbJoueur) {
        try{
            view.initJeu(joueurs[getIteratorJoueur()], cb);
        }
        catch(IOException ex){
            System.out.println (ex.toString());
        }
    }

    /********GETTERS AND SETTERS******/
    public void setFinPartie(boolean finPartie) {
        this.finPartie = finPartie;
    }
    public void setFinTour(boolean finTour) {
        this.finTour = finTour;
    }

    public void setIteratorJoueur(int newIterator) {
        this.iteratorJoueur = newIterator;
    }

    public int getIteratorJoueur() {
        return iteratorJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }


}
