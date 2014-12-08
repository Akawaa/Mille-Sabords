package Jeu;

import java.util.ArrayList;
import java.util.Collections;

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
    private int points;

    //Constructeur de joueur
    public Joueur(String nom){
        this.nom = nom;
        facesTirees = new ArrayList<String>();
        premierLance = true;
        nbrDes = 8;
        score = 0; //Initialisation à 0
        points = 0;
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

    public void setFacesTirees(ArrayList<String> facesTirees) {
        this.facesTirees = facesTirees;
    }

    public void compterPointDesIdentiques() {
        int occurences;
        ArrayList<String> listeFacesPossibles = new ArrayList<String>();
        listeFacesPossibles.add("SINGE");
        listeFacesPossibles.add("SABRE");
        listeFacesPossibles.add("PERROQUET");
        listeFacesPossibles.add("PIECE");
        listeFacesPossibles.add("DIAMANT");
        //listeFacesPossibles.add("MORT");
        for(String face:listeFacesPossibles){
            occurences = Collections.frequency(facesTirees, face);
            if(occurences == 3)
                points += 100;
            if(occurences == 4)
                points +=200;
            if(occurences == 5)
                points +=500;
            if(occurences == 6)
                points +=1000;
            if(occurences == 7)
                points +=2000;
            if(occurences == 8)
                points +=4000;
        }

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
