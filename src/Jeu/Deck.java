package Jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravier on 15/11/14.
 */
public class Deck {
    List<Carte> deckList;

    public Deck() {
        deckList = new ArrayList<Carte>();
        initDeck();
        shuffle(); //adapte ta méthode stp aurélien
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

    public Carte piocheCarte() { //à utiliser dans la gestion de la partie
        if (deckList.size() == 0){
            deckList = new ArrayList<Carte>();
            initDeck();
            shuffle();// adapte ta méthode stp aurélien
        }
        Carte cartePiochee;
        cartePiochee = deckList.get(deckList.size()-1);
        deckList.remove(deckList.size()-1);
        return cartePiochee;
    }


}
