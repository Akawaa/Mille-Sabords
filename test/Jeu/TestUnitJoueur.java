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
        joueur.lancerLesDes();
        Assert.assertEquals(joueur.getFacesTirees().size(),8);
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
        Assert.assertFalse(joueur.isTeteDeMort());
        Assert.assertEquals(joueur.getNbrDes(), 8);
        joueur.setFacesTirees(faces);
        joueur.teteDeMortDe();
        Assert.assertEquals(joueur.getNbrDes(), 5);
        Assert.assertTrue(joueur.isTeteDeMort());
    }

    @Test(expected = EnleverPointJamaisNegatif.class)
    public void testEnleverPoint() throws EnleverPointJamaisNegatif {
        Joueur joueur = new Joueur("Coco");
        joueur.setPoints(2000);
        Assert.assertEquals(2000,joueur.getPoints());
        joueur.enleverPoints(500);
        Assert.assertEquals(1500,joueur.getPoints());

        joueur.enleverPoints(-500);
    }

    @Test(expected = AjouterPointJamaisNegatif.class)
    public void testAjouterPointJamaisNegatif() throws AjouterPointJamaisNegatif {
        Joueur joueur = new Joueur("Coco");
        joueur.setPoints(2000);
        Assert.assertEquals(2000,joueur.getPoints());
        joueur.ajouterPoints(500);
        Assert.assertEquals(2500,joueur.getPoints());

        joueur.ajouterPoints(-500);

    }

    @Test
    public void testCompterPointDesIdentiques(){
        Joueur joueur = new Joueur("Titi");
        ArrayList<String> listeFaces = new ArrayList<String>();

        //Test nbr de dès identiques = 8
        for(int i=0;i<8;i++){
            listeFaces.add("PERROQUET");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(4000,joueur.getPoints());

        //Test nbr de dès identiques = 4
        listeFaces.clear();
        joueur.setPoints(0);
        for(int i=0;i<4;i++){
            listeFaces.add("SINGE");
        }
        for(int i=0;i<4;i++){
            listeFaces.add("SABRE");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(400,joueur.getPoints());

        //Test nbr de dès identiques = 5
        listeFaces.clear();
        joueur.setPoints(0);
        for(int i=0;i<5;i++){
            listeFaces.add("SINGE");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(500,joueur.getPoints());

        //Test nbr de dès identiques = 6
        listeFaces.clear();
        joueur.setPoints(0);
        for(int i=0;i<6;i++){
            listeFaces.add("SINGE");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(1000,joueur.getPoints());

        //Test nbr de dès identiques = 7
        listeFaces.clear();
        joueur.setPoints(0);
        for(int i=0;i<7;i++){
            listeFaces.add("SINGE");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(2000,joueur.getPoints());

        //Test mise à jour des points si 3 tetes de mort.
        listeFaces.clear();
        joueur.setPoints(100);
        for(int i=0;i<3;i++){
            listeFaces.add("MORT");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDesIdentiques();
        Assert.assertEquals(0,joueur.getPoints());
    }

    @Test
    public void testCompterPointDiamantPiece(){
        Joueur joueur = new Joueur("Titi");
        ArrayList<String> listeFaces = new ArrayList<String>();
        for(int i=0;i<2;i++){
            listeFaces.add("DIAMANT");
        }
        for(int i=0;i<2;i++){
            listeFaces.add("PIECE");
        }
        for(int i=0;i<4;i++){
            listeFaces.add("SINGE");
        }
        joueur.setFacesTirees(listeFaces);
        joueur.compterPointDiamantPiece();
        Assert.assertEquals(400,joueur.getPoints());
    }

    @Test
    public void testRemiseA0Des(){
        Joueur joueur = new Joueur("Titi");
        ArrayList<String> listeFaces = new ArrayList<String>();
        for(int i=0;i<6;i++){
            listeFaces.add("DIAMANT");
        }
        for(int i=0;i<2;i++){
            listeFaces.add("MORT");
        }
        joueur.setFacesTirees(listeFaces);
        Assert.assertEquals(8,joueur.getNbrDes());
        joueur.teteDeMortDe();
        Assert.assertEquals(6,joueur.getNbrDes());
        joueur.remiseA0Des();
        Assert.assertEquals(8,joueur.getNbrDes());
    }

}

