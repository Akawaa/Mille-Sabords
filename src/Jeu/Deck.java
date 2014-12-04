package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ravier on 15/11/14.
 * test yoyo
 */
public class Deck {
    List<Carte> deckList;

    public Deck() {
        deckList = new ArrayList<Carte>();
        initDeck();
        //mélanger dans la partie du joueur
    }

    public void initDeck() {
        //initialisation du deck avec 24 carte, 3 de chaque (en attendant de savoir exactement combien de carte il y a dans le jeu)
        for (int i = 0 ; i<3; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort1"));
        }
        for (int i2 = 0 ; i2<2; i2++){
            deckList.add(new CarteTeteMort("CarteTeteMort2"));
        }
        for (int i3 = 0 ; i3<2; i3++){
            deckList.add(new CarteTeteMort("CarteBateauPirate3"));
        }
        for (int i4 = 0 ; i4<2; i4++){
            deckList.add(new CarteTeteMort("CarteBateauPirate3"));
        }
        for (int i5 = 0 ; i5<2; i5++){
            deckList.add(new CarteTeteMort("CarteBateauPirate4"));
        }
        for (int i6 = 0; i6<4; i6++){
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
