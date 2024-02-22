package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum AltitudeAffiche {
    FONDMARIN(-1.0),
    BASSE(0.33),
    MOYENNE(0.66),
    HAUTE(1.0);

    private final double altitude;

    AltitudeAffiche(double altitude) {
        this.altitude = altitude;
    }
    public double getAltitudeAffiche() {
        return altitude;
    }
}
