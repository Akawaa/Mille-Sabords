package Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Berenice on 14/11/14......
 */
public class View extends JFrame {
    /*JPANEL*/
    JPanel jpGeneral; //Général, tout les JPanels de la fenêtre seront dans ce JPanel général


    /*MENU*/
    JMenuBar barMenu;
    JMenu menu;
    JMenuItem start;
    JMenuItem help;
    JMenuItem exit;

    /*JBUTTON*/
    JButton jbContentDeck;



    public View() {
        this.setLayout(null);
        initMenu();
        initFenetreGame();
        initDeckGraphic(); //partie graphique du deck


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

    public void initDeckGraphic() {
        jbContentDeck = new JButton("Deck");
        jbContentDeck.setPreferredSize(new Dimension(125, 125));


        Insets insets = jpGeneral.getInsets();

        //placement deck
        Dimension size = jbContentDeck.getPreferredSize();
        jbContentDeck.setBounds(25 + insets.left, 5 + insets.top,size.width, size.height);

        jpGeneral.add(jbContentDeck);

    }


}
