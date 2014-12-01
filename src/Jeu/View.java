package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    protected JMenuBar barMenu;
    protected JMenu menu;
    protected JMenuItem start;
    protected JMenuItem help;
    protected JMenuItem exit;

    /*JBUTTON*/
    protected JButton jbContentDeck;
    protected JButton jbPasserTour;

    /* JLabel */
    protected JLabel imageCartePiocher;
    protected JLabel nomJoueurEnCours;
    protected JLabel scoreJoueurEnCours;

    /* Appel de classes */
    Joueur joueur;


    public View() throws IOException{
        setLayout(null);    // layout null pour le placement libre des objets
        initMenu();         // Initialisation du menu du jeu
        initDeckGraphic();  // Initialisation du deck de jeu et de son affichage
        initScoreJoueur();  // Initialisation du score du joueur en cours
        initBoutonPasserTour(); //Initalisation du bouton "passer son tour"

        setSize(1300,720);       // Définition de la taille de la fenêtre de jeu
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

    public void initScoreJoueur() throws IOException{ //initalisation des labels score et nomdujoueur
        /*Initialisation*/
        joueur = new Joueur("joueurTest"); //Logiquement joueur doit être initialisé dans partie déjà mais là je l'initialise ici pour faire un test
        nomJoueurEnCours = new JLabel("Score de "+joueur.getNom()+" :"); //nom du joueur
        scoreJoueurEnCours = new JLabel(joueur.getScore()+"");

        /* Placement dans la fenêtre*/
        nomJoueurEnCours.setBounds(1050, 5, 200, 15);
        add(nomJoueurEnCours);

        scoreJoueurEnCours.setBounds(1220, 5, 50, 15);
        add(scoreJoueurEnCours);

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

    public void initBoutonPasserTour() {
        jbPasserTour = new JButton("Passer son tour");
        jbPasserTour.setPreferredSize(new Dimension(150, 75));

        Dimension sizePasserTour = jbPasserTour.getPreferredSize();
        jbPasserTour.setBounds(1000, 600,sizePasserTour.width, sizePasserTour.height);

        add(jbPasserTour);

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
        imageCartePiocher.setIcon(new ImageIcon(this.getClass().getResource("img/" + cartePiocher.getNom() + ".png")));
    }

    public void desacDeck() {
        jbContentDeck.setEnabled(false);
    }

    public void activDeck() {
        jbContentDeck.setEnabled(true);
    }

    //---------------------------Ajout des ActionListener sur le menu------------------
    public void setListenerMenu(ControlMenu controlMenu) {
        exit.addActionListener(controlMenu);
    }
    //---------------------------FIN Ajout des ActionListener sur le menu------------------
}
