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
    private boolean teteDeMort;
    private int nbrDes;
    private int points;
    private boolean Alui = false;

    //Constructeur de joueur
    public Joueur(String nom){
        this.nom = nom;
        facesTirees = new ArrayList<String>();
        premierLance = true;
        teteDeMort = false;
        nbrDes = 8;
        points = 0;
    }

    //Méthode qui créée un dé, lance le dé en fonction du nombre de nom

    public void lancerLesDes() throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        De de = new De();
        teteDeMort = false;
        facesTirees = de.creerListFaces(nbrDes);
    }

    public void teteDeMortDe() {
        for(int i=0;i<facesTirees.size();i++){
            if(facesTirees.get(i)=="MORT"){
                nbrDes--;
                teteDeMort = true;
            }
        }
    }


    //-----------------GETTERS and SETTERS-----------------
    public boolean isPremierLance() {
        return premierLance;
    }

    public boolean isTeteDeMort() {
        return teteDeMort;
    }

    public ArrayList<String> getFacesTirees() {
        return facesTirees;
    }

    public int getNbrDes() {
        return nbrDes;
    }

    public void setNbrDes(int nbrDes) { this.nbrDes = nbrDes; }

    public String getNom() { return nom;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setFacesTirees(ArrayList<String> facesTirees) {
        this.facesTirees = facesTirees;
    }

    public void setAlui(boolean newAlui) {
        this.Alui = newAlui;
    }

    public boolean getAlui() {
        return Alui;
    }
    //---------------------Fin GETTERS and SETTERS-----------

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
        occurences = Collections.frequency((facesTirees), "MORT");
        if(occurences == 3){
            points = 0;
        }
    }

    public void compterPointDiamantPiece() {
        for(String face:facesTirees){
           if(face == "DIAMANT" || face == "PIECE"){
               points += 100;
           }
        }
    }

    public void enleverPoints(int points) throws EnleverPointJamaisNegatif {
        if(points <0){
            throw new EnleverPointJamaisNegatif();
        }
        this.points -= points;
    }

    public void ajouterPoints(int points) throws AjouterPointJamaisNegatif {
        if(points <0){
            throw new AjouterPointJamaisNegatif();
        }
        this.points += points;
    }

    public void remiseA0Des() {
        nbrDes = 8;
    }
}
