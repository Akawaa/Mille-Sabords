package Jeu;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quentin on 16/11/14.
 */
public class TestUnitDe {

    @Test
    public void testLanceDe(){
        De de = new De();
        Assert.assertEquals(8, de.lanceDe().size());
    }
}
