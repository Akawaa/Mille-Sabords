package Jeu;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by ravier on 15/11/14.
 */
public class TestUnitDeck {
    @Test
    public void TestInitTailleDeck() {
        Deck deck = new Deck();
        Assert.assertEquals(35, deck.tailleDeck());

        int nbrCarteBateauPirate=0;
        int nbrCarteDiamant=0;
        int nbrCarteGardienne=0;
        int nbrCarteIleTresor=0;
        int nbrCartePieceOr=0;
        int nbrCartePirate=0;
        int nbrCarteTeteMort=0;
        int nbrCarteAnimaux=0;

        for(int i=0;i<35;i++){
            if(deck.getDeckList().get(i) instanceof CarteBateauPirate){
                nbrCarteBateauPirate++;
            }
            if(deck.getDeckList().get(i) instanceof CarteDiamant){
                nbrCarteDiamant++;
            }
            if(deck.getDeckList().get(i) instanceof CarteGardienne){
                nbrCarteGardienne++;
            }
            if(deck.getDeckList().get(i) instanceof CarteIleTresor){
                nbrCarteIleTresor++;
            }
            if(deck.getDeckList().get(i) instanceof CartePieceOr){
                nbrCartePieceOr++;
            }
            if(deck.getDeckList().get(i) instanceof CartePirate){
                nbrCartePirate++;
            }
            if(deck.getDeckList().get(i) instanceof CarteTeteMort){
                nbrCarteTeteMort++;
            }
            if(deck.getDeckList().get(i) instanceof CarteAnimaux){
                nbrCarteAnimaux++;
            }

        }
        Assert.assertEquals(6, nbrCarteBateauPirate);
        Assert.assertEquals(4, nbrCarteDiamant);
        Assert.assertEquals(4, nbrCarteGardienne);
        Assert.assertEquals(4, nbrCarteIleTresor);
        Assert.assertEquals(4, nbrCartePieceOr);
        Assert.assertEquals(4, nbrCartePirate);
        Assert.assertEquals(5, nbrCarteTeteMort);
        Assert.assertEquals(4, nbrCarteAnimaux);

    }

    @Test
    public void TestMelangerDeck() {
        Deck deck = new Deck();
        Deck deck2 = new Deck();

        deck.melangerDeck();

        Assert.assertFalse(deck.getDeckList().equals(deck2.getDeckList()));
    }

    @Test
    public void TestPiocherCarte(){
        Deck deck = new Deck();
        int tailleDeckAvantPioche = deck.tailleDeck(); //cette variable prend la valeur de la taille de la liste avant la pioche
        Carte carte2 = deck.deckList.get(deck.tailleDeck()-1);
        Carte carte1 = deck.piocheCarte();
        Assert.assertEquals(carte1, carte2); //test que l'on pioche bien la première carte de la liste
        Assert.assertEquals(tailleDeckAvantPioche -1, deck.tailleDeck()); //test que l'on a bien un élément en moins dans la liste après avoir pioché et remove une carte.
    }
}
