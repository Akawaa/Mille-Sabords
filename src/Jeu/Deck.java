package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ravier on 15/11/14.
 */
public class Deck {
    List<Carte> deckList;

    public Deck() {
        deckList = new ArrayList<Carte>();
        initDeck();
        //mélanger dans la partie du joueur
    }

    public void initDeck() {
        int i;
        for (i = 0 ; i<3; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort1"));
        }
        for (i= 0 ; i<2; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort2"));
        }
        for (i = 0 ; i<2; i++){
            deckList.add(new CarteTeteMort("CarteBateauPirate3"));
        }
        for (i= 0 ; i<2; i++){
            deckList.add(new CarteTeteMort("CarteBateauPirate3"));
        }
        for (i = 0 ; i<2; i++){
            deckList.add(new CarteTeteMort("CarteBateauPirate4"));
        }
        for (i = 0; i<4; i++){
            deckList.add(new CarteTeteMort("CarteIleTresor"));
            deckList.add(new CarteTeteMort("CarteGardienne"));
            deckList.add(new CarteTeteMort("CarteDiamant"));
            deckList.add(new CarteTeteMort("CartePirate"));
            deckList.add(new CarteTeteMort("CartePieceOr"));
            deckList.add(new CarteTeteMort("CarteAnimaux"));
        }
    }

    public int tailleDeck() {
        return deckList.size();
    }

    public void melangerDeck() { // Melange deck
        Collections.shuffle(deckList);
    }

    public Carte piocheCarte() { //à utiliser dans la gestion de la partie
        if (deckList.size() == 0){
            deckList = new ArrayList<Carte>();
            initDeck();
            melangerDeck();
        }
        Carte cartePiochee;
        cartePiochee = deckList.get(deckList.size()-1);
        deckList.remove(deckList.size()-1);
        return cartePiochee;
    }

    public List<Carte> getDeckList() {
        return deckList;
    }

}
