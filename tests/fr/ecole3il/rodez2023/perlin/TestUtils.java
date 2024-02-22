package fr.ecole3il.rodez2023.perlin;

import org.junit.Test;
import org.junit.Assert;

public class TestUtils {

    @Test
    public void TestMin() {
        Assert.assertEquals(1., Utils.min(1., 2.), 0.0001);
    }

    @Test
    public void TestMelanger() {
        int[] tab = {1, 2, 3, 4, 5, 6};
        int[] tabExpected = {6, 1, 2, 4, 3, 5};
        Assert.assertArrayEquals(tabExpected, Utils.melanger(tab, 2));
    }
}
