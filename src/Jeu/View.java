package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Berenice on 14/11/14.
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
    protected JLabel bullePirate;
    protected JLabel regleJeu;

    /* JPANEL */
    protected ImagePanel general;

    /* JComboBox */
    protected JComboBox jcbNombreJoueur;

    /* Appel de classes */
    Joueur joueur;


    public View() throws IOException {
        setSize(1300,720);       // Définition de la taille de la fenêtre de jeu
        setResizable(false);    // Taille fixe afin d'éviter les problèmes de positionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        general = new ImagePanel(new ImageIcon(this.getClass().getResource("img/image_jeu.jpg" )).getImage());
        general.setLayout(null);
        this.getContentPane().add(general);

        initAccueil();
        initPartie();
    }

    public void initAccueil() {

    }

    public void initPartie() throws IOException {
        initMenu();         // Initialisation du menu du jeu
        initRegle();
        initDeckGraphic();  // Initialisation du deck de jeu et de son affichage
        initScoreJoueur();  // Initialisation du score du joueur en cours
        initBoutonPasserTour(); //Initalisation du bouton "passer son tour"
    }

    private void initRegle() {
        regleJeu = new JLabel(new ImageIcon(this.getClass().getResource("img/regles.png" )));
        regleJeu.setBounds(50,370,218, 300);
        general.add(regleJeu);
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

    public void initScoreJoueur() throws IOException { //initalisation des labels score et nomdujoueur
        /*Initialisation*/
        joueur = new Joueur("joueurTest"); //Logiquement joueur doit être initialisé dans partie déjà mais là je l'initialise ici pour faire un test
        nomJoueurEnCours = new JLabel("Score de "+joueur.getNom()+" :"); //nom du joueur
        scoreJoueurEnCours = new JLabel(joueur.getScore()+"");

        /* Placement dans la fenêtre*/
        nomJoueurEnCours.setBounds(1050, 5, 200, 15);
        general.add(nomJoueurEnCours);

        scoreJoueurEnCours.setBounds(1220, 5, 50, 15);
        general.add(scoreJoueurEnCours);

    }

    public void initDeckGraphic() {

        ImageIcon icon = new ImageIcon(this.getClass().getResource("img/CarteDos.jpg" ));
        jbContentDeck = new JButton(icon);
        jbContentDeck.setBounds(70, 20,126,200);

        general.add(jbContentDeck);

        imageCartePiocher = new JLabel(new ImageIcon(""));
        imageCartePiocher.setBounds(210, 20,126, 200);
        general.add(imageCartePiocher);

    }

    public void initBoutonPasserTour() {
        jbPasserTour = new JButton("Passer son tour");
        jbPasserTour.setPreferredSize(new Dimension(150, 75));

        Dimension sizePasserTour = jbPasserTour.getPreferredSize();
        jbPasserTour.setBounds(850, 600,sizePasserTour.width, sizePasserTour.height);
        general.add(jbPasserTour);
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
        imageCartePiocher.setIcon(new ImageIcon(this.getClass().getResource("img/" + cartePiocher.getNom() + ".jpg")));
    }

    public void desacDeck() {
        jbContentDeck.setEnabled(false);
    }

    public void activDeck() {
        jbContentDeck.setEnabled(true);
    }
}
