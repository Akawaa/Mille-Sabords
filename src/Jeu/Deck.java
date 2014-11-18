package Jeu;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collection;
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


}
