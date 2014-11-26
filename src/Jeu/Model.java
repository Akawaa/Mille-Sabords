package Jeu;

/**
 * Created by Berenice on 14/11/14.
 */
public class Model {
    Deck deckJeu;

    public Model() {
        deckJeu = new Deck();
        deckJeu.melangerDeck();
    }

    public Carte tirerUneCarte() {
        return deckJeu.piocheCarte();
    }
}
