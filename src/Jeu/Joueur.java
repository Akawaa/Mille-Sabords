package Jeu;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by quentin on 28/11/14.
 */
public class Joueur {
    /*On définit ici un joueur par les paramètres suivants:
    * -facesTirees
    * -premierLance ==> booléen qui précise si c'est le premier lancé du joueur
    * -nbrDes ==> nombre de dès du joueur
    * -*/

    protected String nom;
    private ArrayList<String> facesTirees;
    private boolean premierLance;
    private int nbrDes;
    private int score;

    //Constructeur de joueur
    public Joueur(String nom){
        this.nom = nom;
        facesTirees = new ArrayList<String>();
        premierLance = true;
        nbrDes = 8;
        score = 0; //Initialisation à 0
    }

    //Méthode qui créée un dé, lance le dé en fonction du nombre de nom
    //et retourne la ArrayList avec le nom des faces tirées
    public ArrayList<String> lancerLesDes() throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        De de = new De();
        if(isPremierLance()){
            return de.creerListFaces(8);
        }
        return de.creerListFaces(nbrDes);
    }

    public void teteDeMortDe(ArrayList<String> listFaces) {
        for(int i=0;i<listFaces.size();i++){
            if(listFaces.get(i)=="MORT"){
                nbrDes--;
            }
        }
    }


    //-----------------GETTERS and SETTERS-----------------
    public boolean isPremierLance() {
        return premierLance;
    }

    public ArrayList<String> getFacesTirees() {
        return facesTirees;
    }

    public int getNbrDes() {
        return nbrDes;
    }

    public String getNom() { return nom;}

    public void setScore(int newScore) {
        this.score = newScore;
    }
    public int getScore() { return score;}
    //---------------------Fin GETTERS and SETTERS-----------
}
