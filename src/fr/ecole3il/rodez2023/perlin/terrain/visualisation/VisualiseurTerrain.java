package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public class VisualiseurTerrain {
    private DetermineurTerrain determineurTerrain;
    private Carte carte;

    public VisualiseurTerrain(DetermineurTerrain determineurTerrain, Carte carte) {
        this.determineurTerrain = determineurTerrain;
        this.carte = carte;
    }

    public AltitudeAffiche getAltitudeAffichee(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);

        if (terrain == null) {
            throw new TerrainInexistant("Terrain inexistant");
        }
        double altitude = terrain.getAltitude();

        if (altitude < 0) {
            return AltitudeAffiche.FONDMARIN;
        } else if (altitude < 0.33) {
            return AltitudeAffiche.BASSE;
        } else if (altitude < 0.66) {
            return AltitudeAffiche.MOYENNE;
        } else {
            return AltitudeAffiche.HAUTE;
        }
    }

    public HydrometrieAffiche getHydrometrieAffichee(int x, int y) throws TerrainInexistant {

        Terrain terrain = carte.getTerrain(x, y);

        if (terrain == null) {
            throw new TerrainInexistant("Terrain inexistant");
        }
        double hydrometrie = terrain.getHydrometrie();

        if (hydrometrie < 0.33) {
            return HydrometrieAffiche.SEC;
        } else if (hydrometrie < 0.66) {
            return HydrometrieAffiche.MOYEN;
        } else {
            return HydrometrieAffiche.HUMIDE;
        }
    }

    public TemperatureAffiche getTemperatureAffichee(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);

        if (terrain == null) {
            throw new TerrainInexistant("Terrain inexistant");
        }
        double temperature = terrain.getTemperature();

        if (temperature < 10) {
            return TemperatureAffiche.FROID;
        } else if (temperature < 20) {
            return TemperatureAffiche.TEMPERE;
        } else {
            return TemperatureAffiche.CHAUD;
        }
    }

    public TypeTerrain getTypeTerrain(int x, int y) throws TerrainInexistant {
        Terrain terrain = carte.getTerrain(x, y);

        if (terrain == null) {
            throw new TerrainInexistant("Terrain inexistant");
        }

        double altitude = terrain.getAltitude();
        double hydro = terrain.getHydrometrie();
        double temp = terrain.getTemperature();

        return determineurTerrain.determinerTerrain(altitude,hydro,temp);
    }
}
