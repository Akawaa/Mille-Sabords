package Jeu;

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

    String nom;
    ArrayList<String> facesTirees;
    boolean premierLance;
    int nbrDes;

    //Constructeur de joueur
    public Joueur(String nom){
        nom = this.nom;
        facesTirees = new ArrayList<String>();
        premierLance = true;
        nbrDes = 8;
    }

    //Méthode qui créée un dé, lance le dé en fonction du nombre de nom
    //et retourne la ArrayList avec le nom des faces tirées
    public ArrayList<String> lancerLesDes(int nbrDes) throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        De de = new De();
        if(isPremierLance()){
            return de.creerListFaces(8);
        }
        return de.creerListFaces(nbrDes);
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

}
