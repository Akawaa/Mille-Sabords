package Jeu;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by quentin on 08/12/14.
 */
public class TestUnitPartie {
    @Test
    public void testCompterPoint4TeteDeMort() throws IOException, InterruptedException {
        String nomJoueurs[] = new String[2];
        nomJoueurs[0] = "toto";
        nomJoueurs[1] = "tutu";
        ControlBouton controlBouton = Mockito.mock(ControlBouton.class);
        View view = Mockito.mock(View.class);
        Partie partie = new Partie(2,nomJoueurs,view,controlBouton);

        ArrayList<String> listeFaces = new ArrayList<String>();
        for(int i=0;i<2;i++){
            listeFaces.add("DIAMANT");
        }
        for(int i=0;i<2;i++){
            listeFaces.add("PIECE");
        }
        for(int i=0;i<4;i++){
            listeFaces.add("MORT");
        }
        partie.getJoueur(0).setPoints(0);
        partie.getJoueur(1).setPoints(0);
        partie.getJoueur(0).setFacesTirees(listeFaces);
        partie.getJoueur(0).teteDeMortDe();
        partie.compterPoint4TeteDeMort(partie.getJoueur(0));
        Assert.assertEquals(-400, partie.getJoueur(0).getPoints());
        Assert.assertEquals(-400, partie.getJoueur(1).getPoints());

        listeFaces.clear();
        partie.getJoueur(0).setPoints(0);
        partie.getJoueur(1).setPoints(0);
        for(int i=0;i<2;i++){
            listeFaces.add("DIAMANT");
        }
        for(int i=0;i<2;i++){
            listeFaces.add("PIECE");
        }
        for(int i=0;i<4;i++){
            listeFaces.add("SINGE");
        }

        partie.getJoueur(0).setFacesTirees(listeFaces);
        partie.getJoueur(0).teteDeMortDe();
        partie.compterPoint4TeteDeMort(partie.getJoueur(0));
        Assert.assertEquals(0, partie.getJoueur(0).getPoints());
        Assert.assertEquals(0, partie.getJoueur(1).getPoints());
    }
}
