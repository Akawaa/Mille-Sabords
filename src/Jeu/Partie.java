package Jeu;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by aurelien on 01/12/14.
 */
public class Partie {

    View view;
    Model model;
    Joueur[] joueurs;
    boolean finPartie = false;
    boolean finTour = false;
    int iteratorJoueur = 0;
    private int nbJoueur;

    public Partie(int nbJoueur, String[] nomJoueur, View view, Model model) throws InterruptedException, IOException {
        setNbJoueur(nbJoueur);
        System.out.print("nb joueur : " + getNbJoueur());
        this.view = view;
        this.model = model;

        int i =0;
        joueurs = new Joueur[nbJoueur];

        for (i = 0; i < nbJoueur; i++) {
            joueurs[i] = new Joueur(nomJoueur[i]);
        }

        view.removeAllElements();
        view.afficherRegle();

        /*Initialisation du premier tour*/
        newTour(iteratorJoueur, nbJoueur);
    }

    public Partie(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }

    public void newTour(int iteratorJoueur, int nbJoueur) {
        try{
            view.initJeu(joueurs[getIteratorJoueur()]);
        }
        catch(IOException ex){
            System.out.println (ex.toString());
        }
        try {
            joueurs[getIteratorJoueur()].lancerLesDes();
        } catch (ListFacesInferieurA1Exception e) {
            e.printStackTrace();
        } catch (ListFacesSuperieurA8Exception e) {
            e.printStackTrace();
        }
        joueurs[getIteratorJoueur()].compterPointDesIdentiques();
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

    public Joueur getJoueur(int i) {
        return joueurs[i];
    }


    public void compterPoint4TeteDeMort(Joueur joueur) {
        if(joueur.isTeteDeMort()){
            int occurrencesMort = Collections.frequency(joueur.getFacesTirees(),"MORT");
            System.out.println(occurrencesMort);
            if(occurrencesMort >= 4){
                for(int i=0;i<nbJoueur;i++)
                    try {
                        joueurs[i].enleverPoints(occurrencesMort * 100);
                    } catch (EnleverPointJamaisNegatif enleverPointJamaisNegatif) {
                        enleverPointJamaisNegatif.printStackTrace();
                    }
            }
        }
    }

    public void compterPointCartePieceDiamant(Joueur joueur) {
        if(model.getCartePiochee() instanceof CarteDiamant)
            try {
                joueur.ajouterPoints(100);
            } catch (AjouterPointJamaisNegatif ajouterPointJamaisNegatif) {
                ajouterPointJamaisNegatif.printStackTrace();
            }
    }

    public void compterPointCartePirate(Joueur joueur) {
        if(model.getCartePiochee() instanceof CartePirate)
            joueur.setPoints(joueur.getPoints()*2);
    }

    public void compterPointCarteBateauPirate(Joueur joueur) {
        if(model.getCartePiochee() instanceof CarteBateauPirate) {
            int nbrSabreCarte = ((CarteBateauPirate)model.getCartePiochee()).getNbrSabre();
            int occurrencesSabre = Collections.frequency(joueur.getFacesTirees(), "SABRE");
            if(occurrencesSabre != nbrSabreCarte){
                if(nbrSabreCarte == 2){
                    try {
                        joueur.enleverPoints(300);
                    } catch (EnleverPointJamaisNegatif enleverPointJamaisNegatif) {
                        enleverPointJamaisNegatif.printStackTrace();
                    }
                }
                if(nbrSabreCarte == 3){
                    try {
                        joueur.enleverPoints(500);
                    } catch (EnleverPointJamaisNegatif enleverPointJamaisNegatif) {
                        enleverPointJamaisNegatif.printStackTrace();
                    }
                }
                if(nbrSabreCarte == 4){
                    try {
                        joueur.enleverPoints(1000);
                    } catch (EnleverPointJamaisNegatif enleverPointJamaisNegatif) {
                        enleverPointJamaisNegatif.printStackTrace();
                    }
                }
            }

        }
    }

    public void setAluiJoueur(boolean b, Joueur joueur) {
        joueur.setAlui(b);
    }
}
