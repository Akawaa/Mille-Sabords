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
    public void testCreerListFaces(){
        De de = new De();
        Assert.assertEquals(8, de.creerListFaces(8).size());
    }

    //@Test

}
