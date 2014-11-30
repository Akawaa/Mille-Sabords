package Jeu;

import com.sun.xml.internal.ws.policy.AssertionSet;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
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

    //Ce test test que la méthode de lecture d'un fichier fonctionne bien, que le type de retour est bien un String
    // "parsé" en entier
    @Test
    public void testGetScoreDunFichierScore() throws IOException {
        Joueur joueur = new Joueur("Tata");
        int retour;
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine()).thenReturn("8");
        retour = joueur.getScoreTest(bufferedReader);
        Assert.assertEquals(retour, 8);
    }

    //Cette méthode de test test l'écriture dans un fichier et appelle la méthode de lecture pour contrôler le contenu du fichier
    //le fichier "testFile.txt" est crée ici dans le répertoire de test.
    @Test
    public void testEcritureFichierScore() throws IOException {
        Joueur joueur = new Joueur("Toctoc");
        File file = new File("testFile.txt");
        PrintStream ps = new PrintStream(file);
        joueur.saveScoreTest(ps);

        BufferedReader br = new BufferedReader(new FileReader(file));
        Assert.assertEquals(joueur.getScoreTest(br), 666);
    }
}

