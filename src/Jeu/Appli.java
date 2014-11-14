package Jeu;

/**
 * Created by Berenice on 14/11/14.
 */
public class Appli {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        View view = new View();
                    }
                });
    }
}
