package Jeu;

/**
 * Created by ravier on 15/11/14.
 */

/**
 * Methode pour push des images sur Github :
 * Se déplacer dans le dossier des images à push
 * > git add .
 * > git commit -m <Message>
 * > git push -u origin master
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
