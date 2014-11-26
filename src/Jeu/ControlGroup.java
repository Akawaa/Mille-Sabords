package Jeu;

/**
 * Created by aurelien on 26/11/14..
 */
public class ControlGroup {
    private Model model;
    private View view;
    private ControlMenu controlMenu;
    private ControlBouton controlBouton;

    public ControlGroup(Model model) {

        this.model = model;

        view = new View();

        controlBouton = new ControlBouton(model,view);
        controlMenu = new ControlMenu(model,view);

        view.display();
    }
}
