package Jeu;

import javax.swing.*;

/**
 * Created by Berenice on 14/11/14.
 */
public class View extends JFrame {

    /*MENU*/
    JMenuBar barMenu;
    JMenu menu;
    JMenuItem start;
    JMenuItem help;
    JMenuItem exit;

    public View() {

        initMenu();

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


}
