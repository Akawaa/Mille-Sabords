package Jeu;

import javax.swing.*;
import java.awt.*;

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
    JButton jbContentDeck;
    JButton jbN;//test
    JButton jbs;//test
    JButton jbe;//test
    JButton jbc;//test
    JButton jbb;//test



    public View() {
        this.setLayout(new BorderLayout());
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
        jpBot = new JPanel();
        jpCenter = new JPanel();
        jpLeft = new JPanel();
        jpRigth = new JPanel();
        jpTop = new JPanel();

        jpGeneral.add(jpLeft, BorderLayout.WEST);
        jpGeneral.add(jpBot, BorderLayout.SOUTH);
        jpGeneral.add(jpCenter, BorderLayout.CENTER);
        jpGeneral.add(jpRigth, BorderLayout.EAST);
        jpGeneral.add(jpTop, BorderLayout.NORTH);
        setContentPane(jpGeneral);
    }

    public void initDeckGraphic() {
        jbContentDeck = new JButton("Deck");
        jbb = new JButton("bottom");//test
        jbc = new JButton("center");//test
        jbe = new JButton("est");//test
        jbN = new JButton("north");//test

        jpBot.add(jbb);//test
        jpCenter.add(jbc);//test
        jpRigth.add(jbe);//test
        jpTop.add(jbN);//test
        jpLeft.add(jbContentDeck);
        jbContentDeck.setPreferredSize(new Dimension(125, 125));
    }


}
