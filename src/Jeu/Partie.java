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

    public Partie(int nbJoueur, String[] nomJoueur, View view) throws InterruptedException {
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

        int j = 0;
        try{
            view.initPartie(joueurs[j]);
        }
        catch(IOException ex){
            System.out.println (ex.toString());
        }

        /*while(!finPartie) {
            while (!finTour){
                Thread.sleep(1);
            }
        }*/
    }

    /********GETTERS AND SETTERS******/
    public void setFinPartie(boolean finPartie) {
        this.finPartie = finPartie;
    }
}
