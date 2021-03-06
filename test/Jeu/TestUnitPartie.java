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
        View view = Mockito.mock(View.class);
        Model model = Mockito.mock(Model.class);
        Partie partie = new Partie(2,nomJoueurs,view,model);

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

    @Test
    public void testCompterPointCartePieceDiamant() throws IOException, InterruptedException {
        String nomJoueurs[] = new String[2];
        nomJoueurs[0] = "toto";
        nomJoueurs[1] = "tutu";

        View view = Mockito.mock(View.class);
        Model model = new Model();
        Partie partie = new Partie(2,nomJoueurs,view,model);
        CarteDiamant carteDiamant = new CarteDiamant("CarteDiamant");

        model.setCarte(carteDiamant);
        partie.getJoueur(0).setPoints(0);
        partie.compterPointCartePieceDiamant(partie.getJoueur(0));
        Assert.assertEquals(100, partie.getJoueur(0).getPoints());
    }

    @Test
    public void testCompterPointCartePirate() throws IOException, InterruptedException {
        String nomJoueurs[] = new String[1];
        nomJoueurs[0] = "toto";

        View view = Mockito.mock(View.class);
        Model model = new Model();
        Partie partie = new Partie(1,nomJoueurs,view,model);
        CartePirate cartePirate = new CartePirate("CartePirate");

        partie.getJoueur(0).setPoints(0);
        ArrayList<String> listeFaces = new ArrayList<String>();
        for(int i=0;i<8;i++){
            listeFaces.add("PERROQUET");
        }
        partie.getJoueur(0).setFacesTirees(listeFaces);
        partie.getJoueur(0).compterPointDesIdentiques();

        model.setCarte(cartePirate);
        partie.compterPointCartePirate(partie.getJoueur(0));
        Assert.assertEquals(8000, partie.getJoueur(0).getPoints());

    }

    @Test
    public void testCompterPointCarteBateauPirate() throws IOException, InterruptedException {
        String nomJoueurs[] = new String[1];
        nomJoueurs[0] = "toto";

        View view = Mockito.mock(View.class);
        Model model = new Model();
        Partie partie = new Partie(1,nomJoueurs,view,model);
        CarteBateauPirate carteBateauPirate = new CarteBateauPirate("CarteBateauPirate2",2);

        partie.getJoueur(0).setPoints(0);
        ArrayList<String> listeFaces = new ArrayList<String>();
        for(int i=0;i<8;i++){
            listeFaces.add("PERROQUET");
        }
        partie.getJoueur(0).setFacesTirees(listeFaces);
        model.setCarte(carteBateauPirate);
        partie.compterPointCarteBateauPirate(partie.getJoueur(0));
        Assert.assertEquals(-300, partie.getJoueur(0).getPoints());


        carteBateauPirate = new CarteBateauPirate("CarteBateauPirate2",3);
        partie.getJoueur(0).setPoints(0);
        listeFaces.clear();
        for(int i=0;i<8;i++){
            listeFaces.add("PERROQUET");
        }
        partie.getJoueur(0).setFacesTirees(listeFaces);
        model.setCarte(carteBateauPirate);
        partie.compterPointCarteBateauPirate(partie.getJoueur(0));
        Assert.assertEquals(-500, partie.getJoueur(0).getPoints());

        carteBateauPirate = new CarteBateauPirate("CarteBateauPirate2",4);
        partie.getJoueur(0).setPoints(0);
        listeFaces.clear();
        for(int i=0;i<8;i++){
            listeFaces.add("PERROQUET");
        }
        partie.getJoueur(0).setFacesTirees(listeFaces);
        model.setCarte(carteBateauPirate);
        partie.compterPointCarteBateauPirate(partie.getJoueur(0));
        Assert.assertEquals(-1000, partie.getJoueur(0).getPoints());

    }

}
