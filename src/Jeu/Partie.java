package Jeu;

import java.io.IOException;

/**
 * Created by aurelien on 01/12/14.
 */
public class Partie {

    View view;
    Joueur[] joueurs;

    public Partie(int nbJoueur, String[] nomJoueur, View view) {
        this.view = view;
        // Intérieur de la partie à faire
        // --> Créer les joueurs
        // --> Organiser les tours ...
        // Pour le moment : load la vue

        view.removeAllElements();
        view.afficherRegle();

        try{
            view.initPartie();
        }
        catch(IOException ex){
            System.out.println (ex.toString());
        }
    }
}
