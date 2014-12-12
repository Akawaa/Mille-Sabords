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

        for (int i = 0 ; i<3; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort1"));
        }
        for (int i= 0 ; i<2; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort2"));
            deckList.add(new CarteBateauPirate("CarteBateauPirate2",2));
            deckList.add(new CarteBateauPirate("CarteBateauPirate3",3));
            deckList.add(new CarteBateauPirate("CarteBateauPirate4",4));
        }
        for (int i = 0; i<4; i++){
            deckList.add(new CarteIleTresor("CarteIleTresor"));
            deckList.add(new CarteGardienne("CarteGardienne"));
            deckList.add(new CarteDiamant("CarteDiamant"));
            deckList.add(new CartePirate("CartePirate"));
            deckList.add(new CartePieceOr("CartePieceOr"));
            deckList.add(new CarteAnimaux("CarteAnimaux"));
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
