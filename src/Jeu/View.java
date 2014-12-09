package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
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
    protected JButton jbLancerDe;
    protected JButton jbValiderNbJoueur;
    protected JButton validerNomJoueur;

    protected JButton jbContentDe1;
    protected JButton jbContentDe2;
    protected JButton jbContentDe3;
    protected JButton jbContentDe4;
    protected JButton jbContentDe5;
    protected JButton jbContentDe6;
    protected JButton jbContentDe7;
    protected JButton jbContentDe8;

    /* JLabel */
    protected JLabel imageCartePiocher;
    protected JLabel nomJoueurEnCours;
    protected JLabel scoreJoueurEnCours;
    protected JLabel bullePirate;
    protected JLabel regleJeu;
    protected JLabel selectionJoueur;

    /* JComboBox */
    protected JComboBox jcbNombreJoueur;

    /* JPANEL */
    protected ImagePanel general;

    /* JTextField */
    JTextField[] nomJoueur;


    public View() throws IOException {
        setSize(1300,720);       // Définition de la taille de la fenêtre de jeu
        setResizable(false);    // Taille fixe afin d'éviter les problèmes de positionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ***************** Création du JPanel global **************

        general = new ImagePanel(new ImageIcon(this.getClass().getResource("img/image_jeu.jpg" )).getImage());
        general.setLayout(null);    // layout null pour le placement libre des objets
        getContentPane().add(general);

        initMenu();

        // ***************** Initialisation de la vue en attendant le nombre de joueur
        nombreJoueur();
        bullePirate("bulleNombreJoueur.png");
    }

    public void initJeu(Joueur joueurenCour, ControlBouton cb) throws IOException {
        initDeckGraphic();  // Initialisation du deck de jeu et de son affichage
        initDe();//Initialise les dés
        initScoreJoueur(joueurenCour);  // Initialisation du score du joueur en cours
        initBoutonPasserTour(); //Initalisation du bouton "passer son tour"
        //initBoutonLancerDe();
        cb.actionBoutonPasserTour();
        setBoutonDeckGraphic(cb);
        afficherRegle();

        //bullePirate("bulleNombreJoueur.png");
    }

    public void afficherRegle() {
        regleJeu = new JLabel(new ImageIcon(this.getClass().getResource("img/regles.png" )));
        regleJeu.setBounds(50, 370, 218, 300);
        general.add(regleJeu);
    }

    public void initMenu() {

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

    public void initScoreJoueur(Joueur joueur) throws IOException { //initalisation des labels score et nomdujoueur
        /*Initialisation*/
        nomJoueurEnCours = new JLabel("Score de "+joueur.getNom()+" :"); //nom du joueur
        scoreJoueurEnCours = new JLabel(joueur.getPoints()+"");

        /* Placement dans la fenêtre*/
        nomJoueurEnCours.setBounds(1050, 5, 200, 15);
        general.add(nomJoueurEnCours);

        scoreJoueurEnCours.setBounds(1220, 5, 50, 15);
        general.add(scoreJoueurEnCours);

    }

    public void initDeckGraphic() {

        ImageIcon icon = new ImageIcon(this.getClass().getResource("img/CarteDos.jpg" ));
        jbContentDeck = new JButton(icon);

        jbContentDeck.setPreferredSize(new Dimension(126, 200));

        //placement deck
        Dimension size = jbContentDeck.getPreferredSize();
        jbContentDeck.setBounds(70, 5,size.width, size.height);

        general.add(jbContentDeck);

        imageCartePiocher = new JLabel(new ImageIcon(""));
        imageCartePiocher.setBounds(200, 5,126, 200);
        general.add(imageCartePiocher);

    }

    public void initDe(){
        jbContentDe1 = new JButton();
        jbContentDe2 = new JButton();
        jbContentDe3 = new JButton();
        jbContentDe4 = new JButton();
        jbContentDe5 = new JButton();
        jbContentDe6 = new JButton();
        jbContentDe7 = new JButton();
        jbContentDe8 = new JButton();

        jbContentDe1.setPreferredSize(new Dimension(68, 68));
        jbContentDe2.setPreferredSize(new Dimension(68, 68));
        jbContentDe3.setPreferredSize(new Dimension(68, 68));
        jbContentDe4.setPreferredSize(new Dimension(68, 68));
        jbContentDe5.setPreferredSize(new Dimension(68, 68));
        jbContentDe6.setPreferredSize(new Dimension(68, 68));
        jbContentDe7.setPreferredSize(new Dimension(68, 68));
        jbContentDe8.setPreferredSize(new Dimension(68, 68));

        Dimension size1 = jbContentDe1.getPreferredSize();
        Dimension size2 = jbContentDe2.getPreferredSize();
        Dimension size3 = jbContentDe3.getPreferredSize();
        Dimension size4 = jbContentDe4.getPreferredSize();
        Dimension size5 = jbContentDe5.getPreferredSize();
        Dimension size6 = jbContentDe6.getPreferredSize();
        Dimension size7 = jbContentDe7.getPreferredSize();
        Dimension size8 = jbContentDe8.getPreferredSize();

        jbContentDe1.setBounds(600, 400,size1.width, size1.height);
        jbContentDe2.setBounds(670, 400,size2.width, size2.height);
        jbContentDe3.setBounds(740, 400,size3.width, size3.height);
        jbContentDe4.setBounds(810, 400,size4.width, size4.height);
        jbContentDe5.setBounds(600, 470,size5.width, size5.height);
        jbContentDe6.setBounds(670, 470,size6.width, size6.height);
        jbContentDe7.setBounds(740, 470,size7.width, size7.height);
        jbContentDe8.setBounds(810, 470,size8.width, size8.height);

        general.add(jbContentDe1);
        general.add(jbContentDe2);
        general.add(jbContentDe3);
        general.add(jbContentDe4);
        general.add(jbContentDe5);
        general.add(jbContentDe6);
        general.add(jbContentDe7);
        general.add(jbContentDe8);

    }


    public void setBoutonDeckGraphic(ActionListener listener) {
        jbContentDeck.addActionListener(listener);
    }

    public void initBoutonPasserTour() {
        jbPasserTour = new JButton("Passer son tour");
        jbPasserTour.setPreferredSize(new Dimension(150, 75));


        Dimension sizePasserTour = jbPasserTour.getPreferredSize();
        jbPasserTour.setBounds(750, 550, sizePasserTour.width, sizePasserTour.height);
        general.add(jbPasserTour);
    }

    public void initBoutonLancerDe() {
        jbLancerDe = new JButton("Lancer les dés");
        jbLancerDe.setPreferredSize(new Dimension(150, 75));


        Dimension sizePasserTour = jbLancerDe.getPreferredSize();
        jbLancerDe.setBounds(590, 550, sizePasserTour.width, sizePasserTour.height);
        general.add(jbLancerDe);
    }

    public void setBoutonPasserTour(ActionListener listener) {
        jbPasserTour.addActionListener(listener);
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

    //---------------------------Ajout des ActionListener sur le menu------------------
    public void setListenerMenu(ControlMenu controlMenu) {
        exit.addActionListener(controlMenu);
        start.addActionListener(controlMenu);
        help.addActionListener(controlMenu);
    }
    //---------------------------FIN Ajout des ActionListener sur le menu------------------

    public void bullePirate(String nom_image) {
        bullePirate = new JLabel(new ImageIcon(this.getClass().getResource("img/"+nom_image)));
        bullePirate.setBounds(930,310,250, 176);
        general.add(bullePirate);
    }

    public void removeAllElements() {
        general.removeAll();
        general.revalidate();
        repaint();
    }

    /* ********************* Partie nombre des joueurs *********************** */

    public void nombreJoueur() {
        selectionJoueur = new JLabel("Veuillez selectionner un nombre de joueurs :");
        selectionJoueur.setBounds(400, 250, 400, 30);
        general.add(selectionJoueur);

        String[] choix = { "2", "3", "4", "5"};
        jcbNombreJoueur = new JComboBox(choix);

        jcbNombreJoueur.setBounds(500, 300, 100, 30);
        general.add(jcbNombreJoueur);

        jbValiderNbJoueur = new JButton("Valider");
        jbValiderNbJoueur.setBounds(500, 350, 100, 40);
        general.add(jbValiderNbJoueur);
    }

    public void setValiderNbJoueurListener(ActionListener listener) {
        jbValiderNbJoueur.addActionListener(listener);
    }

    public JComboBox getNombreJoueur() { return jcbNombreJoueur; }

    /* ********************* Partie nom des joueurs *********************** */

    public void nommerJoueur(int nbJoueur) {
        nomJoueur = new JTextField[nbJoueur];
        int i;
        for(i=0;i<nbJoueur;i++) {
            JLabel joueurARemplir = new JLabel("Joueur " + i + " : ");
            joueurARemplir.setBounds(400,50+i*100,200, 30);
            general.add(joueurARemplir);

            nomJoueur[i] = new JTextField();
            nomJoueur[i].setBounds(400,100+i*100,200, 30);
            general.add(nomJoueur[i]);
        }

        validerNomJoueur = new JButton("Valider");
        validerNomJoueur.setBounds(400,150+i*100,200, 30);
        general.add(validerNomJoueur);

        bullePirate("bulleNomJoueur.png");
    }

    public void setValiderNomJoueurListener(ActionListener listener) {
        validerNomJoueur.addActionListener(listener);
    }


    public JTextArea getDocumentation() {
        JTextArea doc;
        doc = new JTextArea(readFile("./src/Jeu/documentation/documentation.txt"));
        return  doc;
    }

    public String readFile( String file )
    {

        String lines = "";
        String line;
        try
        {

            BufferedReader reader = new BufferedReader( new FileReader(file) );

            // lis ligne à ligne
            while( (line = reader.readLine()) != null )
                lines += line+"\n";
        }
        catch( Exception e )
        {
            lines = "Une erreur s'est produite durant la lecture du flux : "+e.getMessage();
        }

        return lines;
    }

    //-----------Vue de la documentation-------------------------
    public void Documentationview(){
        JOptionPane d = new JOptionPane();

        d.showMessageDialog(null,
                getDocumentation());
    }

//---------Fin vue de la documentation---------------

}
