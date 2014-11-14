package jeu;

import javax.swing.*;

/**
 * Created by Berenice on 12/11/14.
 */
public class Fenetre extends JFrame {

    /* MENU */
    private JMenuBar barMenu;
    private JMenu menu;
    private JMenuItem demarrer;
    private JMenuItem regle;
    private JMenuItem quitter;

    public ControlBouton bMenu;

    public Fenetre(){

        iniMenu();

        //initLabel();

        setSize(1200,800);  //Fixe la taille par defaut
        setResizable(false);
        setVisible(true);  //Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //gere la fermeture



    }


    public void iniMenu() {

        barMenu = new JMenuBar();

        menu = new JMenu("Options");

        demarrer = new JMenuItem("Nouvelle partie");
        regle = new JMenuItem("Comment jouer ?");

        quitter = new JMenuItem("Quitter");

        menu.add(demarrer);
        menu.add(regle);
        menu.addSeparator();
        menu.add(quitter);

        barMenu.add(menu);

        setJMenuBar(barMenu);

    }

    public JMenuItem getDemarrer(){
        return demarrer;
    }

    public JMenuItem getQuitter(){
        return quitter;
    }


}

