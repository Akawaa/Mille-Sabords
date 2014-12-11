package Jeu;

import java.io.IOException;

/**
 * Created by aurelien on 26/11/14..
 */
public class ControlGroup {
    private Model model;
    private View view;
    private ControlMenu controlMenu;
    private ControlBouton controlBouton;

    public ControlGroup(Model model) throws IOException{

        this.model = model;

        view = new View();

        controlMenu = new ControlMenu(model,view);
        controlBouton = new ControlBouton(model,view, controlMenu);


        view.display();
    }
}
