package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum TemperatureAffiche {
    FROID(0.0),
    TEMPERE(10.0),
    CHAUD(20.0);

    private final double temperature;

    TemperatureAffiche(double temperature) {
        this.temperature = temperature;
    }
    public double getTemperatureAffiche() {
        return temperature;
    }
}
