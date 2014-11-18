package Jeu;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by ravier on 15/11/14.
 */
public class Deck {
    List<Carte> deckList;

    public Deck() {
        deckList = new ArrayList<Carte>();
        initDeck();
    }

    public void initDeck() {
        //initialisation du deck avec 24 carte, 3 de chaque (en attendant de savoir exactement combien de carte il y a dans le jeu)
        for (int i = 0 ; i<3; i++){
            deckList.add(new CarteAnimaux());
            deckList.add(new CarteBateauPirate());
            deckList.add(new CarteDiamant());
            deckList.add(new CarteGardienne());
            deckList.add(new CartePieceOr());
            deckList.add(new CartePirate());
            deckList.add(new CarteTeteMort());
            deckList.add(new CarteIleTresor());
        }
    }

    public int tailleDeck() {
        return deckList.size();
    }

    public void melangerDeck() {
        Collections.shuffle(deckList);
    }

    public List<Carte> getDeckList() {
        return deckList;
    }
}
