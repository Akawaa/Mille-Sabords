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
    private static HashMap faces;

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
        faces.put(KEY[0],new ImageIcon(this.getClass().getResource("./img/singe.png")));
        faces.put(KEY[1],new ImageIcon(this.getClass().getResource("./img/sabre.png")));
        faces.put(KEY[2],new ImageIcon(this.getClass().getResource("./img/piece.png")));
        faces.put(KEY[3],new ImageIcon(this.getClass().getResource("./img/perroquet.png")));
        faces.put(KEY[4],new ImageIcon(this.getClass().getResource("./img/diamant.png")));
        faces.put(KEY[5],new ImageIcon(this.getClass().getResource("./img/mort.png")));
    }

    public String lanceDe() {
        random = new Random();
        return KEY[random.nextInt(6)];
    }

    public ArrayList<String> creerListFaces(int nbrDes) throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        if(nbrDes < 1){
            throw new ListFacesInferieurA1Exception();
        }
        if(nbrDes > 8){
            throw new ListFacesSuperieurA8Exception();
        }

        ArrayList<String> listFaces = new ArrayList<String>();
        for(int i=0;i<nbrDes;i++){
            listFaces.add(lanceDe());
        }
        return listFaces;
    }


    //------------------GETTERS and SETTERS
    public HashMap getFaces(){
        return faces;
    }

    public static ImageIcon getImageIcon(String key){
        return (ImageIcon) faces.get(key);
    }


    /*public ImageIcon getImageIcon(String face){
        return (ImageIcon) faces.get(face);
    }*/
}
