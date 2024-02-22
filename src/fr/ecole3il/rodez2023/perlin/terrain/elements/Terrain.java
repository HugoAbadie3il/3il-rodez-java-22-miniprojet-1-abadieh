package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double hydrometrie;
    private double altitude;
    private double temperature;

    public double getHydrometrie() {
        return hydrometrie;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public Terrain(double altitude, double hydrometrie, double temperature) throws MauvaiseValeurException {
        hydrometrie = Math.abs(hydrometrie);
        temperature = Math.abs(temperature);

        if (hydrometrie < 0 || hydrometrie > 1)
            throw new MauvaiseValeurException("L'hydrométrie doit être comprise entre 0 et 1");
        else
            this.hydrometrie = hydrometrie;

        if (temperature < 0 || temperature > 1)
            throw new MauvaiseValeurException("La température doit être comprise entre 0 et 1");
        else
            this.altitude = altitude;

        if (altitude < -1 || altitude > 1)
            throw new MauvaiseValeurException("L'altitude doit être comprise entre -1 et 1");
        else
            this.temperature = temperature;
    }

    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(altitude,hydrometrie,temperature);
    }
}
