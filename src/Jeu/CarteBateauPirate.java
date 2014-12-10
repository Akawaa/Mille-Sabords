package Jeu;

/**
 * Created by ravier on 15/11/14.
 */
public class CarteBateauPirate extends Carte{
     int nbrSabre;

    public CarteBateauPirate(String nom, int nbrSabre) {
        super(nom);
        this.nbrSabre = nbrSabre;
    }

    public int getNbrSabre(){
        return nbrSabre;
    }
}
