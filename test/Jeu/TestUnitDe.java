package Jeu;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quentin on 16/11/14.
 */
public class TestUnitDe {

    //Le test consisite à voir si il existe bien un valeur associée à la clé choisie
    //aléatoirement avec la méthode lanceDe()
    @Test
    public void testLanceDe(){
        De de = new De();
        Assert.assertTrue(de.getFaces().containsKey(de.lanceDe()));
    }
}
