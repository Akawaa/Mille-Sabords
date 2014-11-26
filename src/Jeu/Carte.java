package Jeu;

/**
 * Created by ravier on 15/11/14.
 */
public class Carte {
    private String nom;

    public Carte(String nom) { this.nom = nom; }
    public Carte(Carte c) {
        this.nom = c.getNom();
    }

    public String getNom() {
        return nom;
    }
}
