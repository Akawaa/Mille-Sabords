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

    //Constructeur de joueur
    public Joueur(String nom){
        this.nom = nom;
        facesTirees = new ArrayList<String>();
        premierLance = true;
        nbrDes = 8;
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
    //---------------------Fin GETTERS and SETTERS-----------
    

    /* Méthode d'enregistrement des scores à la fin du tour pour chaque joueur */

    //METHODE UTILISEE POUR LE TEST
    public void saveScoreTest(PrintStream ps) {
        ps.append("666");
    }

    public void saveScore(int newScore) throws IOException{ //Méthode d'enregistrement de score dans un fichier nommé comme le nom du joueur
        PrintStream ps = new PrintStream("src/Jeu/scores" + System.getProperty("file.separator")+ getNom()+".txt");
        ps.append(newScore+"");
    }

    public int getScore() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Jeu/scores" + System.getProperty("file.separator") +getNom()+".txt"));
        String line;
        line=br.readLine();
        return Integer.parseInt(line);
    }


    ////METHODE UTILISEE POUR LE TEST
    public int getScoreTest(BufferedReader br) throws IOException{ // Même méthode que la précédente mais pour le TEST
        String line;
        int retour = 0;
        line=br.readLine();
        return Integer.parseInt(line);
    }
    /* FIN Méthode d'enregistrement */


}
