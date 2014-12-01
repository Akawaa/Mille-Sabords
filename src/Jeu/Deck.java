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
        for (int i = 0 ; i<5; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort"));
        }
        for (int y = 0 ; y<3; y++){
            deckList.add(new CarteTeteMort("CarteAnimaux"));
        }
        for (int ii = 0 ; ii<6; ii++){
            deckList.add(new CarteTeteMort("CarteBateauPirate"));
        }
        for (int yy = 0; yy<4; yy++){
            deckList.add(new CarteTeteMort("CarteIleTresor"));
            deckList.add(new CarteTeteMort("CarteGardienne"));
            deckList.add(new CarteTeteMort("CarteDiamant"));
            deckList.add(new CarteTeteMort("CartePirate"));
            deckList.add(new CarteTeteMort("CartePieceOr"));
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
