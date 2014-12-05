package Jeu;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Berenice on 14/11/14.
 */
public class TestUnitJoueur {
    //Le principe de ce test est de vérifié que c'est le premier lancé du joueurr
    //Mais aussi de vérifier que le que lancerLesDes() renvoie bien une arraylistee
    @Test
    public void testPremierLanceDe() throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        Joueur joueur = new Joueur("Titi");
        Assert.assertTrue(joueur.isPremierLance());
        ArrayList<String> faces;
        faces = joueur.lancerLesDes();
        Assert.assertEquals(faces.size(),8);
    }

    //Ce test permet de vérfier que la décrémentation du nombre de dès d'un joueur s'effectue correctement
    //En effet si le joueur à "MORT" parmis la liste de faces qu'il génère son nombre de dès devra diminuer en conséquence
    //Ici 3 "MORT" dans l'ArrayList<String> donc le nombre de dès du joueur après vérif doit être de 5.
    @Test
    public void testTeteDeMortDe() throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        Joueur joueur = new Joueur("Titi");
        ArrayList<String> faces = new ArrayList<String>();
        faces.add("MORT");
        faces.add("MORT");
        faces.add("MORT");
        faces.add("DIAMANT");
        faces.add("PERROQUET");
        faces.add("SINGE");
        faces.add("PIECE");
        faces.add("PIECE");
        Assert.assertEquals(joueur.getNbrDes(), 8);
        joueur.teteDeMortDe(faces);
        Assert.assertEquals(joueur.getNbrDes(), 5);
    }

    @Test
    public void testCompterPointDesIdentiques(){
        Joueur joueur = new Joueur("Titi");
        ArrayList<String> listeFaces = new ArrayList<String>();
        for(int i=0;i<8;i++){
            listeFaces.add("DIAMANT");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(4000,joueur.getPoints());

        listeFaces.clear();
        joueur.setPoints(0);
        for(int i=0;i<4;i++){
            listeFaces.add("SINGE");
        }
        for(int i=0;i<4;i++){
            listeFaces.add("PIECE");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(400,joueur.getPoints());

        listeFaces.clear();
        joueur.setPoints(0);
        for(int i=0;i<8;i++){
            listeFaces.add("MORT");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(0,joueur.getPoints());
    }
}

