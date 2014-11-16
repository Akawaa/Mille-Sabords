package Jeu;

import javax.swing.*;
import java.util.*;

/**
 * Created by quentin on 16/11/14.
 */
public class De {
    //Le tableau KEY contient les clés pour la HashMap
    //Il est de type final car les clés n'ont pas à changer
    private final String[] KEY = new String[6];

    //HashMap composée de <K,V>
    // avec K = Nom de la face
    // avec V = image du dé
    private HashMap faces;

    private Random random;

    public De(){
        //Attention une fois les images dispo
        //Il faudra les ajouter à la HashMap comme valeur
        //nbrDes = 8;
        KEY[0] = "SINGE";
        KEY[1] = "SABRE";
        KEY[2] = "PIECE";
        KEY[3] = "PERROQUET";
        KEY[4] = "DIAMANT";
        KEY[5] = "MORT";
        faces = new HashMap();
        for(int i=0;i<6;i++){
            faces.put(KEY[i],new ImageIcon());
        }
    }

    public String lanceDe() {
        random = new Random();
        return KEY[random.nextInt(6)];
    }



    //------------------GETTER and SETTER
    public HashMap getFaces(){
        return faces;
    }



}
