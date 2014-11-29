package Jeu;

import com.sun.xml.internal.ws.policy.AssertionSet;
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
        faces = joueur.lancerLesDes(joueur.getNbrDes());
        Assert.assertEquals(faces.size(),8);
    }
}

