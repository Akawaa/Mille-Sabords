package Jeu;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by quentin on 16/11/14.
 */
public class TestUnitDe {

    //Le test consisite à voir si il existe bien un valeur associée à la clé choisie
    //aléatoirement avec la méthode lanceDe()
    @Test
    public void testLanceDe(){
        De de = new De();
        Assert.assertTrue(de.getFaces().containsKey(de.lanceDe()));
    }

    //Test de génération de 8 lancer avec le dé
    //La méthode creerListFaces réutilise lanceDe() testée précédement
    @Test
    public void testCreerListFaces() throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        De de = new De();
        Assert.assertEquals(8, de.creerListFaces(8).size());
    }

    //Test permettant de savoir si le nombre de dès lancés est < 1
    //La méthode creerListFaces renvoie une exception si oui
    //Grosso merdo le mec qui fait ca est un kamikaze ^__^
    @Test(expected = ListFacesInferieurA1Exception.class)
    public void testCreerListFacesJamaisInferieurA1() throws ListFacesInferieurA1Exception, ListFacesSuperieurA8Exception {
        De de = new De();
        de.creerListFaces(0);
    }

    //Test permettant de savoir si le nombre de dès lancés est > 8
    //La méthode creerListFaces renvoie une exception si oui
    //Grosso merdo le mec qui fait ca est un tricheur ^__^ Héhé oui petit malin :P
    @Test(expected = ListFacesSuperieurA8Exception.class)
    public void testCreerListFacesJamaisSuperieurA8() throws ListFacesSuperieurA8Exception, ListFacesInferieurA1Exception {
        De de = new De();
        de.creerListFaces(9);
    }

}
