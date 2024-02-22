package fr.ecole3il.rodez2023.perlin.terrain;

import fr.ecole3il.rodez2023.perlin.terrain.concrets.DetermineurTerrainEnonce;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.AltitudeAffiche;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;
import org.junit.Assert;
import org.junit.Test;

public class TestTerrain {

    @Test
    public void TestTypeTerrainBasic(){
        Terrain terrain = new Terrain(-0.5,0.3,0.5);
        DetermineurTerrainEnonce dt = new DetermineurTerrainEnonce();
        Assert.assertEquals(TypeTerrain.OCEAN, terrain.getTypeTerrain(dt));
    }
}
