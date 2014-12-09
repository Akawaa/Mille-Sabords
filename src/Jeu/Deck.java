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
        /*MESSAGE of: Quentin
        * A DESTINATION DU CODEUR QUI TAPE SES PROGRAMMES AVEC SES PIEDS... celui qui à codé après Clément sur le deck
        *
        * Bravo++ pour le copié-collé MAL fait ==> il n'y avait que des CarteTeteMort dans le deck, de ce fait
        * j'ai bataillé 2h avec mes tests sur des instanceof alors que le problème venait du Deck
        *
        * Un dev respectant le TDD avec un test du nombre d'instance de chaque carte dans le Deck aurait été le bien venu et
        * aurait évité ce genre d'erreur. ==> j'ai pondu le test  du coup
        *
        * /********\
        * | ^^  ^^ |
        * |   |    |
        * |  --    |
        * \*******/ /*
        *
        * Boucles dégeus, une variable locale différente pour chaque boucle ==> Stupide au lieu de déclarer i dès le début.
        *
        * 3 millions 856 542 boucles pour initiliser le deck -__-" ==> pourris, heureusement qu'on a pas
        * des collections avec plusieurs millions d'élèment à gerer, j'ai raccourci à 3 boucles
        *
        * Bref que des erreurs dignes de semestre 1 et qui auraient pu etre évitées.
        * Fin de la réclamation au service client.
        * */
        int i;
        for (i = 0 ; i<3; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort1"));
        }
        for (i= 0 ; i<2; i++){
            deckList.add(new CarteTeteMort("CarteTeteMort2"));
            deckList.add(new CarteBateauPirate("CarteBateauPirate2",2));
            deckList.add(new CarteBateauPirate("CarteBateauPirate3",3));
            deckList.add(new CarteBateauPirate("CarteBateauPirate4",4));
        }
        for (i = 0; i<4; i++){
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
