package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Berenice on 14/11/14.
 */

/**
 *  Information par Aurélien :
 *  Afin de placer les éléments graphique ou l'on veut dans une fenetre, il faut travailler avec setBounds()
 *  Cependant ce n'est pas compatible avec des layout définit, donc plus largement incompatible avec des JPanel
 */
public class View extends JFrame {


    /*MENU*/
    JMenuBar barMenu;
    JMenu menu;
    JMenuItem start;
    JMenuItem help;
    JMenuItem exit;

    /*JBUTTON*/
    JButton jbContentDeck;

    /* JLabel */
    JLabel imageCartePiocher;


    public View() {
        setLayout(null);    // layout null pour le placement libre des objets
        initMenu();         // Initialisation du menu du jeu
        initDeckGraphic();  // Initialisation du deck de jeu et de son affichage

        setSize(800,500);       // Définition de la taille de la fenêtre de jeu
        setResizable(false);    // Taille fixe afin d'éviter les problèmes de positionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initMenu() {

        barMenu = new JMenuBar();

        menu = new JMenu("Options");

        start = new JMenuItem("Nouvelle Partie");
        help = new JMenuItem("Comment jouer ?");
        exit = new JMenuItem("Quitter");

        menu.add(start);
        menu.add(help);
        menu.addSeparator();
        menu.add(exit);

        barMenu.add(menu);

        setJMenuBar(barMenu);
    }

    public void initDeckGraphic() {

        ImageIcon icon = new ImageIcon(this.getClass().getResource("img/CarteDos.jpg" ));
        jbContentDeck = new JButton(icon);

        jbContentDeck.setPreferredSize(new Dimension(89, 136));

        //placement deck
        Dimension size = jbContentDeck.getPreferredSize();
        jbContentDeck.setBounds(70, 5,size.width, size.height);

        add(jbContentDeck);

        imageCartePiocher = new JLabel(new ImageIcon(""));
        imageCartePiocher.setBounds(200, 5,89, 136);
        add(imageCartePiocher);

    }

    public void display() {
        setVisible(true);
    }

    public void undisplay() {
        setVisible(false);
    }

    public void setControlDeck(ActionListener listener) {
        jbContentDeck.addActionListener(listener);
    }

    public void afficherCarte(Carte cartePiocher) {
        System.out.println("img/" + cartePiocher.getNom() + ".png");
        Icon imageIconeCarte = new ImageIcon(this.getClass().getResource("img/" + cartePiocher.getNom() + ".png"));

        imageCartePiocher.setIcon(imageIconeCarte);
    }
}
