package fr.ecole3il.rodez2023.perlin.terrain;

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

    public Terrain(double hydrometrie, double altitude, double temperature) throws MauvaiseValeurException {
        if (hydrometrie < 0 || hydrometrie > 1)
            throw MauvaiseValeurException();
        this.hydrometrie = hydrometrie;
        this.altitude = altitude;
        this.temperature = temperature;
    }
}
