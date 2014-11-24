package Jeu;

import javax.swing.*;

/**
 * Created by Berenice on 14/11/14.
 */
public class View extends JFrame {
    /*JPANEL*/
    JPanel jpGeneral; //Général, tout les JPanels de la fenêtre seront dans ce JPanel général
    JPanel jpTop;     //Zone du haut
    JPanel jpLeft;    //Zone de gauche
    JPanel jpBot;     //Zone bas
    JPanel jpRigth;   //Zone droite
    JPanel jpCenter;  //zone centrale

    /*MENU*/
    JMenuBar barMenu;
    JMenu menu;
    JMenuItem start;
    JMenuItem help;
    JMenuItem exit;

    /*JBUTTON*/
    JButton contentDeck;


    public View() {

        initMenu();
        initFenetreGame();

        setSize(1200,800);
        setResizable(false);
        setVisible(true);
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

    public void initFenetreGame() {
        jpGeneral = new JPanel();
    }


}
