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
}
