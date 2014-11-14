package jeu;

import jeu.Fenetre;

/**
 * Created by Berenice on 12/11/14.
 */
public class Appli {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        Fenetre fenetre =new Fenetre();
                    }
                }
        );
    }
}
