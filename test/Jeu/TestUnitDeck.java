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
        Assert.assertEquals(24, deck.tailleDeck());
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
