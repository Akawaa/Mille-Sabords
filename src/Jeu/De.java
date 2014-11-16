package Jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

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

    //Nombre de dés restant au joueur
    private int nbrDe;
    private Random random;

    public De(){
        //Attention une fois les images dispo
        //Il faudra les ajouter à la HashMap comme valeur
        nbrDe = 8;
        KEY[0] = "SINGE";
        KEY[1] = "SABRE";
        KEY[2] = "PIECE";
        KEY[3] = "PERROQUET";
        KEY[4] = "DIAMANT";
        KEY[5] = "MORT";
        faces = new HashMap();
        for(int i=0;i<6;i++){
            faces.put(KEY[i],"imageDes");
        }
    }

    public Collection lanceDe() {
        //L'ArrayList 'lance' servira à stocker les clés prises aléatoirement
        //afin d'afficher les dés et pouvoir compter les points
        ArrayList<String> lance = new ArrayList<String>();
        random = new Random();
        for(int i = 0;i<nbrDe;i++){
            //ici on vient tirer aléatoirement les faces parmis KEY
            lance.add(KEY[random.nextInt(6)]);
            //System.out.println(lance.get(i));
        }
        return lance;
    }
}
