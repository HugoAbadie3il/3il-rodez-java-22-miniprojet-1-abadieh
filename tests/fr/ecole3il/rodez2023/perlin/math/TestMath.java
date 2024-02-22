package fr.ecole3il.rodez2023.perlin.math;

import org.junit.Test;
import org.junit.Assert;

public class TestMath {

    @Test
    public void TestBruitPerlin2DBasic(){
        BruitPerlin2D bruit = new BruitPerlin2D(123, 1.0);
        Assert.assertEquals(-0.047517575695735954, bruit.bruit2D(0.3, 0.3), 0.00001);
    }

    @Test
    public void TestBruitPerlin2DCorner(){
        BruitPerlin2D bruit = new BruitPerlin2D(123, 1.0);
        Assert.assertEquals(0., bruit.bruit2D(0.0, 0.0), 0.00001);
    }
}
