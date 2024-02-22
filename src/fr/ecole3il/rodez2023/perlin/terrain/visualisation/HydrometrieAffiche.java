package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

public enum HydrometrieAffiche {
    SEC(0.33),
    MOYEN(0.66),
    HUMIDE(1.0);

    private final double hydrometrie;

    HydrometrieAffiche(double hydrometrie) {
        this.hydrometrie = hydrometrie;
    }
    public double getHydrometrieAffiche() {
        return hydrometrie;
    }
}
